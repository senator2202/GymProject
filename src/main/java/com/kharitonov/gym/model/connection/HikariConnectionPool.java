package com.kharitonov.gym.model.connection;

import com.kharitonov.gym.exception.DaoException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariConnectionPool {
    private static final HikariConnectionPool INSTANCE =
            new HikariConnectionPool();
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/gym");
        config.setUsername("root");
        config.setPassword("admin");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMaximumPoolSize(20);
        config.addDataSourceProperty("serverTimezone", "UTC");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private HikariConnectionPool() {
    }

    public static HikariConnectionPool getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection() throws DaoException {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new DaoException("Unable to get connection!", e);
        }
    }
}
