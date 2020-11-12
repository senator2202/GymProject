package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.builder.TrainerApplicationBuilder;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.kharitonov.gym.model.dao.impl.TrainerApplicationStatementCreator.*;
import static com.kharitonov.gym.model.dao.impl.UserStatementCreator.statementUpdateTrainer;
import static com.kharitonov.gym.model.dao.impl.UserStatementCreator.statementUpdateTrainerRole;

public class TrainerApplicationDaoImpl implements TrainerApplicationDao {
    private static final TrainerApplicationDaoImpl INSTANCE = new TrainerApplicationDaoImpl();
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    private TrainerApplicationDaoImpl() {
    }

    public static TrainerApplicationDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(int userId, String institution,
                       int graduationYear, String instagramLink) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementInsertApplication(connection, userId,
                     institution, graduationYear, instagramLink)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean exists(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementFindById(connection, userId);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementDeleteApplication(connection, userId)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<TrainerApplication> findAll() throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectAllApplications(connection);
             ResultSet resultSet = statement.executeQuery()) {
            List<TrainerApplication> applications = new ArrayList<>();
            while (resultSet.next()) {
                TrainerApplication application = createTrainerApplication(resultSet);
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean approve(int userId, String institution, int graduationYear, String instagramLink) throws DaoException {
        Connection connection = pool.getConnection();
        try {
            connection.setAutoCommit(false);
            setTrainerRole(connection, userId);
            updateUserData(connection, userId, institution, graduationYear, instagramLink);
            boolean result = deleteApplication(connection, userId);
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

    private void setTrainerRole(Connection connection, int userId) throws DaoException {
        try (PreparedStatement statement = statementUpdateTrainerRole(connection, userId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private void updateUserData(Connection connection, int userId, String institution,
                                int graduationYear, String instagramLink) throws DaoException {
        try (PreparedStatement statement = statementUpdateTrainer(connection, institution,
                graduationYear, instagramLink, userId)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private boolean deleteApplication(Connection connection, int userId) throws DaoException {
        try (PreparedStatement statement = statementDeleteApplication(connection, userId)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            rollback(connection);
            throw new DaoException(e);
        }
    }

    private TrainerApplication createTrainerApplication(ResultSet resultSet) throws DaoException {
        try {
            String institution = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTITUTION);
            int graduationYear = resultSet.getInt(TableColumnName.TRAINER_APPLICATION_GRADUATION_YEAR);
            String instagramLink = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTAGRAM_LINK);
            Date applicationDate = resultSet.getDate(TableColumnName.TRAINER_APPLICATION_APPLICATION_DATE);
            User user = UserDaoImpl.create(resultSet);
            return TrainerApplicationBuilder.aTrainerApplication()
                    .withUser(user)
                    .withInstitution(institution)
                    .withGraduationYear(graduationYear)
                    .withInstagramLink(instagramLink)
                    .withApplicationDate(applicationDate)
                    .build();
        } catch (SQLException e) {
            throw new DaoException("Trainer application creation error!", e);
        }
    }
}
