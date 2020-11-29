package com.kharitonov.gym.model.validator;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Common validator.
 */
public abstract class CommonValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
            "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final String INSTAGRAM_REGEX = "^(https://www.instagram.com/.{0,70})?$";

    /**
     * Correct id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean correctId(int id) {
        return id > 0;
    }

    /**
     * Correct id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean correctId(String id) {
        return id != null && id.matches(ID_REGEX);
    }

    /**
     * Correct email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    protected static boolean correctEmail(String email) {
        return email != null && email.length() <= MAX_EMAIL_LENGTH && email.matches(EMAIL_REGEX);
    }

    /**
     * Not null boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     */
    protected static boolean notNull(String... parameters) {
        return Arrays.stream(parameters).noneMatch(Objects::isNull);
    }

    /**
     * Correct email boolean.
     *
     * @param instagram the instagram link
     * @return the boolean
     */
    protected static boolean correctInstagram(String instagram) {
        return instagram != null && instagram.matches(INSTAGRAM_REGEX);
    }
}
