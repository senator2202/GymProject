package com.kharitonov.gym.model.pool.impl;

import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.PropertyName;
import com.kharitonov.gym.model.reader.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BasicConnectionPool implements ConnectionPool {
    private static final Logger LOGGER =
            LogManager.getLogger(BasicConnectionPool.class);
    private static final BasicConnectionPool INSTANCE =
            new BasicConnectionPool();
    private static final int POOL_SIZE = 10;
    private BlockingQueue<ProxyConnection> freeConnections;
    private List<ProxyConnection> usedConnections;

    private BasicConnectionPool() throws RuntimeException {
        PropertiesReader reader = new PropertiesReader();
        Properties properties = reader.readDBProperties();
        String url = properties.getProperty(PropertyName.DB_URL);
        String driverName = properties.getProperty(PropertyName.DRIVER_NAME);
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to register DB driver!", e);
        }
        freeConnections = new LinkedBlockingDeque<>(POOL_SIZE);
        usedConnections = new ArrayList<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Connection connection =
                        DriverManager.getConnection(url, properties);
                ProxyConnection proxyConnection =
                        new ProxyConnection(connection);
                freeConnections.add(proxyConnection);
            } catch (SQLException e) {
                LOGGER.error("Unable to create connection!", e);
            }
        }
    }

    public static BasicConnectionPool getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = freeConnections.take();
            usedConnections.add(connection);
        } catch (InterruptedException e) {
            LOGGER.error("Unable to provide connection", e);
        }
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        boolean result = false;
        if (connection instanceof ProxyConnection) {
            if (usedConnections.remove(connection)) {
                result = freeConnections.offer((ProxyConnection) connection);
            }
        } else {
            LOGGER.warn("Releasing connection is not proxy!");
        }
        return result;
    }

    @Override
    public void destroyPool() {
        for (int i = 0; i < freeConnections.size(); i++) {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException | InterruptedException e) {
                LOGGER.warn("Unable to close connection!", e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
        Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();
        while (driverEnumeration.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(driverEnumeration.nextElement());
            } catch (SQLException e) {
                LOGGER.warn("Unable to deregister driver!", e);
            }
        }
    }
}
