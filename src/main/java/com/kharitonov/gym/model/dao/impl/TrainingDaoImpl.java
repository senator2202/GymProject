package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.creator.TrainingCreator;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainingDaoImpl implements TrainingDao {
    private static final TrainingStatementCreator STATEMENT_CREATOR =
            TrainingStatementCreator.getInstance();
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public void addTraining(int trainer_id, int client_id, Date trainingDate) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementInsertTraining(connection, trainer_id, client_id, trainingDate)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Training> findClientTrainings(int clientId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementSelectClientTrainings(connection, clientId);
             ResultSet resultSet = statement.executeQuery()) {
            List<Training> trainings = new ArrayList<>();
            while (resultSet.next()) {
                Training training = TrainingCreator.create(resultSet);
                trainings.add(training);
            }
            return trainings;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
