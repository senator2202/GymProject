package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.model.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PreparedStatement creator for UserDaoImpl.
 */
class UserStatementCreator {
    private static final String SQL_INSERT_ACCOUNT =
            "INSERT INTO accounts(login, password, email, role) VALUES(?,?,?,?)";
    private static final String SQL_INSERT_USER =
            "INSERT INTO users(user_id) VALUES(?)";
    private static final String SQL_SELECT_USER =
            "SELECT account_id, login, email, role, registration_date, locale, " +
                    "active, first_name, last_name, phone, discount, " +
                    "rating, image_name, money_balance, bought_trainings, " +
                    "institution, graduation, instagram, short_summary " +
                    "FROM accounts JOIN users ON account_id=user_id " +
                    "WHERE login=? AND password=?";
    private static final String SQL_SELECT_USER_BY_ID =
            "SELECT account_id, login, email, role, registration_date, locale, " +
                    "active, first_name, last_name, phone, discount, " +
                    "rating, image_name, money_balance, bought_trainings, " +
                    "institution, graduation, instagram, short_summary " +
                    "FROM accounts JOIN users ON account_id=user_id " +
                    "WHERE account_id=?";
    private static final String SQL_SELECT_ID =
            "SELECT account_id FROM accounts WHERE login=? AND password=?";
    private static final String SQL_SELECT_EMAIL_BY_ID =
            "SELECT email FROM accounts WHERE account_id=?";
    private static final String SQL_SELECT_ALL_ACCOUNTS =
            "SELECT account_id, login, password, email, role, registration_date " +
                    "FROM accounts";
    private static final String SQL_UPDATE_ACTIVE =
            "UPDATE accounts SET active=1 WHERE  account_id=?";
    private static final String SQL_SELECT_PASSWORD =
            "SELECT password FROM accounts WHERE account_id=?";
    private static final String SQL_SELECT_BY_LOGIN =
            "SELECT account_id FROM accounts WHERE login=?";
    private static final String SQL_SELECT_BY_EMAIL =
            "SELECT account_id FROM accounts WHERE email=?";
    private static final String SQL_SELECT_ROLE =
            "SELECT role FROM accounts WHERE login=? AND password=?";
    private static final String SQL_UPDATE_USER =
            "UPDATE users SET first_name=?, last_name=?, phone=?, instagram=? WHERE user_id=?";
    private static final String SQL_UPDATE_ACCOUNT =
            "UPDATE accounts SET email=?, locale=?, password=? WHERE account_id=?";
    private static final String SQL_UPDATE_TRAINER_ROLE =
            "UPDATE accounts SET role='TRAINER' WHERE account_id=?;";
    private static final String SQL_UPDATE_TRAINER =
            "UPDATE users SET institution=?, graduation=?, instagram=? WHERE  user_id=?;";
    private static final String SQL_SELECT_RECENT =
            "SELECT account_id, login, email, role, registration_date, locale, " +
                    "active, first_name, last_name, phone, discount, " +
                    "rating, image_name, money_balance, bought_trainings, " +
                    "institution, graduation, instagram, short_summary " +
                    "FROM accounts JOIN users ON account_id=user_id " +
                    "WHERE date(registration_date) >= CURDATE() - INTERVAL ? DAY ";
    private static final String SQL_UPDATE_IMAGE =
            "UPDATE users SET image_name=? WHERE user_id=?";
    private static final String SQL_DECREASE_BALANCE =
            "UPDATE users SET money_balance=money_balance-? WHERE user_id=?";
    private static final String SQL_INCREASE_TRAININGS =
            "UPDATE users SET bought_trainings=bought_trainings+? WHERE user_id=?";
    private static final String SQL_SELECT_ALL_TRAINERS =
            "SELECT account_id, email, rating, first_name, last_name, phone, rating, institution, " +
                    "graduation, instagram, image_name, short_summary " +
                    "FROM users JOIN accounts ON user_id=account_id " +
                    "WHERE role='TRAINER' " +
                    "ORDER BY rating DESC, short_summary DESC";
    private static final String SQL_SELECT_USER_ID =
            "SELECT user_id FROM users WHERE first_name=? AND last_name=?";
    private static final String SQL_UPDATE_BALANCE =
            "UPDATE users SET money_balance=money_balance+? WHERE user_id=?";
    private static final String SQL_BLOCK_USER =
            "UPDATE accounts SET active=false WHERE account_id=?";
    private static final String SQL_UNBLOCK_USER =
            "UPDATE accounts SET active=true WHERE account_id=?";
    private static final String SQL_UPDATE_TRAINER_RATING =
            "UPDATE users SET rating=? WHERE user_id=?";
    private static final String SQL_UPDATE_DISCOUNT =
            "UPDATE users SET discount=? WHERE user_id=?";
    private static final String SQL_UPDATE_SHORT_SUMMARY =
            "UPDATE users SET short_summary=? WHERE user_id=?";

