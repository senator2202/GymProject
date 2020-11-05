package com.kharitonov.gym.model.entity;

import java.sql.Date;
import java.sql.Time;

public class Training {
    private int trainingId;
    private int trainerId;
    private String trainerFirstName;
    private String trainerLastName;
    private int clientId;
    private String clientFirstName;
    private String clientLastName;
    private Date date;
    private Time time;
    private boolean isDone;
    private String description;
    private int rating;

    private Training() {
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public String getTrainerLastName() {
        return trainerLastName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static final class TrainingBuilder {
        private int trainingId;
        private int trainerId;
        private String trainerFirstName;
        private String trainerLastName;
        private int clientId;
        private String clientFirstName;
        private String clientLastName;
        private Date date;
        private Time time;
        private boolean isDone;
        private String description;
        private int rating;

        private TrainingBuilder() {
        }

        public static TrainingBuilder aTraining() {
            return new TrainingBuilder();
        }

        public TrainingBuilder withTrainingId(int trainingId) {
            this.trainingId = trainingId;
            return this;
        }

        public TrainingBuilder withTrainerId(int trainerId) {
            this.trainerId = trainerId;
            return this;
        }

        public TrainingBuilder withTrainerFirstName(String trainerFirstName) {
            this.trainerFirstName = trainerFirstName;
            return this;
        }

        public TrainingBuilder withTrainerLastName(String trainerLastName) {
            this.trainerLastName = trainerLastName;
            return this;
        }

        public TrainingBuilder withClientId(int clientId) {
            this.clientId = clientId;
            return this;
        }

        public TrainingBuilder withClientFirstName(String clientFirstName) {
            this.clientFirstName = clientFirstName;
            return this;
        }

        public TrainingBuilder withClientLastName(String clientLastName) {
            this.clientLastName = clientLastName;
            return this;
        }

        public TrainingBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public TrainingBuilder withTime(Time time) {
            this.time = time;
            return this;
        }

        public TrainingBuilder withIsDone(boolean isDone) {
            this.isDone = isDone;
            return this;
        }

        public TrainingBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TrainingBuilder withRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Training build() {
            Training training = new Training();
            training.setTrainingId(trainingId);
            training.setTrainerId(trainerId);
            training.setTrainerFirstName(trainerFirstName);
            training.setTrainerLastName(trainerLastName);
            training.setClientId(clientId);
            training.setClientFirstName(clientFirstName);
            training.setClientLastName(clientLastName);
            training.setDate(date);
            training.setTime(time);
            training.setIsDone(isDone);
            training.setDescription(description);
            training.setRating(rating);
            return training;
        }
    }
}
