package com.kharitonov.gym.model.connection.impl;

import com.kharitonov.gym.model.connection.ConnectionPool;
import com.kharitonov.gym.model.connection.PropertyName;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BasicConnectionPoolTest {
    private final ConnectionPool pool =
            BasicConnectionPool.getInstance();

    @Test
    public void testGetInstance() throws IOException, SQLException {
        for (int i = 0; i < 11; i++) {
            pool.getConnection();
        }
    }
}