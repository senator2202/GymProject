package com.kharitonov.gym.model.pool;

import java.sql.Connection;

/**
 * The interface Connection pool.
 */
public interface ConnectionPool {
    /**
     * Gets connection.
     *
     * @return the connection
     */
    Connection getConnection();

    /**
     * Release connection.
     *
     * @param connection the connection
     */
    void releaseConnection(Connection connection);

    /**
     * Destroy pool.
     */
    void destroyPool();
}
