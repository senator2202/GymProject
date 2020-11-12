package com.kharitonov.gym.model.validator;

/**
 * The type Training validator.
 */
public class TrainingValidator extends CommonValidator {
    private static final String DATE_REGEX = "^202\\d-((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2\\d)|(3[0,1]))$";
    private static final String TIME_REGEX = "^(([0,1]\\d)|2[0-3])(:[0-5]\\d){1,2}$";
    private static final String TRAINING_NUMBER_REGEX = "^(5)$|^(10)$|^(20)$";
    private static final String RATING_REGEX = "^[0-5]$";

    private TrainingValidator() {
    }

    /**
     * Correct update description parameters boolean.
     *
     * @param id          the id
     * @param description the description
     * @return the boolean
     */
    public static boolean correctUpdateDescriptionParameters(String id, String description) {
        return correctId(id) && description != null;
    }

    /**
     * Correct update training parameters boolean.
     *
     * @param trainingId   the training id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @param description  the description
     * @return the boolean
     */
    public static boolean correctUpdateTrainingParameters(String trainingId, String trainingDate,
                                                          String trainingTime, String description) {
        return correctId(trainingId) && correctDate(trainingDate) && correctTime(trainingTime) && description != null;
    }

    /**
     * Correct add training parameters boolean.
     *
     * @param trainerId    the trainer id
     * @param clientId     the client id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @return the boolean
     */
    public static boolean correctAddTrainingParameters(String trainerId, int clientId,
                                                       String trainingDate, String trainingTime) {
        return correctId(trainerId) && correctId(clientId) && correctDate(trainingDate) && correctTime(trainingTime);
    }

    /**
     * Correct rate training parameters boolean.
     *
     * @param trainingId     the training id
     * @param trainingRating the training rating
     * @param trainerId      the trainer id
     * @return the boolean
     */
    public static boolean correctRateTrainingParameters(String trainingId, String trainingRating, String trainerId) {
        return correctId(trainingId) && correctRating(trainingRating) && correctId(trainerId);
    }

    /**
     * Correct trainings number boolean.
     *
     * @param trainingsNumber the trainings number
     * @return the boolean
     */
    public static boolean correctTrainingsNumber(String trainingsNumber) {
        return trainingsNumber != null && trainingsNumber.matches(TRAINING_NUMBER_REGEX);
    }

    private static boolean correctDate(String date) {
        return date != null && date.matches(DATE_REGEX);
    }

    private static boolean correctTime(String time) {
        return time != null && time.matches(TIME_REGEX);
    }

    private static boolean correctRating(String rating) {
        return rating != null && rating.matches(RATING_REGEX);
    }
}
