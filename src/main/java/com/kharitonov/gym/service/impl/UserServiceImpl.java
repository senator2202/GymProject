package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.PropertyReaderException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.util.CryptoUtility;
import com.kharitonov.gym.util.mail.MailUtility;
import com.kharitonov.gym.util.validator.FormValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private static final String SPACE = " ";
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);


    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(Map<String, String> parameters)
            throws ServiceException {
        if (!FormValidator.validateLoginParameters(parameters)) {
            return Optional.empty();
        }
        String login = parameters.get(RequestParameterName.LOGIN);
        String password = parameters.get(RequestParameterName.LOGIN_PASSWORD);
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
    public Optional<User> registerUser(Map<String, String> parameters)
            throws ServiceException {
        if (!FormValidator.validateRegisterParameters(parameters)) {
            return Optional.empty();
        }
        String login = parameters.get(RequestParameterName.REGISTRATION_LOGIN);
        String password = parameters.get(RequestParameterName.REGISTRATION_PASSWORD);
        String email = parameters.get(RequestParameterName.REGISTRATION_EMAIL);
        CryptoUtility cryptoUtility = new CryptoUtility();
        String encryptedPassword = cryptoUtility.encryptMessage(password);
        UserDao dao = new UserDaoImpl();
        try {
            if (dao.findByLogin(login) || dao.findByEmail(email)) {
                return Optional.empty();
            }
            MailUtility service;
            User user;
            dao.addUser(login, encryptedPassword, email);
            user = dao.findUser(login, encryptedPassword).get();
            service = new MailUtility();
            try {
                service.sendConfirmMessage(email, user.getAccount().getId());
                LOGGER.info("User '{}' was successfully registered!", login);
            } catch (PropertyReaderException e) {
                LOGGER.error("Error occurred while sending confirmation link!", e);
            }
            return Optional.of(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void confirmAccount(int id) throws ServiceException {
        if (id < 1) {
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
    public boolean updateAccountData(int userId, String email, String locale) throws ServiceException {
        if (!FormValidator.validateEmail(email)) {
            return false;
        }
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateAccountData(userId, email, locale);
            return true;
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
    public void updatePersonalData(int userId, String firstName, String lastName, String phone)
            throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.updatePersonalData(userId, firstName, lastName, phone);
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

    @Override
    public void updateUserImage(int userId, String imageName) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateUserImage(userId, imageName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void buyTrainings(Client client, int trainingsNumber, double trainingCost) throws ServiceException {
        double discount = client.getPersonalDiscount();
        double balance = client.getMoneyBalance();
        double sum = trainingsNumber * trainingCost;
        double absoluteDiscount = sum * discount / 100;
        sum -= absoluteDiscount;
        if (balance < sum) {
            throw new ServiceException("Money balance is too low!");
        }
        int id = client.getAccount().getId();
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateBalanceAndBoughtTrainings(id, sum, trainingsNumber);
            client.setBoughtTrainings(client.getBoughtTrainings() + trainingsNumber);
            client.setMoneyBalance(client.getMoneyBalance() - sum);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAllTrainers() throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            return dao.findAllTrainers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int findId(String name) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        String[] temp = name.split(SPACE);
        String firstName = temp[0];
        String lastName = temp[1];
        try {
            return dao.findId(firstName, lastName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addToBalance(int clientId, String stringAmount) throws ServiceException {
        int amount;
        try {
            amount = Integer.parseInt(stringAmount);
        } catch (NumberFormatException e) {
            return false;
        }
        UserDao dao = new UserDaoImpl();
        try {
            dao.addToBalance(clientId, amount);
            return true;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<String> findEmailById(int userId) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            return dao.findEmailById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void blockUser(int userId) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.blockUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void unblockUser(int userId) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            dao.unblockUser(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateRating(String trainerId, double rating) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        int id = Integer.parseInt(trainerId);
        try {
            dao.updateRating(id, rating);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateDiscount(String clientId, String personalDiscount) throws ServiceException {
        UserDao dao = new UserDaoImpl();
        try {
            int id = Integer.parseInt(clientId);
            double discount = Double.parseDouble(personalDiscount);
            dao.updateDiscount(id, discount);
        } catch (NumberFormatException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}
