package com.kharitonov.gym.model.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOGGER =
            LogManager.getLogger(PropertiesReader.class);
    private static final String DB_PROPERTIES = "db.properties";

    public Properties readDBProperties() throws RuntimeException {
        ClassLoader classLoader =
                Thread.currentThread().getContextClassLoader();
        InputStream inputStream =
                classLoader.getResourceAsStream(DB_PROPERTIES);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            LOGGER.info("DB properties were successfully read form '{}'",
                    DB_PROPERTIES);
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read DB properties!");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.warn("Unable to close input stream!");
            }
        }
        return properties;
    }
}
