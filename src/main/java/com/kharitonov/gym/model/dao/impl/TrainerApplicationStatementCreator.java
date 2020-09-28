package com.kharitonov.gym.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class TrainerApplicationStatementCreator {
    private static final TrainerApplicationStatementCreator INSTANCE =
            new TrainerApplicationStatementCreator();
    private static final String SQL_INSERT_APPLICATION =
            "INSERT INTO trainer_applications (user_id, institution, graduation, instagram) " +
                    "VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_APPLICATION =
            "SELECT user_id FROM trainer_applications WHERE user_id=?";

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
}
