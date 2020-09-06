package com.kharitonov.gym.model.connection;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
    void destroyPool();
}
