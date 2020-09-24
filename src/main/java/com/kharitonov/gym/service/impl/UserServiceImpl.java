package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.factory.UserFactory;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.util.CryptoUtility;
import com.kharitonov.gym.util.mail.MailUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final String REGEX_EMAIL =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Logger LOGGER =
            LogManager.getLogger(UserServiceImpl.class);
    private final UserDaoImpl dao;

    public UserServiceImpl() {
        dao = new UserDaoImpl();
    }

    @Override
    public Optional<User> getUser(String login, String password)
            throws ServiceException {
        CryptoUtility cryptoUtility = new CryptoUtility();
        String encryptedPassword = cryptoUtility.encryptMessage(password);
        Optional<User> optional;
        try {
            optional = dao.getUser(login, encryptedPassword);
            LOGGER.info("Login result: {}", optional.isPresent());
        } catch (DaoException e) {
            throw new ServiceException("Error, accessing database!", e);
        }
        return optional;
    }

    @Override
    public void registerUser(String login, String password,
                             String email, UserRole role)
            throws ServiceException {
        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            throw new ServiceException("All fields must be entered!");
        }
        if (!email.matches(REGEX_EMAIL)) {
            throw new ServiceException("Invalid email format!");
        }
        CryptoUtility cryptoUtility = new CryptoUtility();
        String encryptedPassword = cryptoUtility.encryptMessage(password);
        User user = UserFactory.createUser(role);
        user.getAccount().setName(login);
        user.getAccount().setEmail(email);
        try {
            MailUtility service;
            dao.add(user, encryptedPassword);
            service = MailUtility.getInstance();
            service.sendConfirmMessage(email, user.getAccount().getId());
            LOGGER.info("User '{}' was successfully registered!", login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void confirmAccount(int id) throws ServiceException {
        if (id < 0) {
            throw new ServiceException("Incorrect id value!");
        }
        try {
            dao.confirmAccount(id);
            LOGGER.info("Account id={} was confirmed!", id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserInfo(String firstName, String lastName, String phone, String locale, int id)
            throws ServiceException {
        try {
            dao.updateUserInfo(firstName, lastName, phone, locale, id);
            LOGGER.info("Account id={} was updated!", id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
