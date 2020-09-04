package com.kharitonov.gym.model.util;

import com.kharitonov.gym.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnector {
    private static final String HOST =
            "jdbc:mysql://localhost:3306/web_training";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        PROPERTIES.put("user", "root");
        PROPERTIES.put("password", "admin");
        PROPERTIES.put("autoreconnect", "true");
        PROPERTIES.put("characterEncoding", "UTF-8");
        PROPERTIES.put("useUnicode", "true");
        PROPERTIES.put("serverTimezone", "UTC");
        PROPERTIES.put("verifyServerCertificate", "false");
        PROPERTIES.put("useSSL", "false");
        PROPERTIES.put("requireSSL", "false");
        PROPERTIES.put("allowPublicKeyRetrieval", "true");
    }

    private SqlConnector() {
    }

    public static Connection connect() throws DaoException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(HOST, PROPERTIES);
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Unable to get connection!", e);
        }
    }
}
