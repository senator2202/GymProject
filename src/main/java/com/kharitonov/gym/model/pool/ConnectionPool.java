package com.kharitonov.gym.model.pool;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();

    void releaseConnection(Connection connection);

    void destroyPool();
}
