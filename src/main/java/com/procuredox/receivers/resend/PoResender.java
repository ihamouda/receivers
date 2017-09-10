package com.procuredox.receivers.resend;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.MyDataSourceFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.UUID;

/**
 * @author procuredox on 8/31/17.
 */
public class PoResender {
    private static final Logger log = LoggerFactory.getLogger(PoResender.class);

    private static final String BATCH_PATH;
    private static final String BROCKER_URL;
    static {
        final AppResources resources = AppResources.getInstance();
        BATCH_PATH = resources.getRb().getString("unc") + "Share/Attachments/";
        BROCKER_URL = resources.getRb().getString("amq");
    }

    private final DataSource mysqlDS;

    public PoResender() {
        this.mysqlDS = MyDataSourceFactory.getMySQLDataSource();
    }

    public void resend(int batchNumber) throws Exception {
        try (final InputStream is = new FileInputStream(findFile(batchNumber))) {
            final String content = IOUtils.toString(is);
            final BatchData data = loadData(batchNumber);
            if (content.contains("FunctionalAcknowledgement")) {
                final String filename = fnAckFilename(batchNumber, data);
                sendFileToBroker(content, data.getVendorCode(), batchNumber, null, filename);
            } else {
                final String filename = filename(batchNumber, data);
                changeStatusTo(data.getMsgId(), "DROPPEDVENDOR");
                sendFileToBroker(content, data.getVendorCode(), batchNumber, data.getMsgId(), filename);
            }
        }
    }

    private String fnAckFilename(int batchNumber, BatchData data) {
        final String uuid = UUID.randomUUID().toString();
        switch (DocType.valueOf(data.getDocType())) {
            case INV: return String.format("fnAck_Invoice_%s_%s_%s.xml", batchNumber, data.getReceiverIndetifier(), normalize(uuid));
            case POACK: return String.format("fnAck_PurchaseOrderAcknowledgement_%s_%s_%s.xml", batchNumber, data.getReceiverIndetifier(), normalize(uuid));
            default: return "fnAck.xml";
        }
    }

    private String filename(int batchNumber, BatchData data) {
        switch (DocType.valueOf(data.getDocType())) {
            case PO: return String.format("PO_%s_%s_%s.xml", data.getReceiverIndetifier(), batchNumber, data.getDocumentNumber());
            case INVRES: {
                if (data.getBuyerCode().toUpperCase().contains("IOL")) {
                    return String.format("InvoiceResponse_%s_%s_%s.xml", data.getVendorCode(), batchNumber, data.getResponseForInvoice());
                } else {
                    return String.format("InvoiceResponse_%s_%s_%s.xml", data.getReceiverIndetifier(), batchNumber, data.getResponseForInvoice());
                }
            }
            default: return "filename.xml";
        }

    }

    private String normalize(String uuid) {
        return uuid.replaceAll("-", "");
    }

    private void sendFileToBroker(String content, String partnerCode, int batchNumber, String msgId, String filename) throws JMSException, IOException {
        final ActiveMQConnectionFactory amqConnectionFactory = getAMQFactory();

        final javax.jms.Connection connection = amqConnectionFactory.createConnection();
        try {
            connection.start();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            try {
                final Queue queue = session.createQueue("vendor.out.code." + partnerCode.toLowerCase());

                final MessageProducer producer = session.createProducer(queue);
                final TextMessage message = session.createTextMessage();
                message.setStringProperty("Folder", UUID.randomUUID().toString());
                message.setStringProperty("BatchNumber", String.valueOf(batchNumber));
                message.setStringProperty("MsgId", msgId);
                message.setStringProperty("OutputFilename", filename);
                message.setText(content);
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

    private ActiveMQConnectionFactory getAMQFactory() {
        final ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory(BROCKER_URL);
        amqConnectionFactory.setUserName("admin");
        amqConnectionFactory.setPassword("admin");
        return amqConnectionFactory;
    }

    private BatchData loadData(int batchNumber) throws SQLException {
        try (final Connection connection = mysqlDS.getConnection()) {
            final String sql = "select " +
                    "s.partner_code as sender_code, " +
                    "r.partner_code as receiver_code, " +
                    "t.documenttype_code as doc_type, " +
                    "p.sender_identifier as sender_identifier, " +
                    "p.receiver_identifier as receiver_identifier, " +
                    "d.document_number as document_number, " +
                    "d.invoice_number as invoice_number, " +
                    "d.msg_id as msg_id " +
                    "from batch b  " +
                    "join partnership p on p.partnership_id = b.partnership_id " +
                    "join partner s on s.partner_id = p.sender_id " +
                    "join partner r on r.partner_id = p.receiver_id " +
                    "join document d on d.batch_id = b.batch_id " +
                    "join documenttype t on t.documenttype_id = d.document_type_id " +
                    "where b.batch_number = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, batchNumber);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new BatchData(
                        resultSet.getString("sender_code"),
                        resultSet.getString("receiver_code"),
                        resultSet.getString("doc_type"),
                        resultSet.getString("msg_id"),
                        resultSet.getString("sender_identifier"),
                        resultSet.getString("receiver_identifier"),
                        resultSet.getString("document_number"),
                        resultSet.getString("invoice_number")
                );
            }
            throw new PartnerNotFound("data is not found for given code");
        }
    }

    private void changeStatusTo(String msgId, String status) throws SQLException {
        try (final Connection connection = mysqlDS.getConnection()) {
            final CallableStatement statement = connection.prepareCall("{call procUpdateDoc(?,?,?)}");
            statement.setString(1, msgId);
            statement.setString(2, status);
            statement.setString(3, null);
            statement.execute();
        }
    }

    private File findFile(int batchNumber) {
        final String location = directoryForBatch(batchNumber);

        final File transformedVendor = new File(location + "/to-vendor-transformed.xml");
        if (transformedVendor.exists()) {
            return transformedVendor;
        }

        final File vendor = new File(location + "/vendor.xml");
        if (vendor.exists()) {
            return vendor;
        }

        throw new BatchFileNotFound("can't locate file for batch: " + batchNumber);
    }

    private String directoryForBatch(int batchNumber) {
        return BATCH_PATH + batchNumber + "/Document";
    }
}