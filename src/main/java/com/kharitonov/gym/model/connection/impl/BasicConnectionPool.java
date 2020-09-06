package com.kharitonov.gym.model.connection.impl;

import com.kharitonov.gym.exception.ConnectionRuntimeException;
import com.kharitonov.gym.model.connection.ConnectionPool;
import com.kharitonov.gym.model.connection.PropertyName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BasicConnectionPool implements ConnectionPool {
    private static final String PROPERTIES_PATH = "db.properties";
    private static final Logger LOGGER =
            LogManager.getLogger(BasicConnectionPool.class);
    private static final BasicConnectionPool INSTANCE =
            new BasicConnectionPool();
    private static final int POOL_SIZE = 10;
    private List<Connection> freeConnections;
    private List<Connection> usedConnections;

    private BasicConnectionPool() {
        try {
            ClassLoader classLoader =
                    Thread.currentThread().getContextClassLoader();
            InputStream inputStream =
                    classLoader.getResourceAsStream(PROPERTIES_PATH);
            Properties properties = new Properties();
            properties.load(inputStream);
            String url = properties.getProperty(PropertyName.DB_URL);
            String driverName = properties.getProperty(PropertyName.DRIVER_NAME);
            Class.forName(driverName);
            freeConnections = new ArrayList<>(POOL_SIZE);
            usedConnections = new ArrayList<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection =
                        DriverManager.getConnection(url, properties);
                freeConnections.add(connection);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ConnectionRuntimeException("Connection pool" +
                    " creating error!", e);
        }
    }

    public static BasicConnectionPool getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        if (!freeConnections.isEmpty()) {
            Connection connection = freeConnections.remove(0);
            usedConnections.add(connection);
            return connection;
        } else {
            throw new ConnectionRuntimeException("All connection are used!");
        }
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        boolean result = usedConnections.remove(connection);
        if (result) {
            freeConnections.add(connection);
        }
        return result;
    }

    @Override
    public void destroyPool() {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : freeConnections) {
            try {
                c.close();
            } catch (SQLException e) {
                LOGGER.warn("Unable to close connection!", e);
            }
        }
        freeConnections.clear();
    }
}
