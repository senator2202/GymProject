package com.kharitonov.gym.exception;

public class PropertiesReaderException extends Exception {
    public PropertiesReaderException() {
    }

    public PropertiesReaderException(String message) {
        super(message);
    }

    public PropertiesReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesReaderException(Throwable cause) {
        super(cause);
    }

}
