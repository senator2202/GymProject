package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Training;

import java.sql.Date;
import java.sql.Time;

/**
 * The type Training builder.
 */
public final class TrainingBuilder {
    private final Training training;

    private TrainingBuilder() {
        training = new Training();
    }

    /**
     * A training training builder.
     *
     * @return the training builder
     */
    public static TrainingBuilder aTraining() {
        return new TrainingBuilder();
    }

    /**
     * With training id training builder.
     *
     * @param trainingId the training id
     * @return the training builder
     */
    public TrainingBuilder withTrainingId(int trainingId) {
        training.setTrainingId(trainingId);
        return this;
    }

    /**
     * With trainer id training builder.
     *
     * @param trainerId the trainer id
     * @return the training builder
     */
    public TrainingBuilder withTrainerId(int trainerId) {
        training.setTrainerId(trainerId);
        return this;
    }

    /**
     * With trainer first name training builder.
     *
     * @param trainerFirstName the trainer first name
     * @return the training builder
     */
    public TrainingBuilder withTrainerFirstName(String trainerFirstName) {
        training.setTrainerFirstName(trainerFirstName);
        return this;
    }

    /**
     * With trainer last name training builder.
     *
     * @param trainerLastName the trainer last name
     * @return the training builder
     */
    public TrainingBuilder withTrainerLastName(String trainerLastName) {
        training.setTrainerLastName(trainerLastName);
        return this;
    }

    /**
     * With client id training builder.
     *
     * @param clientId the client id
     * @return the training builder
     */
    public TrainingBuilder withClientId(int clientId) {
        training.setClientId(clientId);
        return this;
    }

    /**
     * With client first name training builder.
     *
     * @param clientFirstName the client first name
     * @return the training builder
     */
    public TrainingBuilder withClientFirstName(String clientFirstName) {
        training.setClientFirstName(clientFirstName);
        return this;
    }

    /**
     * With client last name training builder.
     *
     * @param clientLastName the client last name
     * @return the training builder
     */
    public TrainingBuilder withClientLastName(String clientLastName) {
        training.setClientLastName(clientLastName);
        return this;
    }

    /**
     * With date training builder.
     *
     * @param date the date
     * @return the training builder
     */
    public TrainingBuilder withDate(Date date) {
        training.setDate(date);
        return this;
    }

    /**
     * With time training builder.
     *
     * @param time the time
     * @return the training builder
     */
    public TrainingBuilder withTime(Time time) {
        training.setTime(time);
        return this;
    }

    /**
     * With is done training builder.
     *
     * @param isDone the is done
     * @return the training builder
     */
    public TrainingBuilder withIsDone(boolean isDone) {
        training.setIsDone(isDone);
        return this;
    }

    /**
     * With description training builder.
     *
     * @param description the description
     * @return the training builder
     */
    public TrainingBuilder withDescription(String description) {
        training.setDescription(description);
        return this;
    }

    /**
     * With rating training builder.
     *
     * @param rating the rating
     * @return the training builder
     */
    public TrainingBuilder withRating(int rating) {
        training.setRating(rating);
        return this;
    }

    /**
     * Build training.
     *
     * @return the training
     */
    public Training build() {
        return training;
    }
}
