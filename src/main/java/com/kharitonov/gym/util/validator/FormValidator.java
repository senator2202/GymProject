package com.kharitonov.gym.util.validator;

import com.kharitonov.gym.controller.command.RequestParameterName;

import java.util.Map;

public class FormValidator {
    private static final String LOGIN_REGEX = "[a-zA-Z][a-zA-Z0-9_]{1,19}";
    private static final String PASSWORD_REGEX = "[a-zA-Z0-9_]{5,30}";
    private static final String EMAIL_REGEX =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String BLANK = "";

    private FormValidator() {

    }

    public static boolean validateLogin(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    public static boolean validatePassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public static boolean validateEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public static boolean validateLoginParameters(Map<String, String> parameters) {
        boolean result = true;
        if (!parameters.get(RequestParameterName.LOGIN).matches(LOGIN_REGEX)) {
            parameters.put(RequestParameterName.LOGIN, BLANK);
            result = false;
        }
        if (!parameters.get(RequestParameterName.LOGIN_PASSWORD).matches(PASSWORD_REGEX)) {
            parameters.put(RequestParameterName.LOGIN_PASSWORD, BLANK);
            result = false;
        }
        return result;
    }

    public static boolean validateRegisterParameters(Map<String, String> parameters) {
        boolean result = true;
        if (!parameters.get(RequestParameterName.REGISTRATION_LOGIN).matches(LOGIN_REGEX)) {
            parameters.put(RequestParameterName.REGISTRATION_LOGIN, BLANK);
            result = false;
        }
        if (!parameters.get(RequestParameterName.REGISTRATION_PASSWORD).matches(PASSWORD_REGEX)) {
            parameters.put(RequestParameterName.REGISTRATION_PASSWORD, BLANK);
            result = false;
        }
        if (!parameters.get(RequestParameterName.REGISTRATION_EMAIL).matches(EMAIL_REGEX)) {
            parameters.put(RequestParameterName.REGISTRATION_EMAIL, BLANK);
            result = false;
        }
        if (!parameters.get(RequestParameterName.REGISTRATION_PASSWORD)
                .matches(parameters.get(RequestParameterName.REPEAT_PASSWORD))) {
            parameters.put(RequestParameterName.REGISTRATION_PASSWORD, BLANK);
            parameters.put(RequestParameterName.REPEAT_PASSWORD, BLANK);
            result = false;
        }
        return result;
    }
}
