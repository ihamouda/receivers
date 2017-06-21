package com.procuredox.receivers;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.NumberTool;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by ihamouda on 2017-06-21.
 */
public class SendEmail {


    public static SendEmail instance = new SendEmail();
    private static AppResources rb = AppResources.getInstance();

    public static SendEmail getInstance() {
        return instance;
    }



    private SendEmail() {
    }

    public boolean sendEmail(String id) {
        try {
            final String fromEmail = rb.getRb().getString("username");
            final String password = rb.getRb().getString("password");
            final String host = rb.getRb().getString("host");
            final String port = rb.getRb().getString("port");
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };


            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            msg.setSubject("PO from TradeShift", "UTF-8");

            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            ve.setProperty("runtime.log.logsystem.log4j.logger", SendEmail.class.getName());
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            ve.init();
            Template t = ve.getTemplate("templates/email.vm");
            VelocityContext ctx = new VelocityContext();
            ctx.put("id", id);
            StringWriter writer = new StringWriter();
            t.merge(ctx, writer);

            msg.setContent(writer.toString(), "text/html");

            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("integration@procuredox.com", false));
            Transport.send(msg);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