    private UserStatementCreator() {
    }

    /**
     * Statement insert account prepared statement.
     *
     * @param connection the connection
     * @param login      the login
     * @param password   the password
     * @param email      the email
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementInsertAccount(Connection connection, String login, String password,
                                                    String email) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, login);
        statement.setString(2, password);
        statement.setString(3, email);
        statement.setString(4, UserRole.CLIENT.toString());
        return statement;
    }

    /**
     * Statement insert user prepared statement.
     *
     * @param connection the connection
     * @param accountId  the account id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementInsertUser(Connection connection, int accountId) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_INSERT_USER);
        statement.setInt(1, accountId);
        return statement;
    }

    /**
     * Statement select user prepared statement.
     *
     * @param connection the connection
     * @param login      the login
     * @param password   the password
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectUser(Connection connection, String login, String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_USER);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    /**
     * Statement select user by id prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectUserById(Connection connection, int id) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_USER_BY_ID);
        statement.setInt(1, id);
        return statement;
    }

    /**
     * Statement select id prepared statement.
     *
     * @param connection the connection
     * @param login      the login
     * @param password   the password
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectId(Connection connection,
                                               String login,
                                               String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ID);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    /**
     * Statement select email by id prepared statement.
     *
     * @param connection the connection
     * @param userId     the user id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectEmailById(Connection connection, int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_EMAIL_BY_ID);
        statement.setInt(1, userId);
        return statement;
    }

    /**
     * Statement select all prepared statement.
     *
     * @param connection the connection
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectAll(Connection connection)
            throws SQLException {
        return connection.prepareStatement(SQL_SELECT_ALL_ACCOUNTS);
    }

    /**
     * Statement update active prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateActive(Connection connection,
                                                   int id)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_UPDATE_ACTIVE);
        statement.setInt(1, id);
        return statement;
    }

    /**
     * Statement select password prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectPassword(Connection connection,
                                                     int id)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_PASSWORD);
        statement.setInt(1, id);
        return statement;
    }

    /**
     * Statement select by login prepared statement.
     *
     * @param connection the connection
     * @param login      the login
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectByLogin(Connection connection,
                                                    String login)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_BY_LOGIN);
        statement.setString(1, login);
        return statement;
    }

    /**
     * Statement select by email prepared statement.
     *
     * @param connection the connection
     * @param email      the email
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectByEmail(Connection connection,
                                                    String email)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_BY_EMAIL);
        statement.setString(1, email);
        return statement;
    }

    /**
     * Statement select role prepared statement.
     *
     * @param connection the connection
     * @param login      the login
     * @param password   the password
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectRole(Connection connection,
                                                 String login,
                                                 String password)
            throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement(SQL_SELECT_ROLE);
        statement.setString(1, login);
        statement.setString(2, password);
        return statement;
    }

    /**
     * Statement update user prepared statement.
     *
     * @param connection the connection
     * @param firstName  the first name
     * @param lastName   the last name
     * @param phone      the phone
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateUser(Connection connection,
                                                 String firstName,
                                                 String lastName,
                                                 String phone,
                                                 String instagram,
                                                 int id)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, phone);
        statement.setString(4, instagram);
        statement.setInt(5, id);
        return statement;
    }

    /**
     * Statement update account prepared statement.
     *
     * @param connection the connection
     * @param email      the email
     * @param locale     the locale
     * @param password   the password
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateAccount(Connection connection,
                                                    String email,
                                                    String locale,
                                                    String password,
                                                    int id)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ACCOUNT);
        statement.setString(1, email);
        statement.setString(2, locale);
        statement.setString(3, password);
        statement.setInt(4, id);
        return statement;
    }

    /**
     * Statement update trainer role prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateTrainerRole(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TRAINER_ROLE);
        statement.setInt(1, id);
        return statement;
    }

    /**
     * Statement update trainer prepared statement.
     *
     * @param connection  the connection
     * @param institution the institution
     * @param graduation  the graduation
     * @param instagram   the instagram
     * @param id          the id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateTrainer(Connection connection,
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

    /**
     * Statement select recent prepared statement.
     *
     * @param connection the connection
     * @param days       the days
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectRecent(Connection connection, int days) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_RECENT);
        statement.setInt(1, days);
        return statement;
    }

    /**
     * Statement update image prepared statement.
     *
     * @param connection the connection
     * @param userId     the user id
     * @param imageName  the image name
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateImage(Connection connection, int userId, String imageName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_IMAGE);
        statement.setString(1, imageName);
        statement.setInt(2, userId);
        return statement;
    }

    /**
     * Statement decrease balance prepared statement.
     *
     * @param connection      the connection
     * @param userId          the user id
     * @param decreaseBalance the decrease balance
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementDecreaseBalance(Connection connection, int userId, double decreaseBalance)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DECREASE_BALANCE);
        statement.setDouble(1, decreaseBalance);
        statement.setInt(2, userId);
        return statement;
    }

    /**
     * Statement increase trainings prepared statement.
     *
     * @param connection      the connection
     * @param userId          the user id
     * @param boughtTrainings the bought trainings
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementIncreaseTrainings(Connection connection, int userId, int boughtTrainings)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INCREASE_TRAININGS);
        statement.setInt(1, boughtTrainings);
        statement.setInt(2, userId);
        return statement;
    }

    /**
     * Statement select all trainers prepared statement.
     *
     * @param connection the connection
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectAllTrainers(Connection connection) throws SQLException {
        return connection.prepareStatement(SQL_SELECT_ALL_TRAINERS);
    }

    /**
     * Statement select user id prepared statement.
     *
     * @param connection the connection
     * @param firstName  the first name
     * @param lastName   the last name
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementSelectUserId(Connection connection, String firstName, String lastName)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_ID);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        return statement;
    }

    /**
     * Statement update balance prepared statement.
     *
     * @param connection the connection
     * @param userId     the user id
     * @param amount     the amount
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateBalance(Connection connection, int userId, int amount)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BALANCE);
        statement.setInt(1, amount);
        statement.setInt(2, userId);
        return statement;
    }

    /**
     * Statement block user prepared statement.
     *
     * @param connection the connection
     * @param userId     the user id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementBlockUser(Connection connection, int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_BLOCK_USER);
        statement.setInt(1, userId);
        return statement;
    }

    /**
     * Statement unblock user prepared statement.
     *
     * @param connection the connection
     * @param userId     the user id
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUnblockUser(Connection connection, int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UNBLOCK_USER);
        statement.setInt(1, userId);
        return statement;
    }

    /**
     * Statement update trainer rating prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @param rating     the rating
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateTrainerRating(Connection connection, int id, double rating) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_TRAINER_RATING);
        statement.setDouble(1, rating);
        statement.setInt(2, id);
        return statement;
    }

    /**
     * Statement update discount prepared statement.
     *
     * @param connection the connection
     * @param id         the id
     * @param discount   the discount
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateDiscount(Connection connection, int id, double discount)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_DISCOUNT);
        statement.setDouble(1, discount);
        statement.setInt(2, id);
        return statement;
    }

    /**
     * Statement update short summary prepared statement.
     *
     * @param connection   the connection
     * @param id           the id
     * @param shortSummary the short summary
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    static PreparedStatement statementUpdateShortSummary(Connection connection, int id, String shortSummary)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SHORT_SUMMARY);
        statement.setString(1, shortSummary);
        statement.setInt(2, id);
        return statement;
    }
}
