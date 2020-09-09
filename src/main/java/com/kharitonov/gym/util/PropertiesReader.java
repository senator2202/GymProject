package com.kharitonov.gym.util;

import com.kharitonov.gym.exception.PropertiesReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOGGER =
            LogManager.getLogger(PropertiesReader.class);

    public Properties readProperties(String path)
            throws PropertiesReaderException {
        ClassLoader classLoader =
                Thread.currentThread().getContextClassLoader();
        InputStream inputStream =
                classLoader.getResourceAsStream(path);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            LOGGER.info("Properties were successfully read form '{}'",
                    path);
        } catch (IOException e) {
            throw new PropertiesReaderException("Impossible to read " +
                    "properties!");
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
