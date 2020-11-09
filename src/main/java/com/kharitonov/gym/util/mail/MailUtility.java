package com.kharitonov.gym.util.mail;

import com.kharitonov.gym.exception.PropertyReaderException;
import com.kharitonov.gym.util.PropertiesPath;
import com.kharitonov.gym.util.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class MailUtility {
    private static final Logger LOGGER = LogManager.getLogger(MailUtility.class);
    private static final String MESSAGE_TEXT = "Here is your confirmation link: \n%s";
    private static final String MESSAGE_SUBJECT = "Email confirmation";
    private static final String CONFIRM_LINK = "http://localhost:8083/mainController?command=confirm_account&id=%d";

    private MailUtility() {
    }

    public static void sendConfirmMessage(String email, int id) {
        PropertiesReader reader = new PropertiesReader();
        String path = PropertiesPath.MAIL_PROPERTIES;
        String confirmLink = prepareConfirmLink(id);
        String text = String.format(MESSAGE_TEXT, confirmLink);
        try {
            Properties properties = reader.readProperties(path);
            MailSender sender = new MailSender(email, MESSAGE_SUBJECT, text, properties);
            sender.send();
            LOGGER.info("Confirmation link was sent to '{}'", email);
        } catch (PropertyReaderException e) {
            LOGGER.error("Error reading email properties, link to {} was not sent", email, e);
        }
    }

    public static boolean sendMessage(String email, String subject, String message) {
        PropertiesReader reader = new PropertiesReader();
        String path = PropertiesPath.MAIL_PROPERTIES;
        boolean result;
        try {
            Properties properties = reader.readProperties(path);
            MailSender sender = new MailSender(email, subject, message, properties);
            sender.send();
            LOGGER.info("Message was successfully sent to '{}'", email);
            result = true;
        } catch (PropertyReaderException e) {
            LOGGER.error("Error reading email properties, message to {} was not sent", email, e);
            result = false;
        }
        return result;
    }

    private static String prepareConfirmLink(int id) {
        return String.format(CONFIRM_LINK, id);
    }
}
