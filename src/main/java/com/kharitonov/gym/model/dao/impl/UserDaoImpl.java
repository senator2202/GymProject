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
    private static final ConnectionPool connectionPool =
            BasicConnectionPool.getInstance();

    @Override
    public void add(User user, byte[] password) throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        String name = user.getAccount().getName();
        PreparedStatement insertAccount = null;
        try {
            Connection connection = connectionPool.getConnection();
            insertAccount = helper.statementInsertAccount(connection, user, password);
            int id;
            insertAccount.execute();
            id = getAccountId(connection, name, password);
            user.getAccount().setId(id);
            addUser(connection, id);
            if (user.getAccount().getRole() != UserRole.ADMIN) {
                addInheritor(connection, user);
            }
            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(insertAccount);
        }
    }

    private void addInheritor(Connection connection, User user)
            throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        try (PreparedStatement insertInheritor =
                     helper.statementInsertUserInheritor(connection, user)) {
            insertInheritor.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private void addUser(Connection connection, int id) throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        try (PreparedStatement insertUser =
                     helper.statementInsertUser(connection, id)) {
            insertUser.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private int getAccountId(Connection connection, String userName, byte[] password)
            throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        int id;
        try (PreparedStatement select =
                     helper.statementSelect(connection, userName, password);
             ResultSet resultSet = select.executeQuery()) {
            resultSet.next();
            id = resultSet.getInt(TableColumnName.USER_ID);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public Optional<User> get(String name, byte[] encryptedPassword)
            throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        PreparedStatement statementSelect = null;
        ResultSet resultSet;
        try {
            Connection connection = connectionPool.getConnection();
            statementSelect = helper.statementSelect(connection, name,
                    encryptedPassword);
            resultSet = statementSelect.executeQuery();
            if (resultSet.next()) {
                return Optional.of(UserCreator.create(resultSet));
            } else {
                LOGGER.warn("There is no user with such name and password!");
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statementSelect);
        }
    }

    @Override
    public List<User> getAll() throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        PreparedStatement statementSelect = null;
        try {
            Connection connection = connectionPool.getConnection();
            statementSelect = helper.statementSelectAll(connection);
            resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                User user = UserCreator.create(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statementSelect);
        }
    }

    @Override
    public boolean checkLoginPassword(String name, byte[] encryptedPassword)
            throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        PreparedStatement statementSelect = null;
        ResultSet resultSet;
        try {
            Connection connection = connectionPool.getConnection();
            statementSelect = helper.statementSelect(connection, name,
                    encryptedPassword);
            resultSet = statementSelect.executeQuery();
            connectionPool.releaseConnection(connection);
            return resultSet.next();
        } catch (SQLException | DaoException e) {
            throw new DaoException(e);
        } finally {
            close(statementSelect);
        }
    }
}
