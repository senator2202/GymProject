package com.kharitonov.gym.validator;

import com.kharitonov.gym.controller.command.RequestParameterName;

import java.util.Map;

public class UserValidator {
    private static final String BLANK = "";
    private static final String LOGIN_REGEX = "[a-zA-Z][a-zA-Z0-9_]{1,19}";
    private static final String PASSWORD_REGEX = "[a-zA-Z0-9_]{5,30}";
    private static final String EMAIL_REGEX =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)" +
                    "*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final int MAX_EMAIL_LENGTH = 50;
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String DEPOSIT_AMOUNT_REGEX = "^[1-9]\\d{0,3}$";
    private static final String DAYS_NUMBER_REGEX = "^[1-9]\\d{0,4}$";
    private static final ValidationErrorSet errorSet = ValidationErrorSet.getInstance();

    private UserValidator() {

    }

    public static boolean correctLoginParameters(Map<String, String> parameters) {
        boolean result = true;
        String login = parameters.get(RequestParameterName.LOGIN);
        if (!correctLogin(login)) {
            parameters.put(RequestParameterName.LOGIN, BLANK);
            errorSet.add(ValidationError.INVALID_LOGIN_FORMAT);
            result = false;
        }
        String password = parameters.get(RequestParameterName.LOGIN_PASSWORD);
        if (!correctPassword(password)) {
            parameters.put(RequestParameterName.LOGIN_PASSWORD, BLANK);
            errorSet.add(ValidationError.INVALID_PASSWORD_FORMAT);
            result = false;
        }
        return result;
    }

    public static boolean correctRegisterParameters(Map<String, String> parameters) {
        boolean result = true;
        String login = parameters.get(RequestParameterName.REGISTRATION_LOGIN);
        if (!correctLogin(login)) {
            parameters.put(RequestParameterName.REGISTRATION_LOGIN, BLANK);
            errorSet.add(ValidationError.INVALID_LOGIN_FORMAT);
            result = false;
        }
        String password = parameters.get(RequestParameterName.REGISTRATION_PASSWORD);
        if (!correctPassword(password)) {
            parameters.put(RequestParameterName.REGISTRATION_PASSWORD, BLANK);
            errorSet.add(ValidationError.INVALID_PASSWORD_FORMAT);
            result = false;
        }
        String email = parameters.get(RequestParameterName.REGISTRATION_EMAIL);
        if (!correctEmail(email)) {
            parameters.put(RequestParameterName.REGISTRATION_EMAIL, BLANK);
            errorSet.add(ValidationError.INVALID_EMAIL_FORMAT);
            result = false;
        }
        String passwordRepeat = parameters.get(RequestParameterName.REPEAT_PASSWORD);
        if (passwordRepeat == null || !passwordRepeat.equals(password)) {
            parameters.put(RequestParameterName.REGISTRATION_PASSWORD, BLANK);
            parameters.put(RequestParameterName.REPEAT_PASSWORD, BLANK);
            errorSet.add(ValidationError.PASSWORDS_ARE_NOT_EQUAL);
            result = false;
        }
        return result;
    }

    private static boolean correctLogin(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    private static boolean correctPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public static boolean correctEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX) && email.length() <= MAX_EMAIL_LENGTH;
    }

    public static boolean correctId(String id) {
        return id != null && id.matches(ID_REGEX);
    }

    public static boolean correctDepositAmount(String amount) {
        return amount != null && amount.matches(DEPOSIT_AMOUNT_REGEX);
    }

    public static boolean correctDaysNumber(String days) {
        return days == null || days.matches(DAYS_NUMBER_REGEX);
    }
}
