package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.creator.UserCreator;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.util.DataBaseHelper;
import com.kharitonov.gym.model.util.SqlConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER =
            LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void add(User user, byte[] encryptedPassword) throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        try (Connection connection = SqlConnector.connect();
             PreparedStatement statementAdd =
                     helper.prepareStatementAdd(connection, user,
                             encryptedPassword)) {
            statementAdd.execute();
        } catch (SQLException | DaoException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User get(String name, byte[] encryptedPassword) throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet resultSet = null;
        try (Connection connection = SqlConnector.connect();
             PreparedStatement statementSelect = helper
                     .prepareStatementSelect(connection, name,
                             encryptedPassword)) {
            resultSet = statementSelect.executeQuery();
            if (resultSet.next()) {
                return UserCreator.create(resultSet);
            } else {
                LOGGER.warn("There is no user with such name and password!");
                return null;
            }
        } catch (SQLException | DaoException e) {
            close(resultSet);
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getAll() throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try (Connection connection = SqlConnector.connect();
             PreparedStatement statementSelect =
                     helper.preparedStatementSelectAll(connection)) {
            resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                User user = UserCreator.create(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException | DaoException e) {
            close(resultSet);
            throw new DaoException(e);
        }
    }

    @Override
    public boolean checkLoginPassword(String name, byte[] encryptedPassword)
            throws DaoException {
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet resultSet = null;
        try (Connection connection = SqlConnector.connect();
             PreparedStatement statementSelect = helper
                     .prepareStatementSelect(connection, name,
                             encryptedPassword)) {
            resultSet = statementSelect.executeQuery();
            return resultSet.next();
        } catch (SQLException | DaoException e) {
            close(resultSet);
            throw new DaoException(e);
        }
    }
}
