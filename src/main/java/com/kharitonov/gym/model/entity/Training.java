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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (trainingId != training.trainingId) return false;
        if (trainerId != training.trainerId) return false;
        if (clientId != training.clientId) return false;
        if (isDone != training.isDone) return false;
        if (rating != training.rating) return false;
        if (trainerFirstName != null ? !trainerFirstName.equals(training.trainerFirstName) : training.trainerFirstName != null)
            return false;
        if (trainerLastName != null ? !trainerLastName.equals(training.trainerLastName) : training.trainerLastName != null)
            return false;
        if (clientFirstName != null ? !clientFirstName.equals(training.clientFirstName) : training.clientFirstName != null)
            return false;
        if (clientLastName != null ? !clientLastName.equals(training.clientLastName) : training.clientLastName != null)
            return false;
        if (date != null ? !date.equals(training.date) : training.date != null) return false;
        if (time != null ? !time.equals(training.time) : training.time != null) return false;
        return description != null ? description.equals(training.description) : training.description == null;
    }

    @Override
    public int hashCode() {
        int result = trainingId;
        result = 31 * result + trainerId;
        result = 31 * result + (trainerFirstName != null ? trainerFirstName.hashCode() : 0);
        result = 31 * result + (trainerLastName != null ? trainerLastName.hashCode() : 0);
        result = 31 * result + clientId;
        result = 31 * result + (clientFirstName != null ? clientFirstName.hashCode() : 0);
        result = 31 * result + (clientLastName != null ? clientLastName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isDone ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

}
