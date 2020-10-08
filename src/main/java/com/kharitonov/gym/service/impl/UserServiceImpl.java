package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.util.CryptoUtility;
import com.kharitonov.gym.util.mail.MailUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private static final String REGEX_EMAIL =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Logger LOGGER =
            LogManager.getLogger(UserServiceImpl.class);


    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(String login, String password)
            throws ServiceException {
        CryptoUtility cryptoUtility = new CryptoUtility();
        String encryptedPassword = cryptoUtility.encryptMessage(password);
        UserDao dao = new UserDaoImpl();
        Optional<User> optional;
        try {
            optional = dao.findUser(login, encryptedPassword);
            LOGGER.info("Login result: {}", optional.isPresent());
        } catch (DaoException e) {
            throw new ServiceException("Error, accessing database!", e);
        }
        return optional;
    }

    @Override
    public User registerUser(String login, String password, String email)
            throws ServiceException {
        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            throw new ServiceException("All fields must be entered!");
        }
        if (!email.matches(REGEX_EMAIL)) {
            throw new ServiceException("Invalid email format!");
        }
        CryptoUtility cryptoUtility = new CryptoUtility();
        String encryptedPassword = cryptoUtility.encryptMessage(password);
        UserDao dao = new UserDaoImpl();
        try {
            MailUtility service;
            dao.addUser(login, encryptedPassword, email);
            User user = dao.findUser(login, encryptedPassword).get();
            service = MailUtility.getInstance();
            service.sendConfirmMessage(email, user.getAccount().getId());
            LOGGER.info("User '{}' was successfully registered!", login);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void confirmAccount(int id) throws ServiceException {
        if (id < 0) {
            throw new ServiceException("Incorrect id value!");
        }
        UserDao dao = new UserDaoImpl();
        try {
            dao.confirmAccount(id);
            LOGGER.info("Account id={} was confirmed!", id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateUserInfo(String firstName, String lastName, String phone,
                               String email, String locale, int id)
            throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateUserInfo(firstName, lastName, phone, email, locale, id);
            LOGGER.info("Account id={} was updated!", id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void appointTrainer(int userId, String institution,
                               int graduationYear, String instagramLink) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.changeRoleToTrainer(userId, institution, graduationYear, instagramLink);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findRecentUsers(int days) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            return dao.findRecentUsers(days);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
