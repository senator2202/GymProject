package com.kharitonov.gym.service.db;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.factory.UserFactory;
import com.kharitonov.gym.service.mail.MailService;
import com.kharitonov.gym.service.security.CryptoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

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

    public Optional<UserRole> checkLoginPassword(String login, String password)
            throws ServiceException {
        CryptoService cryptoService = new CryptoService();
        String encryptedPassword = cryptoService.encryptMessage(password);
        Optional<UserRole> optional;
        try {
            optional = dao.checkLoginPassword(login, encryptedPassword);
            LOGGER.info("Login result: {}", optional.isPresent());
        } catch (DaoException e) {
            throw new ServiceException("Error, accessing database!", e);
        }
        return optional;
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
        CryptoService cryptoService = new CryptoService();
        String encryptedPassword = cryptoService.encryptMessage(password);
        User user = UserFactory.createUser(role);
        user.getAccount().setName(login);
        user.getAccount().setEmail(email);
        try {
            MailService service;
            dao.add(user, encryptedPassword);
            service = MailService.getInstance();
            service.sendConfirmMessage(email, user.getAccount().getId());
            LOGGER.info("User '{}' was successfully registered!", login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void confirmAccount(int id) throws ServiceException {
        if (id < 0) {
            throw new ServiceException("Incorrect id value!");
        }
        try {
            dao.confirmAccount(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
