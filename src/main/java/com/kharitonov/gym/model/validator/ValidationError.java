package com.kharitonov.gym.model.validator;

/**
 * The enum Validation error.
 */
public enum ValidationError {
    /**
     * Login exists validation error.
     */
    LOGIN_EXISTS,
    /**
     * Email exists validation error.
     */
    EMAIL_EXISTS,
    /**
     * Change email exists validation error.
     */
    CHANGE_EMAIL_EXISTS,
    /**
     * Application exists validation error.
     */
    APPLICATION_EXISTS,
    /**
     * Invalid login format validation error.
     */
    INVALID_LOGIN_FORMAT,
    /**
     * Invalid password format validation error.
     */
    INVALID_PASSWORD_FORMAT,
    /**
     * Invalid number format validation error.
     */
    INVALID_NUMBER_FORMAT,
    /**
     * Invalid email format validation error.
     */
    INVALID_EMAIL_FORMAT,
    /**
     * Invalid locale format validation error.
     */
    INVALID_LOCALE_FORMAT,
    /**
     * Passwords are not equal validation error.
     */
    PASSWORDS_ARE_NOT_EQUAL,
    /**
     * Wrong login password validation error.
     */
    WRONG_LOGIN_PASSWORD,
    /**
     * Low balance validation error.
     */
    LOW_BALANCE
}
