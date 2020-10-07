package com.kharitonov.gym.model.pool;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();

    boolean releaseConnection(Connection connection);

    void destroyPool();
}
