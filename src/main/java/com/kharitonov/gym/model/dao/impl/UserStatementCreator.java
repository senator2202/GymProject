package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.model.entity.UserRole;

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
            "SELECT account_id, login, email, role, registration_date, locale, " +
                    "active, first_name, last_name, phone, discount, " +
                    "rating, diet_id, image_name, money_balance, bought_trainings " +
                    "FROM accounts JOIN users ON account_id=user_id " +
                    "WHERE login=? AND password=?";
    private static final String SQL_SELECT_ID =
            "SELECT account_id FROM accounts WHERE login=? AND password=?";
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
    private static final String SQL_UPDATE_ACCOUNT =
            "UPDATE accounts SET email=?, locale=? WHERE account_id=?";
    private static final String SQL_UPDATE_TRAINER_ROLE =
            "UPDATE accounts SET role='TRAINER' WHERE account_id=?;";
    private static final String SQL_UPDATE_TRAINER =
            "UPDATE users SET institution=?, graduation=?, instagram=? WHERE  user_id=?;";
    private static final String SQL_SELECT_RECENT =
            "SELECT users.user_id, first_name, last_name, phone, email, registration_date\n" +
                    "FROM users JOIN accounts ON users.user_id=accounts.account_id\n" +
                    "WHERE date(registration_date) >= CURDATE() - INTERVAL ? DAY ";
    private static final String SQL_UPDATE_IMAGE =
            "UPDATE users SET image_name=? WHERE user_id=?";
    private static final String SQL_DECREASE_BALANCE =
            "UPDATE users SET money_balance=money_balance - ? WHERE user_id=?";
    private static final String SQL_INCREASE_TRAININGS =
            "UPDATE users SET bought_trainings=bought_trainings + ? WHERE user_id=?";

    private UserStatementCreator() {
    }

    static UserStatementCreator getINSTANCE() {
        return INSTANCE;
    }

    PreparedStatement statementInsertAccount(Connection connection,
                                             String login,
                                             String password,
                                             String email)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_ACCOUNT);
        statement.setString(1, login);
        statement.setString(2, password);
        statement.setString(3, email);
        statement.setString(4, UserRole.CLIENT.toString());
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

    PreparedStatement statementSelectId(Connection connection,
                                        String login,
                                        String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ID);
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

    PreparedStatement statementUpdateAccount(Connection connection,
                                             String email,
                                             String locale,
                                             int id)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ACCOUNT);
        statement.setString(1, email);
        statement.setString(2, locale);
        statement.setInt(3, id);
        return statement;
    }

    PreparedStatement statementUpdateTrainerRole(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TRAINER_ROLE);
        statement.setInt(1, id);
        return statement;
    }

    PreparedStatement statementUpdateTrainer(Connection connection,
                                             String institution,
                                             int graduation,
                                             String instagram,
                                             int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TRAINER);
        statement.setString(1, institution);
        statement.setInt(2, graduation);
        statement.setString(3, instagram);
        statement.setInt(4, id);
        return statement;
    }

    PreparedStatement statementSelectRecent(Connection connection, int days) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_RECENT);
        statement.setInt(1, days);
        return statement;
    }

    PreparedStatement statementUpdateImage(Connection connection, int userId, String imageName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_IMAGE);
        statement.setString(1, imageName);
        statement.setInt(2, userId);
        return statement;
    }

    PreparedStatement statementDecreaseBalance(Connection connection, int userId, double decreaseBalance)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DECREASE_BALANCE);
        statement.setDouble(1, decreaseBalance);
        statement.setInt(2, userId);
        return statement;
    }

    PreparedStatement statementIncreaseTrainings(Connection connection, int userId, int boughtTrainings)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INCREASE_TRAININGS);
        statement.setInt(1, boughtTrainings);
        statement.setInt(2, userId);
        return statement;
    }
}
