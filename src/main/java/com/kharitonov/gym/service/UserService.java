package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.security.WebCipher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static final Logger LOGGER =
            LogManager.getLogger(UserService.class);
    private static UserService instance;
    private final UserDaoImpl dao;

    private UserService() {
        dao = new UserDaoImpl();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean checkLoginPassword(String login, String password)
            throws ServiceException {
        boolean result;
        WebCipher cipher = new WebCipher();
        byte[] sourceBytes = password.getBytes();
        byte[] encryptedBytes = cipher.encryptMessage(sourceBytes);
        try {
            result = dao.checkLoginPassword(login, encryptedBytes);
            LOGGER.info("Login result: {}", result);
        } catch (DaoException e) {
            throw new ServiceException("Error, accessing database!", e);
        }
        return result;
    }

    public boolean registerUser(String login, String password, String email)
            throws ServiceException {
        WebCipher cipher = new WebCipher();
        byte[] sourceBytes = password.getBytes();
        byte[] encryptedBytes = cipher.encryptMessage(sourceBytes);
        Account account = Account.AccountBuilder.anAccount()
                .withName(login)
                .withType(UserRole.CLIENT)
                .build();
        User user = User.UserBuilder.aUser()
                .withAccount(account)
                .withEmail(email)
                .build();
        boolean result;
        try {
            dao.add(user, encryptedBytes);
            result = true;
            LOGGER.info("User '{}' was successfully registered!", login);
        } catch (DaoException e) {
            throw new ServiceException("Unable to register new user!", e);
        }
        return result;
    }
}
