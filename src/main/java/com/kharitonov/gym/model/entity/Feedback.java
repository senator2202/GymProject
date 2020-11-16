package com.kharitonov.gym.model.entity;

import java.sql.Date;

/**
 * The type Feedback.
 */
public class Feedback {
    private int id;
    private String senderName;
    private String senderEmail;
    private String subject;
    private String message;
    private Date date;
    private String reply;

    /**
     * Instantiates a new Feedback.
     */
    public Feedback() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets sender name.
     *
     * @return the sender name
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets sender name.
     *
     * @param senderName the sender name
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * Gets sender email.
     *
     * @return the sender email
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * Sets sender email.
     *
     * @param senderEmail the sender email
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * Gets reply.
     *
     * @return the reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * Sets reply.
     *
     * @param reply the reply
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Feedback feedback = (Feedback) o;

        if (id != feedback.id) return false;
        if (senderName != null ? !senderName.equals(feedback.senderName) : feedback.senderName != null) {
            return false;
        }
        if (senderEmail != null ? !senderEmail.equals(feedback.senderEmail) : feedback.senderEmail != null) {
            return false;
        }
        if (subject != null ? !subject.equals(feedback.subject) : feedback.subject != null) {
            return false;
        }
        if (message != null ? !message.equals(feedback.message) : feedback.message != null) {
            return false;
        }
        if (date != null ? !date.equals(feedback.date) : feedback.date != null) {
            return false;
        }
        return reply != null ? reply.equals(feedback.reply) : feedback.reply == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (senderName != null ? senderName.hashCode() : 0);
        result = 31 * result + (senderEmail != null ? senderEmail.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("id=").append(id);
        sb.append(", senderName='").append(senderName).append('\'');
        sb.append(", senderEmail='").append(senderEmail).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", date=").append(date);
        sb.append(", reply='").append(reply).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
