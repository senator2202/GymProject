package com.kharitonov.gym.model.pool.impl;

import com.kharitonov.gym.model.pool.ConnectionPool;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class BasicConnectionPoolTest {
    private final ConnectionPool pool =
            BasicConnectionPool.getInstance();

    @Test
    public void testGetInstance() throws IOException, SQLException {
        for (int i = 0; i < 10; i++) {
            pool.getConnection();
        }
    }
}