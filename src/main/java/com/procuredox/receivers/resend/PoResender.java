package com.procuredox.receivers.resend;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.MyDataSourceFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.sql.DataSource;
import java.io.*;
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

    public void resend(String secretKey, int batchNumber, String filename) throws Exception {
        try (final InputStream is = new FileInputStream(findFile(batchNumber))) {
            final String content = IOUtils.toString(is);
            final String partnerCode = loadPartnerCode(secretKey);
            final String msgId = loadMsgId(batchNumber);
            sendFileToBroker(content, partnerCode, batchNumber, msgId, filename);
        }
    }

    private void sendFileToBroker(String content, String partnerCode, int batchNumber, String msgId, String filename) throws JMSException, IOException {
        final ActiveMQConnectionFactory amqConnectionFactory = getAMQFactory();

        final javax.jms.Connection connection = amqConnectionFactory.createConnection();
        try {
            connection.start();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            try {
                final Queue queue = session.createQueue("vendor.out.code." + partnerCode);

                final MessageProducer producer = session.createProducer(queue);
                final TextMessage message = session.createTextMessage();
                message.setStringProperty("Folder", UUID.randomUUID().toString());
                message.setStringProperty("BatchNumber", String.valueOf(batchNumber));
                if (!content.contains("FunctionalAcknowledgement")) {
                    message.setStringProperty("MsgId", msgId);
                }
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

    private String loadPartnerCode(String secretKey) throws SQLException {
        try (final Connection connection = mysqlDS.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("select partner_code from partner where partner_key = ?");
            statement.setString(1, secretKey);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("partner_code");
            }
            throw new PartnerNotFound("partner is not found for given code");
        }
    }

    private String loadMsgId(int batchNumber) throws SQLException {
        try (final Connection connection = mysqlDS.getConnection()) {
            final String sql = "select d.msg_id from document d join batch b on d.batch_id = b.batch_id where b.batch_number = ?";
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, batchNumber);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("msg_id");
            }
            throw new DocumentNotFound("can't find document for given batch number: " + batchNumber);
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
        return BATCH_PATH + "Document/" + batchNumber;
    }
}