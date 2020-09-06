package com.kharitonov.gym.exception;

public class ConnectionRuntimeException extends RuntimeException {
    public ConnectionRuntimeException() {
    }

    public ConnectionRuntimeException(String message) {
        super(message);
    }

    public ConnectionRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionRuntimeException(Throwable cause) {
        super(cause);
    }
}
