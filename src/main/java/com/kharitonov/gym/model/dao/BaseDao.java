package com.kharitonov.gym.model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The interface Base dao with couple of deafult utility methods.
 */
public interface BaseDao {
    /**
     * The constant LOGGER.
     */
    Logger LOGGER = LogManager.getLogger(BaseDao.class);

    /**
     * Close.
     *
     * @param resultSet the result set
     */
    default void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error("Error during closing result set!", e);
            }
        }
    }

    /**
     * Close.
     *
     * @param statement the statement
     */
    default void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("Error during closing statement!", e);
            }
        }
    }

    /**
     * Rollback.
     *
     * @param connection the connection
     */
    default void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                LOGGER.error("Unable to rollback!", e);
            }
        }
    }

    /**
     * Sets auto commit true.
     *
     * @param connection the connection
     */
    default void setAutoCommitTrue(Connection connection) {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                LOGGER.error("Unable to set autoCommit = true", e);
            }
        }
    }
}
