package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kharitonov.gym.model.dao.impl.TrainingStatementCreator.*;

public class TrainingDaoImpl implements TrainingDao {
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public int add(int trainerId, int clientId, Date trainingDate, Time trainingTime) throws DaoException {
        Connection connection = pool.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement statementAdd = statementInsertTraining(connection, trainerId, clientId, trainingDate, trainingTime);
             PreparedStatement statementDecrement = statementDecrementTrainings(connection, clientId)) {
            connection.setAutoCommit(false);
            statementAdd.execute();
            statementDecrement.executeUpdate();
            resultSet = statementAdd.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            close(resultSet);
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

    @Override
    public void updateTraining(int trainingId, Date trainingDate, Time trainingTime, String description)
            throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     statementUpdateTraining(connection, trainingDate, trainingTime, description, trainingId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void setTrainingDone(int trainingId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSetTrainingDone(connection, trainingId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void updateTrainingRating(int trainingId, int rating, int trainerId) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            setTrainingRating(connection, trainingId, rating);
            double trainerRating = averageTrainerRating(trainerId);
            updateTrainerRaiting(connection, trainerId, trainerRating);
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    private void setTrainingRating(Connection connection, int trainingId, int rating) throws DaoException {
        try (PreparedStatement updTraining = statementUpdateTrainingRating(connection, trainingId, rating)) {
            updTraining.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private double countAverageRating(Connection connection, int trainerId) throws DaoException {
        try (PreparedStatement countAvgRating = statementAverageRaiting(connection, trainerId);
             ResultSet resultSet = countAvgRating.executeQuery()) {
            resultSet.next();
            return resultSet.getDouble(TableColumnName.AVERAGE_TRAINER_RATING);
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private void updateTrainerRaiting(Connection connection, int trainerId, double rating) throws DaoException {
        try (PreparedStatement updTraining = statementUpdateTrainerRating(connection, trainerId, rating)) {
            updTraining.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    @Override
    public double averageTrainerRating(int trainerId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementAverageRaiting(connection, trainerId);
             ResultSet resultSet = statement.executeQuery()) {
            resultSet.next();
            return resultSet.getDouble(TableColumnName.AVERAGE_TRAINER_RATING);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Training> findTrainingById(int trainingId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectTrainingById(connection, trainingId);
             ResultSet resultSet = statement.executeQuery()) {
            Optional<Training> optional;
            if (resultSet.next()) {
                optional = Optional.of(createTraining(resultSet));
            } else {
                optional = Optional.empty();
            }
            return optional;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    private Training createTraining(ResultSet resultSet) throws DaoException {
        try {
            return Training.TrainingBuilder.aTraining()
                    .withTrainingId(resultSet.getInt(TableColumnName.TRAINING_ID))
                    .withTrainerId(resultSet.getInt(TableColumnName.TRAINER_ID))
                    .withTrainerFirstName(resultSet.getString(TableColumnName.TRAINER_FIRST_NAME))
                    .withTrainerLastName(resultSet.getString(TableColumnName.TRAINER_LAST_NAME))
                    .withClientId(resultSet.getInt(TableColumnName.CLIENT_ID))
                    .withClientFirstName(resultSet.getString(TableColumnName.CLIENT_FIRST_NAME))
                    .withClientLastName(resultSet.getString(TableColumnName.CLIENT_LAST_NAME))
                    .withDate(resultSet.getDate(TableColumnName.TRAINING_DATE))
                    .withTime(resultSet.getTime(TableColumnName.TRAINING_TIME))
                    .withDescription(resultSet.getString(TableColumnName.TRAINING_DESCRIPTION))
                    .withIsDone(resultSet.getBoolean(TableColumnName.TRAINING_IS_DONE))
                    .withRating(resultSet.getInt(TableColumnName.TRAINING_RATING))
                    .build();
        } catch (SQLException e) {
            throw new DaoException("Training creation error!", e);
        }
    }
}
