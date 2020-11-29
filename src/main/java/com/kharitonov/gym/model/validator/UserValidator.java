package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.util.RequestParameterName;

import java.util.Map;

/**
 * The type User validator.
 */
public class UserValidator extends CommonValidator {
    private static final String BLANK = "";
    private static final String LOGIN_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{1,19}$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]{5,30}$";
    private static final String DEPOSIT_AMOUNT_REGEX = "^[1-9]\\d{0,3}$";
    private static final String DAYS_NUMBER_REGEX = "^[1-9]\\d{0,4}$";
    private static final String LOCALE_REGEX = "^((russian)|(english))$";
    private static final String DISCOUNT_REGEX = "^\\d+(\\.\\d{1,2})?$";
    private static final String PHONE_REGEX = "^(((80\\d{2})|(\\+375\\d{2}))[1-9]\\d{6})?$";
    private static final String NAME_REGEX = "^(\\p{L}{0,30})?$";
    private static final int MAX_IMAGE_NAME_LENGTH = 100;
    private static final int MAX_SUMMARY_LENGTH = 250;
    private static final ValidationErrorSet errorSet = ValidationErrorSet.getInstance();

    private UserValidator() {
    }

    /**
     * Correct update summary parameters boolean.
     *
     * @param id      the id
     * @param summary the summary
     * @return the boolean
     */
    public static boolean correctUpdateSummaryParameters(int id, String summary) {
        return correctId(id) && correctSummary(summary);
    }

    /**
     * Correct update image parameters boolean.
     *
     * @param id        the id
     * @param imageName the image name
     * @return the boolean
     */
    public static boolean correctUpdateImageParameters(int id, String imageName) {
        return correctId(id) && correctImageName(imageName);
    }

    /**
     * Correct personal data parameters boolean.
     *
     * @param userId    the user id
     * @param firstName the first name
     * @param lastName  the last name
     * @param phone     the phone
     * @return the boolean
     */
    public static boolean correctPersonalDataParameters(int userId, String firstName, String lastName,
                                                        String phone, String instagram) {
        return correctId(userId) && correctName(firstName) && correctName(lastName) &&
                correctPhone(phone) && correctInstagram(instagram);
    }

    /**
     * Correct account data parameters boolean.
     *
     * @param email          the email
     * @param locale         the locale
     * @param newPassword    the new password
     * @param repeatPassword the repeat password
     * @return the boolean
     */
    public static boolean correctAccountDataParameters(String email, String locale,
                                                       String newPassword, String repeatPassword) {
        return correctEmail(email) && correctLocale(locale) && correctPasswords(newPassword, repeatPassword);
    }

    private static boolean correctPasswords(String password, String repeatPassword) {
        boolean option1 = correctPassword(password) && correctPassword(repeatPassword)
                && password.equals(repeatPassword);
        boolean option2 = notNull(password, repeatPassword) && password.isEmpty() && repeatPassword.isEmpty();
        return option1 || option2;
    }

    /**
     * Correct update discount parameters boolean.
     *
     * @param id       the id
     * @param discount the discount
     * @return the boolean
     */
    public static boolean correctUpdateDiscountParameters(String id, String discount) {
        return correctId(id) && correctDiscount(discount);
    }

    /**
     * Correct login parameters boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     */
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

    /**
     * Correct register parameters boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     */
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
        if (!correctPassword(passwordRepeat) || !passwordRepeat.equals(password)) {
            parameters.put(RequestParameterName.REGISTRATION_PASSWORD, BLANK);
            parameters.put(RequestParameterName.REPEAT_PASSWORD, BLANK);
            errorSet.add(ValidationError.PASSWORDS_ARE_NOT_EQUAL);
            result = false;
        }
        return result;
    }

    /**
     * Correct deposit amount boolean.
     *
     * @param amount the amount
     * @return the boolean
     */
    public static boolean correctDepositAmount(String amount) {
        return amount != null && amount.matches(DEPOSIT_AMOUNT_REGEX);
    }

    /**
     * Correct days number boolean.
     *
     * @param days the days
     * @return the boolean
     */
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
