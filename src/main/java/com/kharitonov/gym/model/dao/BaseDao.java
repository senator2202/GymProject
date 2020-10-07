package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface BaseDao {
    default void close(ResultSet resultSet) throws DaoException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing result set!", e);
            }
        }
    }

    default void close(Statement statement) throws DaoException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing statement!", e);
            }
        }
    }

    default void rollback(Connection connection) throws DaoException {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new DaoException("Unable to rollback!", e);
            }
        }
    }

    default void setAutoCommitTrue(Connection connection) throws DaoException {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DaoException("Unable to set autoCommit = true", e);
            }
        }
    }
}
