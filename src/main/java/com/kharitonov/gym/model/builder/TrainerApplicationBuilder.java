package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.entity.User;

import java.sql.Date;

public final class TrainerApplicationBuilder {
    private final TrainerApplication trainerApplication;

    private TrainerApplicationBuilder() {
        trainerApplication = new TrainerApplication();
    }

    public static TrainerApplicationBuilder aTrainerApplication() {
        return new TrainerApplicationBuilder();
    }

    public TrainerApplicationBuilder withUser(User user) {
        trainerApplication.setUser(user);
        return this;
    }

    public TrainerApplicationBuilder withInstitution(String institution) {
        trainerApplication.setInstitution(institution);
        return this;
    }

    public TrainerApplicationBuilder withGraduationYear(int graduationYear) {
        trainerApplication.setGraduationYear(graduationYear);
        return this;
    }

    public TrainerApplicationBuilder withInstagramLink(String instagramLink) {
        trainerApplication.setInstagramLink(instagramLink);
        return this;
    }

    public TrainerApplicationBuilder withApplicationDate(Date applicationDate) {
        trainerApplication.setApplicationDate(applicationDate);
        return this;
    }

    public TrainerApplication build() {
        return trainerApplication;
    }
}
