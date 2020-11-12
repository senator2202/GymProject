package com.kharitonov.gym.util.mail;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * The type Session factory.
 */
public class SessionFactory {
    private SessionFactory() {
    }

    /**
     * Create session session.
     *
     * @param configProperties the config properties
     * @return the session
     */
    public static Session createSession(Properties configProperties) {
        String userName = configProperties.getProperty("mail.user.name");
        String userPassword = configProperties.getProperty("mail.user.password");
        try {
            return Session.getDefaultInstance(configProperties,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(userName, userPassword);
                        }
                    });
        } catch (Exception e) {
            return null;
        }
    }
}