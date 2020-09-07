package com.kharitonov.gym.model.util;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper {
    private static final DataBaseHelper INSTANCE = new DataBaseHelper();
    private static final String SQL_INSERT_ACCOUNT =
            "INSERT INTO account(name, password, email, role) VALUES(?,?,?,?)";
    private static final String SQL_INSERT_USER =
            "INSERT INTO user(account_id) VALUES(?)";
    private static final String SQL_INSERT_CLIENT =
            "INSERT INTO client(account_id) VALUES(?)";
    private static final String SQL_INSERT_TRAINER =
            "INSERT INTO trainer(account_id) VALUES(?)";
    private static final String SQL_SELECT_ACCOUNT =
            "SELECT id, name, password, email, role, registration_date FROM " +
                    "account WHERE name=? AND password=?";
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "SELECT id, name, password, email, role, registration_date " +
                    "FROM account";

    private DataBaseHelper() {}

    public static DataBaseHelper getINSTANCE() {
        return INSTANCE;
    }

    public PreparedStatement statementInsertAccount(Connection connection,
                                                    User user,
                                                    byte[] password)
            throws DaoException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_INSERT_ACCOUNT);
            statement.setString(1, user.getAccount().getName());
            statement.setBytes(2, password);
            statement.setString(3, user.getAccount().getEmail());
            statement.setString(4, user.getAccount().getRole().toString());
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementInsertUser(Connection connection,
                                                  int accountId)
            throws DaoException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_INSERT_USER);
            statement.setInt(1, accountId);
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementInsertUserInheritor(Connection connection,
                                                          User user)
            throws DaoException {
        String text;
        UserRole role = user.getAccount().getRole();
        switch (role) {
            case TRAINER:
                text = SQL_INSERT_TRAINER;
                break;
            case CLIENT:
                text = SQL_INSERT_CLIENT;
                break;
            default:
                return null;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(text);
            statement.setInt(1, user.getAccount().getId());
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelect(Connection connection,
                                             String name,
                                             byte[] password)
            throws DaoException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_SELECT_ACCOUNT);
            statement.setString(1, name);
            statement.setBytes(2, password);
            return statement;
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelectAll(Connection connection)
            throws DaoException {
        try {
            return connection.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
        } catch (SQLException e) {
            throw new DaoException("Error, while getting statement!", e);
        }
    }
}
