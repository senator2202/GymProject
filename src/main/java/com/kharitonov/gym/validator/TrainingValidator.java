package com.kharitonov.gym.validator;

public class TrainingValidator {
    private static final String ID_REGEX = "\\d{1,10}";
    private static final String DATE_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    private static final String TIME_REGEX = "\\d{2}:\\d{2}(:\\d{2})?";

    private TrainingValidator() {
    }

    public static boolean correctAddTrainingParameters(String trainerId, String trainingDate, String trainingTime) {
        return correctId(trainerId) && correctDate(trainingDate) && correctTime(trainingTime);
    }

    public static boolean correctId(int id) {
        return id > 0;
    }

    private static boolean correctId(String id) {
        return id != null && id.matches(ID_REGEX);
    }

    private static boolean correctDate(String date) {
        return date != null && date.matches(DATE_REGEX);
    }

    private static boolean correctTime(String time) {
        return time != null && time.matches(TIME_REGEX);
    }
}
