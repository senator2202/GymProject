package com.kharitonov.gym.model.validator;

public class TrainerApplicationValidator extends CommonValidator {
    private static final String YEAR_REGEX = "^[12][09]\\d{2}$";
    private static final String INSTITUTION_REGEX = "\\p{L}{2,30}";
    private static final String INSTAGRAM_REGEX = "^(https://www.instagram.com/.{0,70})?$";

    private TrainerApplicationValidator() {
    }

    public static boolean correctApplicationParameters(String userId, String institution,
                                                       String graduationYear, String instagramLink) {
        return correctId(userId) && correctInstitution(institution)
                && correctYear(graduationYear) && correctInstagram(instagramLink);
    }

    public static boolean correctSendParameters(int id, String institution, String year, String instagram) {
        return id > 0 && correctInstitution(institution) && correctYear(year) && correctInstagram(instagram);
    }

    private static boolean correctYear(String year) {
        return year != null && year.matches(YEAR_REGEX);
    }

    private static boolean correctInstagram(String instagram) {
        return instagram != null && instagram.matches(INSTAGRAM_REGEX);
    }

    private static boolean correctInstitution(String institution) {
        return institution != null && institution.matches(INSTITUTION_REGEX);
    }
}
