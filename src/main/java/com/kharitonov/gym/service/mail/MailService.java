package com.kharitonov.gym.service.mail;

import com.kharitonov.gym.exception.PropertiesReaderException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.util.PropertiesPath;
import com.kharitonov.gym.util.PropertiesReader;

import java.util.Properties;

public class MailService {
    private static final String MESSAGE_TEXT = "Thank you!";
    private static final String MESSAGE_SUBJECT = "Email confirmation";

    public void sendConfirmMessage(String email) throws ServiceException {
        PropertiesReader reader = new PropertiesReader();
        String path = PropertiesPath.MAIL_PROPERTIES;
        Properties properties;
        try {
            properties = reader.readProperties(path);
        } catch (PropertiesReaderException e) {
            throw new ServiceException("Unable to read mail properties!", e);
        }
        MailSender sender = new MailSender(email, MESSAGE_SUBJECT,
                MESSAGE_TEXT, properties);
        sender.send();
    }
}
