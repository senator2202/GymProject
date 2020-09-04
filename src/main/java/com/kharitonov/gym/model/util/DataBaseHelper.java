package com.kharitonov.gym.model.util;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper {
    private static final String SQL_INSERT =
            "INSERT INTO users(name, password, is_admin) VALUES(?,?,?)";
    private static final String SQL_SELECT =
            "SELECT id, name, password, is_admin FROM users " +
                    "WHERE name=? AND password=?";
    private static final String SQL_SELECT_ALL =
            "SELECT id, name, password, is_admin FROM users";

    public PreparedStatement prepareStatementAdd(Connection connection,
                                                 User user,
                                                 byte[] encryptedPassword)
            throws DaoException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_INSERT);
            statement.setString(1, user.getName());
            statement.setBytes(2, encryptedPassword);
            statement.setBoolean(3, user.isAdmin());
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement prepareStatementSelect(Connection connection,
                                                    String name,
                                                    byte[] password)
            throws DaoException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_SELECT);
            statement.setString(1, name);
            statement.setBytes(2, password);
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement preparedStatementSelectAll(Connection connection)
            throws DaoException {
        try {
            return connection.prepareStatement(SQL_SELECT_ALL);
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }
}
