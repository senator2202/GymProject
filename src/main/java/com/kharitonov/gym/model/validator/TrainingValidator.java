package com.kharitonov.gym.model.validator;

public class TrainingValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String DATE_REGEX = "^202\\d-((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2\\d)|(3[0,1]))$";
    private static final String TIME_REGEX = "^(([0,1]\\d)|2[0-3])(:[0-5]\\d){1,2}$";
    private static final String TRAINING_NUMBER_REGEX = "^(5)|(10)|(20)$";
    private static final String RATING_REGEX = "[1-5]";

    private TrainingValidator() {
    }

    public static boolean correctUpdateDescriptionParameters(String id, String description) {
        return correctId(id) && description != null;
    }

    public static boolean correctUpdateTrainingParameters(String trainingId, String trainingDate,
                                                          String trainingTime, String description) {
        return correctId(trainingId) && correctDate(trainingDate) && correctTime(trainingTime) && description != null;
    }

    public static boolean correctAddTrainingParameters(String trainerId, String trainingDate, String trainingTime) {
        return correctId(trainerId) && correctDate(trainingDate) && correctTime(trainingTime);
    }

    public static boolean correctRateTrainingParameters(String trainingId, String trainingRating, String trainerId) {
        return correctId(trainingId) && correctRating(trainingRating) && correctId(trainerId);
    }

    public static boolean correctTrainingsNumber(String trainingsNumber) {
        return trainingsNumber != null && trainingsNumber.matches(TRAINING_NUMBER_REGEX);
    }

    public static boolean correctId(int id) {
        return id > 0;
    }

    public static boolean correctId(String id) {
        return id != null && id.matches(ID_REGEX);
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
