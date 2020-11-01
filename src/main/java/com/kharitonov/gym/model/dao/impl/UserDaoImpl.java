package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.entity.*;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kharitonov.gym.model.dao.impl.UserStatementCreator.*;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
    private static final String BLANK = "";
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    static User create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.ACCOUNT_ID);
        String login = resultSet.getString(TableColumnName.ACCOUNT_LOGIN);
        String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
        String role = resultSet.getString(TableColumnName.ACCOUNT_ROLE);
        UserRole userRole = UserRole.valueOf(role);
        Date date = resultSet.getDate(TableColumnName.ACCOUNT_REGISTRATION_DATE);
        String locale = resultSet.getString(TableColumnName.ACCOUNT_LOCALE);
        Account.AccountLocale accountLocale = Account.AccountLocale.valueOf(locale);
        boolean isActive = resultSet.getBoolean(TableColumnName.ACCOUNT_IS_ACTIVE);
        String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
        String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
        String phone = resultSet.getString(TableColumnName.USER_PHONE);
        double discount = resultSet.getDouble(TableColumnName.USER_DISCOUNT);
        int dietId = resultSet.getInt(TableColumnName.USER_DIET_ID);
        String imageName = resultSet.getString(TableColumnName.USER_IMAGE);
        double moneyBalance = resultSet.getDouble(TableColumnName.USER_MONEY_BALANCE);
        int boughtTrainings = resultSet.getInt(TableColumnName.USER_BOUGHT_TRAININGS);
        Account account = Account.AccountBuilder.anAccount()
                .withId(id)
                .withName(login)
                .withEmail(email)
                .withRole(userRole)
                .withRegistrationDate(date)
                .withLocale(accountLocale)
                .withIsActive(isActive)
                .build();
        User user = null;
        if (userRole == UserRole.CLIENT) {
            user = new Client(account);
            ((Client) user).setPersonalDiscount(discount);
            ((Client) user).setDietId(dietId);
            ((Client) user).setMoneyBalance(moneyBalance);
            ((Client) user).setBoughtTrainings(boughtTrainings);
        } else if (userRole == UserRole.TRAINER) {
            double rating = resultSet.getDouble(TableColumnName.USER_RATING);
            String institution = resultSet.getString(TableColumnName.USER_INSTITUTION);
            int graduation = resultSet.getInt(TableColumnName.USER_GRADUATION);
            String instagram = resultSet.getString(TableColumnName.USER_INSTAGRAM);
            user = new Trainer(account);
            ((Trainer) user).setRating(rating);
            ((Trainer) user).setInstitution(institution);
            ((Trainer) user).setInstagramLink(instagram);
            ((Trainer) user).setGraduationYear(graduation);
        } else if (userRole == UserRole.ADMIN) {
            user = new User(account);
        }
        user.setImageName(imageName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phone);
        return user;
    }

    @Override
    public int add(String login, String password, String email) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            int id = addAccount(connection, login, password, email);
            addUser(connection, id);
            connection.commit();
            return id;
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    private int addAccount(Connection connection, String login,
                           String password, String email) throws DaoException {
        ResultSet resultSet = null;
        try (PreparedStatement insertAccount = statementInsertAccount(connection, login, password, email)) {
            insertAccount.executeUpdate();
            resultSet = insertAccount.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            close(resultSet);
        }
    }

    private void addUser(Connection connection, int id) throws DaoException {
        try (PreparedStatement insertUser = statementInsertUser(connection, id)) {
            insertUser.execute();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findUser(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect = statementSelectUser(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(create(resultSet));
            } else {
                LOGGER.warn("There is no user with such name and password!");
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect = statementSelectAll(connection);
             ResultSet resultSet = statementSelect.executeQuery()) {
            while (resultSet.next()) {
                User user = create(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean findByEmail(String email) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect = statementSelectByEmail(connection, email);
             ResultSet resultSet = statementSelect.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean findByLogin(String login) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect = statementSelectByLogin(connection, login);
             ResultSet resultSet = statementSelect.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<UserRole> checkLoginPassword(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect = statementSelectUser(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            Optional<UserRole> optional = Optional.empty();
            if (resultSet.next()) {
                String column = TableColumnName.ACCOUNT_ROLE;
                String stringRole = resultSet.getString(column);
                UserRole role = UserRole.valueOf(stringRole);
                optional = Optional.of(role);
            }
            return optional;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void confirmAccount(int id) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementUpdate = statementUpdateActive(connection, id)) {
            statementUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateAccountData(int userId, String email, String locale) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementUpdate = statementUpdateAccount(connection, email, locale, userId)) {
            statementUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updatePersonalData(int userId, String firstName, String lastName, String phone) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateUser(connection, firstName, lastName, phone, userId)) {
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> findRecentUsers(int days) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectRecent(connection, days);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = create(resultSet);
                /*int id = resultSet.getInt(TableColumnName.USER_ID);
                String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
                String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
                String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
                Date date = resultSet.getDate(TableColumnName.ACCOUNT_REGISTRATION_DATE);
                user.getAccount().setId(id);
                user.getAccount().setEmail(email);
                user.getAccount().setRegistrationDate(date);
                user.setFirstName(firstName);
                user.setLastName(lastName);*/
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateUserImage(int userId, String imageName) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateImage(connection, userId, imageName)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateBalanceAndBoughtTrainings(int userId, double decreaseBalance, int increaseTrainings) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementDecrease = statementDecreaseBalance(connection, userId, decreaseBalance);
             PreparedStatement statementIncrease = statementIncreaseTrainings(connection, userId, increaseTrainings)) {
            connection.setAutoCommit(false);
            statementDecrease.execute();
            statementIncrease.execute();
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<User> findAllTrainers() throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectAllTrainers(connection);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> trainers = new ArrayList<>();
            while (resultSet.next()) {
                Account account = Account.AccountBuilder.anAccount()
                        .withId(resultSet.getInt(TableColumnName.ACCOUNT_ID))
                        .build();
                User user = new Trainer(account);
                user.setFirstName(resultSet.getString(TableColumnName.USER_FIRST_NAME));
                user.setLastName(resultSet.getString(TableColumnName.USER_LAST_NAME));
                trainers.add(user);
            }
            return trainers;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void addToBalance(int userId, int amount) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateBalance(connection, userId, amount)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<String> findEmailById(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectEmailById(connection, userId);
             ResultSet resultSet = statement.executeQuery()) {
            Optional<String> optional;
            if (resultSet.next()) {
                String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
                optional = Optional.of(email);
            } else {
                optional = Optional.empty();
            }
            return optional;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void blockUser(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementBlockUser(connection, userId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void unblockUser(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUnblockUser(connection, userId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateDiscount(int clientId, double discount) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateDiscount(connection, clientId, discount)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
