package com.kharitonov.gym.exception;

public class StatementException extends Exception {
    public StatementException() {
    }

    public StatementException(String message) {
        super(message);
    }

    public StatementException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatementException(Throwable cause) {
        super(cause);
    }
}
