package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.entity.User;

import java.sql.Date;

/**
 * The type Trainer application builder.
 */
public final class TrainerApplicationBuilder {
    private final TrainerApplication trainerApplication;

    private TrainerApplicationBuilder() {
        trainerApplication = new TrainerApplication();
    }

    /**
     * A trainer application trainer application builder.
     *
     * @return the trainer application builder
     */
    public static TrainerApplicationBuilder aTrainerApplication() {
        return new TrainerApplicationBuilder();
    }

    /**
     * With user trainer application builder.
     *
     * @param user the user
     * @return the trainer application builder
     */
    public TrainerApplicationBuilder withUser(User user) {
        trainerApplication.setUser(user);
        return this;
    }

    /**
     * With institution trainer application builder.
     *
     * @param institution the institution
     * @return the trainer application builder
     */
    public TrainerApplicationBuilder withInstitution(String institution) {
        trainerApplication.setInstitution(institution);
        return this;
    }

    /**
     * With graduation year trainer application builder.
     *
     * @param graduationYear the graduation year
     * @return the trainer application builder
     */
    public TrainerApplicationBuilder withGraduationYear(int graduationYear) {
        trainerApplication.setGraduationYear(graduationYear);
        return this;
    }

    /**
     * With instagram link trainer application builder.
     *
     * @param instagramLink the instagram link
     * @return the trainer application builder
     */
    public TrainerApplicationBuilder withInstagramLink(String instagramLink) {
        trainerApplication.setInstagramLink(instagramLink);
        return this;
    }

    /**
     * With application date trainer application builder.
     *
     * @param applicationDate the application date
     * @return the trainer application builder
     */
    public TrainerApplicationBuilder withApplicationDate(Date applicationDate) {
        trainerApplication.setApplicationDate(applicationDate);
        return this;
    }

    /**
     * Build trainer application.
     *
     * @return the trainer application
     */
    public TrainerApplication build() {
        return trainerApplication;
    }
}
