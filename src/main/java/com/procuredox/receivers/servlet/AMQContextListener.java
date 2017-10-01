package com.procuredox.receivers.servlet;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author maxim.krestovsky@gmail.com on 10/2/17.
 */
public class AMQContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(AMQContextListener.class);

    private Connection connection;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        final ServletContext sc = event.getServletContext();

        final String brokerUrl = (String) sc.getAttribute("amq.url");
        final String brokerUser = (String) sc.getAttribute("amq.user");
        final String brokerPass = (String) sc.getAttribute("amq.pass");

        final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        connectionFactory.setUserName(brokerUser);
        connectionFactory.setPassword(brokerPass);

        try {
            connection = connectionFactory.createConnection();
            connection.start();

            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            sc.setAttribute("AMQSession", session);
        } catch (JMSException e) {
            log.error("can't create ActiveMQ connection", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if(connection != null) {
            try {
                connection.close();
            } catch (JMSException e) {
                //ignore exception;
            }
        }
    }
}