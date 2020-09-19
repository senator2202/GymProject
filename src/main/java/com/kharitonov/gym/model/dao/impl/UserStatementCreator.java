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
    private static final String SQL_SELECT_ACCOUNT =
            "SELECT account_id, login, password, email, role, " +
                    "registration_date FROM accounts WHERE login=? AND password=?";
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "SELECT account_id, login, password, email, role, registration_date " +
                    "FROM accounts";
    private static final String SQL_UPDATE_ACTIVE =
            "UPDATE accounts SET active=1 WHERE  account_id=?";
    private static final String SQL_SELECT_PASSWORD =
            "SELECT password FROM accounts WHERE login=?";
    private static final String SQL_SELECT_ROLE =
            "SELECT role FROM accounts WHERE login=? AND password=?";

    private UserStatementCreator() {
    }

    public static UserStatementCreator getINSTANCE() {
        return INSTANCE;
    }

    public PreparedStatement statementInsertAccount(Connection connection,
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

    public PreparedStatement statementInsertUser(Connection connection,
                                                 int accountId)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_USER);
        statement.setInt(1, accountId);
        return statement;
    }

    public PreparedStatement statementSelectAccount(Connection connection,
                                                    String login,
                                                    String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ACCOUNT);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    public PreparedStatement statementSelectAll(Connection connection)
            throws SQLException {
        return connection.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
    }

    public PreparedStatement statementUpdateActive(Connection connection,
                                                   int id)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_UPDATE_ACTIVE);
        statement.setInt(1, id);
        return statement;
    }

    public PreparedStatement statementSelectPassword(Connection connection,
                                                     String login)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_PASSWORD);
        statement.setString(1, login);
        return statement;
    }

    public PreparedStatement statementSelectRole(Connection connection,
                                                 String login,
                                                 String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ROLE);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }
}
