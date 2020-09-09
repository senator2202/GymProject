package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.factory.UserFactory;
import com.kharitonov.gym.service.security.CipherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static final String REGEX_EMAIL =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
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
        CipherService cipher = new CipherService();
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

    public void registerUser(String login, String password,
                             String email, UserRole role)
            throws ServiceException {
        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            throw new ServiceException("All fields must be entered!");
        }
        if (!email.matches(REGEX_EMAIL)) {
            throw new ServiceException("Invalid email format!");
        }
        CipherService cipher = new CipherService();
        byte[] sourceBytes = password.getBytes();
        byte[] encryptedBytes = cipher.encryptMessage(sourceBytes);
        User user = UserFactory.createUser(role);
        user.getAccount().setName(login);
        user.getAccount().setEmail(email);
        try {
            dao.add(user, encryptedBytes);
            LOGGER.info("User '{}' was successfully registered!", login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
