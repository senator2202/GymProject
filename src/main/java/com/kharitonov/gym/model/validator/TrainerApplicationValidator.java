package com.kharitonov.gym.model.validator;

/**
 * The type Trainer application validator.
 */
public class TrainerApplicationValidator extends CommonValidator {
    private static final String YEAR_REGEX = "^[12][09]\\d{2}$";
    private static final String INSTITUTION_REGEX = "^[\\p{L}\\s]{2,30}$";
    private static final String INSTAGRAM_REGEX = "^(https://www.instagram.com/.{0,70})?$";

    private TrainerApplicationValidator() {
    }

    /**
     * Correct application parameters boolean.
     *
     * @param userId         the user id
     * @param institution    the institution
     * @param graduationYear the graduation year
     * @param instagramLink  the instagram link
     * @return the boolean
     */
    public static boolean correctApplicationParameters(String userId, String institution,
                                                       String graduationYear, String instagramLink) {
        return correctId(userId) && correctInstitution(institution)
                && correctYear(graduationYear) && correctInstagram(instagramLink);
    }

    /**
     * Correct send parameters boolean.
     *
     * @param id          the id
     * @param institution the institution
     * @param year        the year
     * @param instagram   the instagram
     * @return the boolean
     */
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
