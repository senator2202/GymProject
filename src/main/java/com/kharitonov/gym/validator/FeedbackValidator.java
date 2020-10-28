package com.kharitonov.gym.validator;

import java.util.Arrays;

public class FeedbackValidator {
    private static final String EMAIL_REGEX =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final int MAX_NAME_LENGTH = 30;
    private static final int MAX_SUBJECT_LENGTH = 30;

    private FeedbackValidator() {
    }

    public static boolean correctAddParameters(String name, String email, String subject, String message) {
        return notNull(name, email, subject, message) && correctEmail(email) && message.length() > 0
                && name.length() <= MAX_NAME_LENGTH && subject.length() <= MAX_SUBJECT_LENGTH;
    }

    private static boolean notNull(String... parameters) {
        return !Arrays.stream(parameters).anyMatch(p -> p == null);
    }

    private static boolean correctEmail(String email) {
        return email.length() <= MAX_EMAIL_LENGTH && email.matches(EMAIL_REGEX);
    }
}
