package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.kharitonov.gym.model.dao.impl.TrainingStatementCreator.*;

public class TrainingDaoImpl implements TrainingDao {
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public void addTraining(int trainerId, int clientId, Date trainingDate, Time trainingTime) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementAdd = statementInsertTraining(connection, trainerId, clientId, trainingDate, trainingTime);
             PreparedStatement statementDecrement = statementDecrementTrainings(connection, clientId)) {
            connection.setAutoCommit(false);
            statementAdd.execute();
            statementDecrement.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public List<Training> findClientTrainings(int clientId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectClientTrainings(connection, clientId);
             ResultSet resultSet = statement.executeQuery()) {
            List<Training> trainings = new ArrayList<>();
            while (resultSet.next()) {
                Training training = createTraining(resultSet);
                trainings.add(training);
            }
            return trainings;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Training> findTrainerTrainings(int trainerId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectTrainerTrainings(connection, trainerId);
             ResultSet resultSet = statement.executeQuery()) {
            List<Training> trainings = new ArrayList<>();
            while (resultSet.next()) {
                Training training = createTraining(resultSet);
                trainings.add(training);
            }
            return trainings;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateDescription(int trainingId, String description) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateDescription(connection, trainingId, description)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteTraining(int trainingId, int userId) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementAdd = statementDeleteTraining(connection, trainingId);
             PreparedStatement statementDecrement = statementIncrementTrainings(connection, userId)) {
            connection.setAutoCommit(false);
            statementAdd.execute();
            statementDecrement.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    private Training createTraining(ResultSet resultSet) throws DaoException {
        Training training = new Training();
        try {
            training.setTrainingId(resultSet.getInt(TableColumnName.TRAINING_ID));
            training.setTrainerId(resultSet.getInt(TableColumnName.TRAINER_ID));
            training.setTrainerFirstName(resultSet.getString(TableColumnName.TRAINER_FIRST_NAME));
            training.setTrainerLastName(resultSet.getString(TableColumnName.TRAINER_LAST_NAME));
            training.setClientId(resultSet.getInt(TableColumnName.CLIENT_ID));
            training.setClientFirstName(resultSet.getString(TableColumnName.CLIENT_FIRST_NAME));
            training.setClientLastName(resultSet.getString(TableColumnName.CLIENT_LAST_NAME));
            training.setDate(resultSet.getDate(TableColumnName.TRAINING_DATE));
            training.setTime(resultSet.getTime(TableColumnName.TRAINING_TIME));
            training.setDescription(resultSet.getString(TableColumnName.TRAINING_DESCRIPTION));
        } catch (SQLException e) {
            throw new DaoException("Training creation error!", e);
        }
        return training;
    }
}
