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
import com.kharitonov.gym.validator.TrainingValidator;
import com.kharitonov.gym.validator.UserValidator;
import com.kharitonov.gym.validator.ValidationError;
import com.kharitonov.gym.validator.ValidationErrorSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private static final int DEFAULT_USERS_NUMBER = 30;


    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(Map<String, String> parameters)
            throws ServiceException {
        if (!UserValidator.correctLoginParameters(parameters)) {
            return Optional.empty();
        }
        String login = parameters.get(RequestParameterName.LOGIN);
        String password = parameters.get(RequestParameterName.LOGIN_PASSWORD);
        String encryptedPassword = CryptoUtility.encryptMessage(password);
        UserDao dao = new UserDaoImpl();
        Optional<User> optional;
        try {
            optional = dao.findUser(login, encryptedPassword);
            if (optional.isEmpty()) {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                errorSet.add(ValidationError.WRONG_LOGIN_PASSWORD);
            }
            LOGGER.info("Login result: {}", optional.isPresent());
        } catch (DaoException e) {
            throw new ServiceException("Error, accessing database!", e);
        }
        return optional;
    }

    @Override
    public Optional<User> registerUser(Map<String, String> parameters)
            throws ServiceException {
        if (!UserValidator.correctRegisterParameters(parameters)) {
            return Optional.empty();
        }
        String login = parameters.get(RequestParameterName.REGISTRATION_LOGIN);
        String password = parameters.get(RequestParameterName.REGISTRATION_PASSWORD);
        String email = parameters.get(RequestParameterName.REGISTRATION_EMAIL);
        String encryptedPassword = CryptoUtility.encryptMessage(password);
        UserDao dao = new UserDaoImpl();
        try {
            ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
            boolean exists = false;
            if (dao.findByLogin(login)) {
                errorSet.add(ValidationError.LOGIN_EXISTS);
                exists = true;
            }
            if (dao.findByEmail(email)) {
                errorSet.add(ValidationError.EMAIL_EXISTS);
                exists = true;
            }
            if (exists) {
                return Optional.empty();
            }
            int id = dao.addUser(login, encryptedPassword, email);
            sendConfirmationLink(email, id);
            return dao.findUser(login, encryptedPassword);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    private boolean sendConfirmationLink(String email, int id) {
        MailUtility service = new MailUtility();
        try {
            service.sendConfirmMessage(email, id);
            LOGGER.info("Confirmation was sent to '{}'", email);
            return true;
        } catch (PropertyReaderException e) {
            LOGGER.error("Error occurred while sending confirmation link!", e);
            return false;
        }
    }

    @Override
    public boolean confirmAccount(String accountId) throws ServiceException {
        if (!UserValidator.correctId(accountId)) {
            return false;
        }
        UserDao dao = new UserDaoImpl();
        int id = Integer.parseInt(accountId);
        try {
            dao.confirmAccount(id);
            LOGGER.info("Account id={} was confirmed!", id);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateAccountData(int userId, String email, String locale) throws ServiceException {
        if (!UserValidator.correctEmail(email)) {
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
    public List<User> findRecentUsers(String daysNumber) throws ServiceException {
        if (!UserValidator.correctDaysNumber(daysNumber)) {
            ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
            errorSet.add(ValidationError.INVALID_NUMBER_FORMAT);
            return Collections.emptyList();
        }
        int days = daysNumber != null
                ? Integer.parseInt(daysNumber)
                : DEFAULT_USERS_NUMBER;
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
    public boolean buyTrainings(Client client, String trainingsNumber, double trainingCost) throws ServiceException {
        ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
        if (!TrainingValidator.correctTrainingsNumber(trainingsNumber)) {
            errorSet.add(ValidationError.INVALID_NUMBER_FORMAT);
            return false;
        }
        int number = Integer.parseInt(trainingsNumber);
        double discount = client.getPersonalDiscount();
        double balance = client.getMoneyBalance();
        double sum = number * trainingCost;
        double absoluteDiscount = sum * discount / 100;
        sum -= absoluteDiscount;
        if (balance < sum) {
            errorSet.add(ValidationError.LOW_BALANCE);
            return false;
        }
        int id = client.getAccount().getId();
        UserDao dao = new UserDaoImpl();
        try {
            dao.updateBalanceAndBoughtTrainings(id, sum, number);
            client.setBoughtTrainings(client.getBoughtTrainings() + number);
            client.setMoneyBalance(client.getMoneyBalance() - sum);
            return true;
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
    public boolean addToBalance(int clientId, String stringAmount) throws ServiceException {
        if (!UserValidator.correctDepositAmount(stringAmount)) {
            return false;
        }
        int amount = Integer.parseInt(stringAmount);
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
    public boolean blockUser(String userId) throws ServiceException {
        if (!UserValidator.correctId(userId)) {
            return false;
        }
        UserDao dao = new UserDaoImpl();
        int id = Integer.parseInt(userId);
        try {
            dao.blockUser(id);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean unblockUser(String userId) throws ServiceException {
        if (!UserValidator.correctId(userId)) {
            return false;
        }
        int id = Integer.parseInt(userId);
        UserDao dao = new UserDaoImpl();
        try {
            dao.unblockUser(id);
            return true;
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
