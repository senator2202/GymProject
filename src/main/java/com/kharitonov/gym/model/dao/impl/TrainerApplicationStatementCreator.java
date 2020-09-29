package com.kharitonov.gym.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class TrainerApplicationStatementCreator {
    private static final TrainerApplicationStatementCreator INSTANCE =
            new TrainerApplicationStatementCreator();
    private static final String SQL_INSERT_APPLICATION =
            "INSERT INTO trainer_applications (user_id, app_institution, app_graduation, app_instagram) " +
                    "VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_APPLICATION =
            "SELECT user_id FROM trainer_applications WHERE user_id=?";
    private static final String SQL_SELECT_ALL_APPLICATIONS =
            "SELECT users.user_id, first_name, last_name, app_institution, app_graduation, app_instagram, application_date\n" +
                    "FROM users JOIN trainer_applications ON users.user_id=trainer_applications.user_id";
    private static final String SQL_DELETE_APPLICATION =
            "DELETE FROM trainer_applications WHERE user_id=?";

    private TrainerApplicationStatementCreator() {
    }

    static TrainerApplicationStatementCreator getInstance() {
        return INSTANCE;
    }

    PreparedStatement statementInsertApplication(Connection connection,
                                                 int userId,
                                                 String institution,
                                                 int graduationYear,
                                                 String instagramLink)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_APPLICATION);
        statement.setInt(1, userId);
        statement.setString(2, institution);
        statement.setInt(3, graduationYear);
        statement.setString(4, instagramLink);
        return statement;
    }

    PreparedStatement statementSelectApplication(Connection connection,
                                                 int userId)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_APPLICATION);
        statement.setInt(1, userId);
        return statement;
    }

    PreparedStatement statementSelectAllApplications(Connection connection)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_APPLICATIONS);
        return statement;
    }

    PreparedStatement statementDeleteApplication(Connection connection, int userId)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DELETE_APPLICATION);
        statement.setInt(1, userId);
        return statement;
    }
}
