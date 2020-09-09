package com.kharitonov.gym.service.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    private static final Logger LOGGER = LogManager.getLogger(MailSender.class);
    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;

    public MailSender(String sendToEmail, String mailSubject, String mailText,
                      Properties properties) {
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = properties;
    }

    public void send() {
        try {
            initMessage();
            Transport.send(message); // sending mail
            LOGGER.info("Message to '{}' was successfully send!", mailSubject);
        } catch (AddressException e) {
            LOGGER.error("Invalid email address: ", e); // in log
        } catch (MessagingException e) {
            LOGGER.error("Error generating or sending message: ", e); // in log
        }
    }

    private void initMessage() throws MessagingException {
        Session mailSession = null;
        try {
            mailSession = SessionFactory.createSession(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSession.setDebug(true);
        message = new MimeMessage(mailSession); // create a mailing object
        // loading parameters into the mail message object
        message.setSubject(mailSubject);
        message.setContent(mailText, "text/html");
        message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(sendToEmail));
    }
}
