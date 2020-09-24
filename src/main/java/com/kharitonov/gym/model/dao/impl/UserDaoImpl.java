package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.creator.TableColumnName;
import com.kharitonov.gym.model.creator.UserCreator;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER =
            LogManager.getLogger(UserDaoImpl.class);
    private static final ConnectionPool POOL =
            BasicConnectionPool.getInstance();
    private static final UserStatementCreator STATEMENT_CREATOR =
            UserStatementCreator.getINSTANCE();

    @Override
    public void add(User user, String password) throws DaoException {
        Connection connection = POOL.getConnection();
        try {
            connection.setAutoCommit(false);
            addAccount(connection, user, password);
            defineAccountId(connection, user, password);
            addUser(connection, user.getAccount().getId());
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            POOL.releaseConnection(connection);
        }
    }

    private void addAccount(Connection connection, User user,
                            String password) throws SQLException {
        PreparedStatement insertAccount =
                STATEMENT_CREATOR.statementInsertAccount(connection, user, password);
        insertAccount.execute();
    }

    private void defineAccountId(Connection connection, User user, String password)
            throws SQLException {
        String userName = user.getAccount().getName();
        PreparedStatement select =
                STATEMENT_CREATOR.statementSelectUser(connection, userName, password);
        ResultSet resultSet = select.executeQuery();
        int id;
        resultSet.next();
        id = resultSet.getInt(TableColumnName.ACCOUNT_ID);
        user.getAccount().setId(id);
    }

    private void addUser(Connection connection, int id)
            throws SQLException {
        PreparedStatement insertUser =
                STATEMENT_CREATOR.statementInsertUser(connection, id);
        insertUser.execute();
    }

    @Override
    public Optional<User> getUser(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = POOL.getConnection();
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
    public List<User> getAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = POOL.getConnection();
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
    public String getPassword(String login) throws DaoException {
        String password = new String();
        try (Connection connection = POOL.getConnection();
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
        try (Connection connection = POOL.getConnection();
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
        try (Connection connection = POOL.getConnection();
             PreparedStatement statementUpdate =
                     STATEMENT_CREATOR.statementUpdateActive(connection, id)) {
            statementUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateUserInfo(String firstName, String lastName, String phone,
                               String locale, int id)
            throws DaoException {
        Connection connection = POOL.getConnection();
        try (PreparedStatement statementUpdateUser =
                     STATEMENT_CREATOR.statementUpdateUser(connection,
                             firstName, lastName, phone, id);
             PreparedStatement statementUpdateLocale =
                STATEMENT_CREATOR.statementUpdateLocale(connection, locale, id)) {
            connection.setAutoCommit(false);
            statementUpdateUser.executeUpdate();
            statementUpdateLocale.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            POOL.releaseConnection(connection);
        }
    }
}
