package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.util.RequestParameterName;

import java.util.Map;

public class UserValidator extends AbstractValidator {
    private static final String BLANK = "";
    private static final String LOGIN_REGEX = "[a-zA-Z][a-zA-Z0-9_]{1,19}";
    private static final String PASSWORD_REGEX = "[a-zA-Z0-9_]{5,30}";
    private static final String DEPOSIT_AMOUNT_REGEX = "^[1-9]\\d{0,3}$";
    private static final String DAYS_NUMBER_REGEX = "^[1-9]\\d{0,4}$";
    private static final String LOCALE_REGEX = "^((russian)|(english))$";
    private static final String DISCOUNT_REGEX = "^\\d+([.,]\\d{1,2})?$";
    private static final String PHONE_REGEX = "^((80\\d{2})|(\\+375\\d{2}))[1-9]\\d{6}$";
    private static final String NAME_REGEX = "\\p{L}{0,30}";
    private static final int MAX_IMAGE_NAME_LENGTH = 100;
    private static final int MAX_SUMMARY_LENGTH = 250;
    private static final ValidationErrorSet errorSet = ValidationErrorSet.getInstance();

    private UserValidator() {
    }

    public static boolean correctUpdateSummaryParameters(int id, String summary) {
        return correctId(id) && correctSummary(summary);
    }

    public static boolean correctUpdateImageParameters(int id, String imageName) {
        return correctId(id) && correctImageName(imageName);
    }

    public static boolean correctPersonalDataParameters(int userId, String firstName, String lastName, String phone) {
        return correctId(userId) && correctName(firstName) && correctName(lastName) && correctPhone(phone);
    }

    public static boolean correctAccountDataParameters(String email, String locale,
                                                       String newPassword, String repeatPassword) {
        return correctEmail(email) && correctLocale(locale);
    }

    public static boolean correctUpdateDiscountParameters(String id, String discount) {
        return correctId(id) && correctDiscount(discount);
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

    public static boolean correctDepositAmount(String amount) {
        return amount != null && amount.matches(DEPOSIT_AMOUNT_REGEX);
    }

    public static boolean correctDaysNumber(String days) {
        return days == null || days.matches(DAYS_NUMBER_REGEX);
    }

    private static boolean correctLogin(String login) {
        return login != null && login.matches(LOGIN_REGEX);
    }

    private static boolean correctPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    private static boolean correctLocale(String locale) {
        return locale == null || locale.matches(LOCALE_REGEX);
    }

    private static boolean correctDiscount(String discount) {
        return discount != null && discount.matches(DISCOUNT_REGEX);
    }

    private static boolean correctName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    private static boolean correctPhone(String phone) {
        return phone != null && phone.matches(PHONE_REGEX);
    }

    private static boolean correctImageName(String imageName) {
        return imageName != null && imageName.length() <= MAX_IMAGE_NAME_LENGTH;
    }

    private static boolean correctSummary(String summary) {
        return summary != null && summary.length() <= MAX_SUMMARY_LENGTH;
    }
}
