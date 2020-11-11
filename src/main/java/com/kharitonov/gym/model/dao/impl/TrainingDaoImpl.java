package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kharitonov.gym.model.dao.impl.TrainingStatementCreator.*;

public class TrainingDaoImpl implements TrainingDao {
    private static final TrainingDaoImpl INSTANCE = new TrainingDaoImpl();
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    private TrainingDaoImpl() {
    }

    public static final TrainingDaoImpl getInstance() {
        return INSTANCE;
    }

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
    public boolean updateDescription(int trainingId, String description) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateDescription(connection, trainingId, description)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteTraining(int trainingId, int userId) throws DaoException {
        Connection connection = pool.getConnection();
        try (PreparedStatement statementAdd = statementDeleteTraining(connection, trainingId);
             PreparedStatement statementDecrement = statementIncrementTrainings(connection, userId)) {
            connection.setAutoCommit(false);
            statementAdd.execute();
            boolean result = statementDecrement.executeUpdate() > 0;
            connection.commit();
            return result;
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        } finally {
            setAutoCommitTrue(connection);
            pool.releaseConnection(connection);
        }
    }

    @Override
    public boolean updateTraining(int trainingId, Date trainingDate, Time trainingTime, String description)
            throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     statementUpdateTraining(connection, trainingDate, trainingTime, description, trainingId)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean setTrainingDone(int trainingId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSetTrainingDone(connection, trainingId)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateTrainingRating(int trainingId, int rating, int trainerId) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            setTrainingRating(connection, trainingId, rating);
            double trainerRating = averageTrainerRating(trainerId);
            boolean result = updateTrainerRating(connection, trainerId, trainerRating);
            connection.commit();
            return result;
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

    private boolean updateTrainerRating(Connection connection, int trainerId, double rating) throws DaoException {
        try (PreparedStatement updTraining = statementUpdateTrainerRating(connection, trainerId, rating)) {
            return updTraining.executeUpdate() > 0;
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

    @Override
    public List<Client> findTrainerClients(int trainerId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectTrainerClients(connection, trainerId);
             ResultSet resultSet = statement.executeQuery()) {
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                Account account = Account.AccountBuilder.anAccount()
                        .withId(resultSet.getInt(TableColumnName.ACCOUNT_ID))
                        .withEmail(resultSet.getString(TableColumnName.ACCOUNT_EMAIL))
                        .build();
                Client client = new Client(account);
                client.setFirstName(resultSet.getString(TableColumnName.USER_FIRST_NAME));
                client.setLastName(resultSet.getString(TableColumnName.USER_LAST_NAME));
                client.setPhoneNumber(resultSet.getString(TableColumnName.USER_PHONE));
                client.setImageName(resultSet.getString(TableColumnName.USER_IMAGE));
                clients.add(client);
            }
            return clients;
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
