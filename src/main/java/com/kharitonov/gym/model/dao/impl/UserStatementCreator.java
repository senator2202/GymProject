package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UserStatementCreator {
    private static final UserStatementCreator INSTANCE = new UserStatementCreator();
    private static final String SQL_INSERT_ACCOUNT =
            "INSERT INTO accounts(login, password, email, role) VALUES(?,?,?,?)";
    private static final String SQL_INSERT_USER =
            "INSERT INTO users(user_id) VALUES(?)";
    private static final String SQL_SELECT_USER =
            "SELECT account_id, login, email, role, registration_date, " +
                    "active, first_name, last_name, phone, discount, " +
                    "rating, diet_id FROM accounts " +
                    "JOIN users ON account_id=user_id " +
                    "WHERE login=? AND password=?";
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "SELECT account_id, login, password, email, role, registration_date " +
                    "FROM accounts";
    private static final String SQL_UPDATE_ACTIVE =
            "UPDATE accounts SET active=1 WHERE  account_id=?";
    private static final String SQL_SELECT_PASSWORD =
            "SELECT password FROM accounts WHERE login=?";
    private static final String SQL_SELECT_ROLE =
            "SELECT role FROM accounts WHERE login=? AND password=?";

    private static final String SQL_UPDATE_USER =
            "UPDATE users SET first_name=?, last_name=?, phone=? WHERE user_id=?";

    private UserStatementCreator() {
    }

    static UserStatementCreator getINSTANCE() {
        return INSTANCE;
    }

    PreparedStatement statementInsertAccount(Connection connection,
                                             User user,
                                             String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_ACCOUNT);
        statement.setString(1, user.getAccount().getName());
        statement.setString(2, password);
        statement.setString(3, user.getAccount().getEmail());
        statement.setString(4, user.getAccount().getRole().toString());
        return statement;
    }

    PreparedStatement statementInsertUser(Connection connection,
                                          int accountId)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_USER);
        statement.setInt(1, accountId);
        return statement;
    }

    PreparedStatement statementSelectUser(Connection connection,
                                          String login,
                                          String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_USER);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    PreparedStatement statementSelectAll(Connection connection)
            throws SQLException {
        return connection.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
    }

    PreparedStatement statementUpdateActive(Connection connection,
                                            int id)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_UPDATE_ACTIVE);
        statement.setInt(1, id);
        return statement;
    }

    PreparedStatement statementSelectPassword(Connection connection,
                                              String login)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_PASSWORD);
        statement.setString(1, login);
        return statement;
    }

    PreparedStatement statementSelectRole(Connection connection,
                                          String login,
                                          String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ROLE);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    PreparedStatement statementUpdateUser(Connection connection,
                                          String firstName,
                                          String lastName,
                                          String phone,
                                          int id)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, phone);
        statement.setInt(4, id);
        return statement;
    }
}
