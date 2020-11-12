package com.kharitonov.gym.model.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * The type Training.
 */
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

    /**
     * Gets training id.
     *
     * @return the training id
     */
    public int getTrainingId() {
        return trainingId;
    }

    /**
     * Sets training id.
     *
     * @param trainingId the training id
     */
    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    /**
     * Gets trainer id.
     *
     * @return the trainer id
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * Sets trainer id.
     *
     * @param trainerId the trainer id
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * Gets trainer first name.
     *
     * @return the trainer first name
     */
    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    /**
     * Sets trainer first name.
     *
     * @param trainerFirstName the trainer first name
     */
    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    /**
     * Gets trainer last name.
     *
     * @return the trainer last name
     */
    public String getTrainerLastName() {
        return trainerLastName;
    }

    /**
     * Sets trainer last name.
     *
     * @param trainerLastName the trainer last name
     */
    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets client first name.
     *
     * @return the client first name
     */
    public String getClientFirstName() {
        return clientFirstName;
    }

    /**
     * Sets client first name.
     *
     * @param clientFirstName the client first name
     */
    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    /**
     * Gets client last name.
     *
     * @return the client last name
     */
    public String getClientLastName() {
        return clientLastName;
    }

    /**
     * Sets client last name.
     *
     * @param clientLastName the client last name
     */
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Gets is done.
     *
     * @return the is done
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Sets is done.
     *
     * @param isDone the is done
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Training training = (Training) o;

        if (trainingId != training.trainingId) {
            return false;
        }
        if (trainerId != training.trainerId) {
            return false;
        }
        if (clientId != training.clientId) {
            return false;
        }
        if (isDone != training.isDone) {
            return false;
        }
        if (rating != training.rating) {
            return false;
        }
        if (trainerFirstName != null
                ? !trainerFirstName.equals(training.trainerFirstName)
                : training.trainerFirstName != null) {
            return false;
        }
        if (trainerLastName != null
                ? !trainerLastName.equals(training.trainerLastName)
                : training.trainerLastName != null) {
            return false;
        }
        if (clientFirstName != null
                ? !clientFirstName.equals(training.clientFirstName)
                : training.clientFirstName != null) {
            return false;
        }
        if (clientLastName != null
                ? !clientLastName.equals(training.clientLastName)
                : training.clientLastName != null) {
            return false;
        }
        if (date != null ? !date.equals(training.date) : training.date != null) {
            return false;
        }
        if (time != null ? !time.equals(training.time) : training.time != null) {
            return false;
        }
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Training{");
        sb.append("trainingId=").append(trainingId);
        sb.append(", trainerId=").append(trainerId);
        sb.append(", trainerFirstName='").append(trainerFirstName).append('\'');
        sb.append(", trainerLastName='").append(trainerLastName).append('\'');
        sb.append(", clientId=").append(clientId);
        sb.append(", clientFirstName='").append(clientFirstName).append('\'');
        sb.append(", clientLastName='").append(clientLastName).append('\'');
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", isDone=").append(isDone);
        sb.append(", description='").append(description).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
