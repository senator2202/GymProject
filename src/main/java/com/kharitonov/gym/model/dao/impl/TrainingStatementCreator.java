package com.kharitonov.gym.model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class TrainingStatementCreator {
    private static final TrainingStatementCreator INSTANCE = new TrainingStatementCreator();
    private static final String SQL_INSERT_TRAINING =
            "INSERT INTO trainings (trainer_id, client_id, training_date) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_CLIENT_TRAININGS =
            "SELECT training_id, trainer_id, " +
                    "(SELECT first_name FROM users WHERE user_id=trainings.trainer_id) AS trainer_first_name, " +
                    "(SELECT last_name FROM users WHERE user_id=trainings.trainer_id) AS trainer_last_name, " +
                    "training_date " +
                    "FROM trainings WHERE client_id=?";
    private static final String SQL_DECREMENT_TRAININGS =
            "UPDATE users SET bought_trainings=bought_trainings-1 WHERE user_id=?";

    private TrainingStatementCreator() {

    }

    static TrainingStatementCreator getInstance() {
        return INSTANCE;
    }

    PreparedStatement statementInsertTraining(Connection connection, int trainerId, int clientId, Date trainingDate) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TRAINING);
        statement.setInt(1, trainerId);
        statement.setInt(2, clientId);
        statement.setDate(3, trainingDate);
        return statement;
    }

    PreparedStatement statementSelectClientTrainings(Connection connection, int clientId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CLIENT_TRAININGS);
        statement.setInt(1, clientId);
        return statement;
    }

    PreparedStatement statementDecrementTrainings(Connection connection, int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SQL_DECREMENT_TRAININGS);
        statement.setInt(1, userId);
        return statement;
    }
}
