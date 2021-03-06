package com.procuredox.receivers.resend;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.MyDataSourceFactory;
import com.procuredox.receivers.cat.cXML.Vendor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.sql.DataSource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.nio.file.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author procuredox on 12/12/17.
 */
public class VendorResender {
    private static final Logger log = LoggerFactory.getLogger(VendorResender.class);

    private static final String BATCH_PATH;
    private static final String SESSION_PATH;
    private static final String BROKER_URL;
    static {
        final AppResources resources = AppResources.getInstance();
        BATCH_PATH = resources.getRb().getString("unc") + "Share/Attachments/";
        SESSION_PATH = resources.getRb().getString("unc") + "Sessions/";
        BROKER_URL = resources.getRb().getString("amq");
    }

    private final DataSource mysqlDS;

    public VendorResender() {
        this.mysqlDS = MyDataSourceFactory.getMySQLDataSource();
    }

    public void resend(int batchNumber) throws Exception {
        String rootName = null;
        String securityKey = null;
        String transmitType = null;

        final String session = UUID.randomUUID().toString();

        copyPdfToSession(batchNumber, session);

        final File file = findXmlFile(batchNumber);
        try (final InputStream is = new FileInputStream(file)) {
            final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = null;
            try {
                reader = inputFactory.createXMLStreamReader(is);
                reader.nextTag();

                rootName = reader.getLocalName();
                for (int i=0; i<reader.getAttributeCount(); i++) {
                    final String attributeName = reader.getAttributeLocalName(i);
                    if ("SharedKey".equalsIgnoreCase(attributeName)) {
                        securityKey = reader.getAttributeValue(i);
                    } else if ("deploymentMode".equalsIgnoreCase(attributeName)) {
                        transmitType = reader.getAttributeValue(i);
                    }
                }


            } finally {
                if (Objects.nonNull(reader)) {
                    reader.close();
                }
            }
        }

        final XpathsData xpathsData = loadData(securityKey, rootName);
        final IdsData idsData = loadResendHeaders(batchNumber);
        sendFileToBroker(session, file, batchNumber, xpathsData, idsData, transmitType, securityKey, rootName);
    }

    private ActiveMQConnectionFactory getAMQFactory() {
        final ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        amqConnectionFactory.setUserName("admin");
        amqConnectionFactory.setPassword("admin");
        return amqConnectionFactory;
    }

    private void sendFileToBroker(String sessionName, File file, int batchNumber, XpathsData data, IdsData idsData, String transmitType, String secKey, String rootName) throws JMSException, IOException {
        final ActiveMQConnectionFactory amqConnectionFactory = getAMQFactory();

        final javax.jms.Connection connection = amqConnectionFactory.createConnection();
        try {
            connection.start();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            try {
                final Queue queue = session.createQueue("vendor.receive");

                final MessageProducer producer = session.createProducer(queue);
                final TextMessage message = session.createTextMessage();
                message.setBooleanProperty("IsResend", true);
                message.setStringProperty("Folder", sessionName);
                message.setStringProperty("BatchNumber", String.valueOf(batchNumber));
                message.setStringProperty("DocumentId", idsData.getDocumentId());
                message.setStringProperty("BatchId", idsData.getBatchId());
                message.setStringProperty("MsgId", idsData.getMsgId());
                message.setStringProperty("TransmitType", transmitType);
                message.setStringProperty("SecurityKey", secKey);
                message.setStringProperty("file_name", file.getName());
                message.setStringProperty("ReceiverIdentifierXpath", defaultIfEmpty(data.getReceiverIdentifier(), ""));
                message.setStringProperty("SenderIdentifierXpath", defaultIfEmpty(data.getSenderIdentifier(), ""));
                message.setStringProperty("DocumentTypeXpath", defaultIfEmpty(data.getDocumentType(), ""));
                message.setStringProperty("CustomerCode", defaultIfEmpty(data.getHascode(), ""));
                try (final FileInputStream input = new FileInputStream(file)) {
                    message.setText(IOUtils.toString(input));
                }

                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                producer.send(message);
            } finally {
                if (session != null) {
                    try {
                        session.close();
                    } catch (JMSException e) {
                        //ignore exception
                    }
                }
            }
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    //ignore exception;
                }
            }
        }
    }

    protected XpathsData loadData(String securityKey, String rootName) throws SQLException {
        try (final java.sql.Connection connection = mysqlDS.getConnection()) {
            final String sql = "call vendor_doc_xpath(?, ?)";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, securityKey);
            statement.setString(2, rootName);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new XpathsData(
                        resultSet.getString("sender_identifier_xpath"),
                        resultSet.getString("receiver_identifier_xpath"),
                        resultSet.getString("document_type_xpath"),
                        resultSet.getString("hascode"));
            }
            throw new PartnerNotFound("data is not found for given code");
        }
    }

    private IdsData loadResendHeaders(int batchNumber) throws SQLException {
        try (final java.sql.Connection connection = mysqlDS.getConnection()) {
            final String sql = "select " +
                    "d.document_id as document_id, " +
                    "b.batch_id as batch_id, " +
                    "d.msg_id as msg_id " +
                    "from batch b  " +
                    "join partnership p on p.partnership_id = b.partnership_id " +
                    "join document d on d.batch_id = b.batch_id " +
                    "where b.batch_number = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, batchNumber);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new IdsData(
                        resultSet.getString("document_id"),
                        resultSet.getString("batch_id"),
                        resultSet.getString("msg_id")
                );
            }
            throw new PartnerNotFound("ids is not found for given code");
        }
    }

    private void copyPdfToSession(int batchNumber, String session) {
        final String location = directoryForSession(session);
        log.debug("try to copy pdf files to new session [{}]", location);
        try {
            Files.createDirectories(Paths.get(location));
            findPdfFiles(batchNumber).forEach(pdf -> {
                final String filename = pdf.getFileName().toString();
                log.debug("coping file [{}] to session [{}]", filename, session);
                try (final OutputStream out = Files.newOutputStream(Paths.get(location, filename))) {
                    Files.copy(pdf, out);
                } catch (IOException e) {
                    throw new RuntimeException("can't copy pdf to session", e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("can't create session directory");
        }
    }

    private List<Path> findPdfFiles(int batchNumber) {
        return findFilesAndMakeAction(batchNumber, "pdf", stream -> stream.collect(Collectors.toList()));
    }

    private File findXmlFile(int batchNumber) {
        return findFilesAndMakeAction(batchNumber, "xml", stream -> {
            final Optional<Path> firstFile = stream.findFirst();
            return firstFile.map(Path::toFile)
                    .orElseThrow(() -> new BatchFileNotFound("can't locate file for batch: " + batchNumber));
        });
    }

    private <T> T findFilesAndMakeAction(int batchNumber, String extension, Function<Stream<Path>, ? extends T> consumer) {
        final String location = directoryForBatch(batchNumber);
        log.debug("try to find files in [{}]", location);

        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(location))) {
            final Stream<Path> stream = StreamSupport
                    .stream(directoryStream.spliterator(), false)
                    .filter(path -> path.toString().toLowerCase().endsWith("." + extension));
            return consumer.apply(stream);
        } catch (IOException e) {
            throw new RuntimeException("can't read batch directory", e);
        }
    }

    private String directoryForBatch(int batchNumber) {
        return BATCH_PATH + batchNumber;
    }

    private String directoryForSession(String session) {
        return SESSION_PATH + session;
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
        return isEmpty(str)?defaultStr:str;
    }
}