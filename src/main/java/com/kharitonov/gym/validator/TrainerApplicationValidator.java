package com.kharitonov.gym.validator;

public class TrainerApplicationValidator {
    private static final String ID_REGEX = "\\d{1,10}";
    private static final String YEAR_REGEX = "\\d{4}";
    private static final String INSTITUTION_REGEX = "\\p{L}{2,30}";
    private static final int MAX_INSTAGRAM_LENGTH = 30;

    private TrainerApplicationValidator() {
    }

    public static boolean correctAppointTrainerParameters(String userId, String institution,
                                                          String graduationYear, String instagramLink) {
        return correctId(userId) && correctInstitution(institution)
                && correctYeat(graduationYear) && correctInstagram(instagramLink);
    }

    private static boolean correctId(String id) {
        return id != null && id.matches(ID_REGEX);
    }

    private static boolean correctYeat(String year) {
        return year != null && year.matches(YEAR_REGEX);
    }

    private static boolean correctInstagram(String instagram) {
        return instagram != null && instagram.length() <= MAX_INSTAGRAM_LENGTH;
    }

    private static boolean correctInstitution(String institution) {
        return institution != null && institution.matches(INSTITUTION_REGEX);
    }
}
