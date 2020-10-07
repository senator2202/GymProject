package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.creator.TrainerApplicationCreator;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerApplicationDaoImpl implements TrainerApplicationDao {
    private final ConnectionPool pool = BasicConnectionPool.getInstance();
    private static final TrainerApplicationStatementCreator STATEMENT_CREATOR =
            TrainerApplicationStatementCreator.getInstance();

    @Override
    public void addApplication(int userId, String institution,
                               int graduationYear, String instagramLink) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementInsertApplication(connection, userId,
                             institution, graduationYear, instagramLink)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean applicationExists(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementSelectApplication(connection, userId);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteApplication(int userId) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementDeleteApplication(connection, userId)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<TrainerApplication> getAllApplications() throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementSelectAllApplications(connection);
             ResultSet resultSet = statement.executeQuery()) {
            List<TrainerApplication> applications = new ArrayList<>();
            while (resultSet.next()) {
                TrainerApplication application = TrainerApplicationCreator.create(resultSet);
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
