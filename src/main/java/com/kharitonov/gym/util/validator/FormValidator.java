package com.kharitonov.gym.util.validator;

import com.kharitonov.gym.controller.command.RequestParameterName;

import java.util.HashMap;
import java.util.Map;

public class FormValidator {
    private static final String LOGIN_REGEX = "[a-zA-Z][a-zA-Z0-9_]{1,19}";
    private static final String PASSWORD_REGEX = "[a-zA-Z0-9_]{5,30}";
    private static final String BLANK = "";

    public static boolean validateLogin(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    public static boolean validatePassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public static boolean validateLoginParameters(Map<String, String> parameters) {
        boolean result = true;
        if (!parameters.get(RequestParameterName.LOGIN).matches(LOGIN_REGEX)) {
            parameters.put(RequestParameterName.LOGIN, BLANK);
            result = false;
        }
        if (!parameters.get(RequestParameterName.PASSWORD).matches(PASSWORD_REGEX)) {
            parameters.put(RequestParameterName.PASSWORD, BLANK);
            result = false;
        }
        return result;
    }
}
