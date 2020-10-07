package com.kharitonov.gym.model.dao.creator;

import com.kharitonov.gym.model.entity.TrainerApplication;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerApplicationCreator {
    public static TrainerApplication create(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(TableColumnName.USER_ID);
        String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
        String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
        String institution = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTITUTION);
        int graduationYear = resultSet.getInt(TableColumnName.TRAINER_APPLICATION_GRADUATION_YEAR);
        String instagramLink = resultSet.getString(TableColumnName.TRAINER_APPLICATION_INSTAGRAM_LINK);
        Date applicationDate = resultSet.getDate(TableColumnName.TRAINER_APPLICATION_APPLICATION_DATE);
        return TrainerApplication.TrainerApplicationBuilder.aTrainerApplication()
                .withId(userId)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withInstitution(institution)
                .withGraduationYear(graduationYear)
                .withInstagramLink(instagramLink)
                .withApplicationDate(applicationDate)
                .build();
    }
}
