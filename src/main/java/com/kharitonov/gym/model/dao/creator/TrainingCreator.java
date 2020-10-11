package com.kharitonov.gym.model.dao.creator;

import com.kharitonov.gym.model.entity.Training;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingCreator {
    public static Training create(ResultSet resultSet) throws SQLException {
        Training training = new Training();
        training.setTrainingId(resultSet.getInt(TableColumnName.TRAINING_ID));
        training.setTrainerId(resultSet.getInt(TableColumnName.TRAINER_ID));
        training.setTrainerFirstName(resultSet.getString(TableColumnName.TRAINER_FIRST_NAME));
        training.setTrainerLastName(resultSet.getString(TableColumnName.TRAINER_LAST_NAME));
        training.setDate(resultSet.getDate(TableColumnName.TRAINING_DATE));
        return training;
    }
}
