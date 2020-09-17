package com.kharitonov.gym.model.creator;

import com.kharitonov.gym.exception.StatementException;
import com.kharitonov.gym.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementCreator {
    private static final StatementCreator INSTANCE = new StatementCreator();
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

    private StatementCreator() {
    }

    public static StatementCreator getINSTANCE() {
        return INSTANCE;
    }

    public PreparedStatement statementInsertAccount(Connection connection,
                                                    User user,
                                                    String password)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_INSERT_ACCOUNT);
            statement.setString(1, user.getAccount().getName());
            statement.setString(2, password);
            statement.setString(3, user.getAccount().getEmail());
            statement.setString(4, user.getAccount().getRole().toString());
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementInsertUser(Connection connection,
                                                 int accountId)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_INSERT_USER);
            statement.setInt(1, accountId);
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelectAccount(Connection connection,
                                                    String login,
                                                    String password)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_SELECT_ACCOUNT);
            statement.setString(1, login);
            statement.setString(2, password);
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelectAll(Connection connection)
            throws StatementException {
        try {
            return connection.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementUpdateActive(Connection connection,
                                                   int id)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_UPDATE_ACTIVE);
            statement.setInt(1, id);
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelectPassword(Connection connection,
                                                     String login)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_SELECT_PASSWORD);
            statement.setString(1, login);
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }

    public PreparedStatement statementSelectRole(Connection connection,
                                                 String login,
                                                 String password)
            throws StatementException {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(SQL_SELECT_ROLE);
            statement.setString(1, login);
            statement.setString(2, password);
            return statement;
        } catch (SQLException e) {
            throw new StatementException("Error, while getting statement!", e);
        }
    }
}
