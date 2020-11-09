package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.PropertyReaderException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.UserService;
import com.kharitonov.gym.model.validator.*;
import com.kharitonov.gym.util.CryptoUtility;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.mail.MailUtility;
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
    private static final double DEFAULT_TRAINING_COST = 20;
    private final UserDao dao = UserDaoImpl.getInstance();

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
        Optional<User> optional;
        try {
            optional = dao.findUserByLoginPassword(login, encryptedPassword);
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
        try {
            ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
            boolean exists = false;
            if (dao.loginExists(login)) {
                errorSet.add(ValidationError.LOGIN_EXISTS);
                exists = true;
            }
            if (dao.findByEmail(email) != 0) {
                errorSet.add(ValidationError.EMAIL_EXISTS);
                exists = true;
            }
            if (exists) {
                parameters.put(RequestParameterName.REGISTRATION_PASSWORD, "");
                parameters.put(RequestParameterName.REPEAT_PASSWORD, "");
                return Optional.empty();
            }
            int id = dao.add(login, encryptedPassword, email);
            return dao.findUserById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean confirmAccount(String accountId) throws ServiceException {
        if (!CommonValidator.correctId(accountId)) {
            return false;
        }
        int id = Integer.parseInt(accountId);
        try {
            boolean result = dao.confirmAccount(id);
            if (result) {
                LOGGER.info("Account id={} was confirmed!", id);
            } else {
                LOGGER.error("Account id={} confirmation error", id);
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateAccountData(User user, String email, String locale, String newPassword, String repeatPassword)
            throws ServiceException {
        if (!UserValidator.correctAccountDataParameters(email, locale, newPassword, repeatPassword)) {
            return false;
        }
        try {
            int id = dao.findByEmail(email);
            if (id != 0 && id != user.getAccount().getId()) {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                errorSet.add(ValidationError.CHANGE_EMAIL_EXISTS);
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        int userId = user.getAccount().getId();
        locale = locale == null ? user.getAccount().getLocale().name() : locale.toUpperCase();
        try {
            String encrypted = newPassword.isEmpty()
                    ? dao.findPassword(userId)
                    : CryptoUtility.encryptMessage(newPassword);
            boolean result = dao.updateAccountData(userId, email, locale, encrypted);
            if (result) {
                Account.AccountLocale accountLocale = Account.AccountLocale.valueOf(locale);
                user.getAccount().setEmail(email);
                user.getAccount().setLocale(accountLocale);
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updatePersonalData(int userId, String firstName, String lastName, String phone)
            throws ServiceException {
        if (!UserValidator.correctPersonalDataParameters(userId, firstName, lastName, phone)) {
            return false;
        }
        try {
            return dao.updatePersonalData(userId, firstName, lastName, phone);
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
        try {
            return dao.findRecentUsers(days);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateUserImage(int userId, String imageName) throws ServiceException {
        if (!UserValidator.correctUpdateImageParameters(userId, imageName)) {
            return false;
        }
        try {
            return dao.updateUserImage(userId, imageName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean buyTrainings(Client client, String trainingsNumber) throws ServiceException {
        ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
        if (!TrainingValidator.correctTrainingsNumber(trainingsNumber)) {
            errorSet.add(ValidationError.INVALID_NUMBER_FORMAT);
            return false;
        }
        int number = Integer.parseInt(trainingsNumber);
        double discount = client.getPersonalDiscount();
        double balance = client.getMoneyBalance();
        double sum = number * DEFAULT_TRAINING_COST;
        double absoluteDiscount = sum * discount / 100;
        sum -= absoluteDiscount;
        if (balance < sum) {
            errorSet.add(ValidationError.LOW_BALANCE);
            return false;
        }
        int id = client.getAccount().getId();
        try {
            boolean result = dao.updateBalanceAndBoughtTrainings(id, sum, number);
            if (result) {
                client.setBoughtTrainings(client.getBoughtTrainings() + number);
                client.setMoneyBalance(client.getMoneyBalance() - sum);
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Trainer> findAllTrainers() throws ServiceException {
        try {
            return dao.findAllTrainers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addToBalance(Client client, String stringAmount) throws ServiceException {
        if (!UserValidator.correctDepositAmount(stringAmount)) {
            return false;
        }
        int id = client.getAccount().getId();
        int amount = Integer.parseInt(stringAmount);
        try {
            dao.addToBalance(id, amount);
            double balance = client.getMoneyBalance();
            client.setMoneyBalance(balance + amount);
            return true;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    @Override
    public Optional<String> findEmailById(int userId) throws ServiceException {
        try {
            return dao.findEmailById(userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean blockUser(String userId) throws ServiceException {
        if (!CommonValidator.correctId(userId)) {
            return false;
        }
        int id = Integer.parseInt(userId);
        try {
            return dao.blockUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean unblockUser(String userId) throws ServiceException {
        if (!CommonValidator.correctId(userId)) {
            return false;
        }
        int id = Integer.parseInt(userId);
        try {
            return dao.unblockUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateDiscount(String clientId, String personalDiscount) throws ServiceException {
        if (!UserValidator.correctUpdateDiscountParameters(clientId, personalDiscount)) {
            return false;
        }
        int id = Integer.parseInt(clientId);
        double discount = Double.parseDouble(personalDiscount);
        try {
            return dao.updateDiscount(id, discount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateShortSummary(int trainerId, String shortSummary) throws ServiceException {
        if (!UserValidator.correctUpdateSummaryParameters(trainerId, shortSummary)) {
            return false;
        }
        try {
            return dao.updateShortSummary(trainerId, shortSummary);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
