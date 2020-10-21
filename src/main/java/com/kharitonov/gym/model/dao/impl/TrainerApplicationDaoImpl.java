package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.kharitonov.gym.model.dao.impl.TrainerApplicationStatementCreator.*;

public class TrainerApplicationDaoImpl implements TrainerApplicationDao {
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public void addApplication(int userId, String institution,
                               int graduationYear, String instagramLink) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementInsertApplication(connection, userId,
                     institution, graduationYear, instagramLink)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean applicationExists(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectApplication(connection, userId);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteApplication(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementDeleteApplication(connection, userId)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<TrainerApplication> findAllApplications() throws DaoException {
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

    private TrainerApplication createTrainerApplication(ResultSet resultSet) throws DaoException {
        try {
            int userId = resultSet.getInt(TableColumnName.USER_ID);
            String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
            String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
            String institution = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTITUTION);
            int graduationYear = resultSet.getInt(TableColumnName.TRAINER_APPLICATION_GRADUATION_YEAR);
            String instagramLink = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTAGRAM_LINK);
            Date applicationDate = resultSet.getDate(TableColumnName.TRAINER_APPLICATION_APPLICATION_DATE);
            return TrainerApplication.TrainerApplicationBuilder.aTrainerApplication()
                    .withId(userId)
                    .withFirstName(firstName)
                    .withLastName(lastName)
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
