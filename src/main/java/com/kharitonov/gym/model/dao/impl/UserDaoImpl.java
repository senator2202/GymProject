package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.creator.TableColumnName;
import com.kharitonov.gym.model.creator.UserCreator;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import com.kharitonov.gym.model.util.DataBaseHelper;
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
    private static final DataBaseHelper DB_HELPER =
            DataBaseHelper.getINSTANCE();

    @Override
    public void add(User user, String password) throws DaoException {
        Connection connection = POOL.getConnection();
        try {
            connection.setAutoCommit(false);
            addAccount(connection, user, password);
            defineAccountId(connection, user, password);
            addUser(connection, user.getAccount().getId());
            addUserInheritor(connection, user);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                LOGGER.error("Unable to rollback!", e);
            }
            throw new DaoException(e);
        } finally {
            POOL.releaseConnection(connection);
        }
    }

    private void addAccount(Connection connection, User user,
                            String password) throws SQLException, DaoException {
        PreparedStatement insertAccount =
                DB_HELPER.statementInsertAccount(connection, user, password);
        insertAccount.execute();
    }

    private void addUser(Connection connection, int id)
            throws SQLException, DaoException {
        PreparedStatement insertUser =
                DB_HELPER.statementInsertUser(connection, id);
        insertUser.execute();
    }

    private void addUserInheritor(Connection connection, User user)
            throws SQLException, DaoException {
        if (user.getAccount().getRole() != UserRole.ADMIN) {
            PreparedStatement insertInheritor =
                    DB_HELPER.statementInsertUserInheritor(connection, user);
            insertInheritor.execute();
        }
    }

    private void defineAccountId(Connection connection, User user, String password)
            throws SQLException, DaoException {
        String userName = user.getAccount().getName();
        PreparedStatement select =
                DB_HELPER.statementSelect(connection, userName, password);
        ResultSet resultSet = select.executeQuery();
        int id;
        resultSet.next();
        id = resultSet.getInt(TableColumnName.ACCOUNT_ID);
        user.getAccount().setId(id);
    }

    @Override
    public Optional<User> get(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = POOL.getConnection();
             PreparedStatement statementSelect =
                     DB_HELPER.statementSelect(connection, name, encryptedPassword);
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
                     DB_HELPER.statementSelectAll(connection);
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
    public boolean checkLoginPassword(String name, String encryptedPassword)
            throws DaoException {
        try (Connection connection = POOL.getConnection();
             PreparedStatement statementSelect =
                     DB_HELPER.statementSelect(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void confirmAccount(int id) throws DaoException {
        try (Connection connection = POOL.getConnection();
             PreparedStatement statementUpdate =
                     DB_HELPER.statementUpdateActive(connection, id)) {
            statementUpdate.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
