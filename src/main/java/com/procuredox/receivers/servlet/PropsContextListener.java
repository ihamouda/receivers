package com.procuredox.receivers.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.Properties;

/**
 * @author maxim.krestovsky@gmail.com on 10/2/17.
 */
public class PropsContextListener implements ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(PropsContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        final String fileName = "/receivers-config.properties";

        final Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            log.error("can't find application properties", e);
        }

        for(String prop :properties.stringPropertyNames()) {
            if(System.getProperty(prop) == null) {
                System.setProperty(prop, properties.getProperty(prop));
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}