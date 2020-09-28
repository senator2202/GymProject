package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerApplicationDaoImpl implements TrainerApplicationDao {
    private static final ConnectionPool POOL = BasicConnectionPool.getInstance();
    private static final TrainerApplicationStatementCreator STATEMENT_CREATOR =
            TrainerApplicationStatementCreator.getInstance();

    @Override
    public void addApplication(int userId, String institution,
                               int graduationYear, String instagramLink) throws DaoException {
        try (Connection connection = POOL.getConnection();
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
        try (Connection connection = POOL.getConnection();
             PreparedStatement statement =
                     STATEMENT_CREATOR.statementSelectApplication(connection, userId);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
