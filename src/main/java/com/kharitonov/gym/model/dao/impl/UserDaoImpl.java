package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.dao.creator.TableColumnName;
import com.kharitonov.gym.model.dao.creator.UserCreator;
import com.kharitonov.gym.model.entity.*;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
    private static final UserStatementCreator STATEMENT_CREATOR = UserStatementCreator.getINSTANCE();
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public void addUser(String login, String password, String email) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            int id;
            connection.setAutoCommit(false);
            addAccount(connection, login, password, email);
            id = getAccountId(connection, login, password);
            addUser(connection, id);
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    private void addAccount(Connection connection, String login,
                            String password, String email) throws DaoException {
        try (PreparedStatement insertAccount =
                     STATEMENT_CREATOR.statementInsertAccount(connection, login, password, email)) {
            insertAccount.execute();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private int getAccountId(Connection connection, String login, String password) throws DaoException {
        try (PreparedStatement select =
                     STATEMENT_CREATOR.statementSelectId(connection, login, password);
             ResultSet resultSet = select.executeQuery()) {
            resultSet.next();
            return resultSet.getInt(TableColumnName.ACCOUNT_ID);
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private void addUser(Connection connection, int id) throws DaoException {
        try (PreparedStatement insertUser = STATEMENT_CREATOR.statementInsertUser(connection, id)) {
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
             PreparedStatement statementSelect =
                     STATEMENT_CREATOR.statementSelectUser(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(UserCreator.create(resultSet));
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
             PreparedStatement statementSelect =
                     STATEMENT_CREATOR.statementSelectAll(connection);
             ResultSet resultSet = statementSelect.executeQuery()) {
            while (resultSet.next()) {
                User user = UserCreator.create(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public String findPassword(String login) throws DaoException {
        String password = "";
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect =
                     STATEMENT_CREATOR.statementSelectPassword(connection, login);
             ResultSet resultSet = statementSelect.executeQuery()) {
            if (resultSet.next()) {
                String column = TableColumnName.ACCOUNT_PASSWORD;
                password = resultSet.getString(column);
            }
            return password;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<UserRole> checkLoginPassword(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statementSelect =
                     STATEMENT_CREATOR.statementSelectUser(connection, name, encryptedPassword);
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
             PreparedStatement statementUpdate =
                     STATEMENT_CREATOR.statementUpdateActive(connection, id)) {
            statementUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateUserInfo(String firstName, String lastName, String phone,
                               String email, String locale, int id)
            throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementUpdateUser =
                     STATEMENT_CREATOR.statementUpdateUser(connection,
                             firstName, lastName, phone, id);
             PreparedStatement statementUpdateLocale =
                     STATEMENT_CREATOR.statementUpdateAccount(connection, email, locale, id)) {
            connection.setAutoCommit(false);
            statementUpdateUser.executeUpdate();
            statementUpdateLocale.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public void changeRoleToTrainer(int userId, String institution, int graduationYear, String instagramLink) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementRole =
                     STATEMENT_CREATOR.statementUpdateTrainerRole(connection, userId);
             PreparedStatement statementTrainer =
                     STATEMENT_CREATOR.statementUpdateTrainer(connection, institution, graduationYear, instagramLink, userId)) {
            connection.setAutoCommit(false);
            statementRole.execute();
            statementTrainer.execute();
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
    public List<User> findRecentUsers(int days) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = STATEMENT_CREATOR.statementSelectRecent(connection, days);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new Client();
                int id = resultSet.getInt(TableColumnName.USER_ID);
                String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
                String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
                String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
                Date date = resultSet.getDate(TableColumnName.ACCOUNT_REGISTRATION_DATE);
                user.getAccount().setId(id);
                user.getAccount().setEmail(email);
                user.getAccount().setRegistrationDate(date);
                user.setFirstName(firstName);
                user.setLastName(lastName);
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
             PreparedStatement statement = STATEMENT_CREATOR.statementUpdateImage(connection, userId, imageName)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateBalanceAndBoughtTrainings(int userId, double decreaseBalance, int increaseTrainings) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementDecrease =
                     STATEMENT_CREATOR.statementDecreaseBalance(connection, userId, decreaseBalance);
             PreparedStatement statementIncrease =
                     STATEMENT_CREATOR.statementIncreaseTrainings(connection, userId, increaseTrainings)) {
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
             PreparedStatement statement = STATEMENT_CREATOR.statementSelectAllTrainers(connection);
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
    public int findId(String firstName, String lastName) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement select =
                     STATEMENT_CREATOR.statementSelectUserId(connection, firstName, lastName);
             ResultSet resultSet = select.executeQuery()) {
            resultSet.next();
            return resultSet.getInt(TableColumnName.USER_ID);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
