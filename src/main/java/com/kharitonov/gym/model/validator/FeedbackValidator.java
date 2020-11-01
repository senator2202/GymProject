package com.kharitonov.gym.model.validator;

import java.util.Arrays;
import java.util.Objects;

public class FeedbackValidator {
    private static final String EMAIL_REGEX =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final int MAX_NAME_LENGTH = 30;
    private static final int MAX_SUBJECT_LENGTH = 30;

    private FeedbackValidator() {
    }

    public static boolean correctAddParameters(String name, String email, String subject, String message) {
        return notNull(name, email, subject, message) && correctEmail(email) && !message.isBlank()
                && name.length() <= MAX_NAME_LENGTH && subject.length() <= MAX_SUBJECT_LENGTH;
    }

    public static boolean correctReplyParameters(String feedbackId, String email, String subject, String replyMessage) {
        return notNull(feedbackId, email, subject, replyMessage) && feedbackId.matches(ID_REGEX)
                && correctEmail(email) && !replyMessage.isBlank();
    }

    private static boolean notNull(String... parameters) {
        return Arrays.stream(parameters).noneMatch(Objects::isNull);
    }

    private static boolean correctEmail(String email) {
        return email.length() <= MAX_EMAIL_LENGTH && email.matches(EMAIL_REGEX);
    }
}
