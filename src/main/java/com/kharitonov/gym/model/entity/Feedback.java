package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class Feedback {
    private int id;
    private String senderName;
    private String senderEmail;
    private String subject;
    private String message;
    private Date date;
    private String reply;

    private Feedback() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public static final class FeedbackBuilder {
        private int id;
        private String senderName;
        private String senderEmail;
        private String subject;
        private String message;
        private Date date;
        private String reply;

        private FeedbackBuilder() {
        }

        public static FeedbackBuilder aFeedback() {
            return new FeedbackBuilder();
        }

        public FeedbackBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public FeedbackBuilder withSenderName(String senderName) {
            this.senderName = senderName;
            return this;
        }

        public FeedbackBuilder withSenderEmail(String senderEmail) {
            this.senderEmail = senderEmail;
            return this;
        }

        public FeedbackBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public FeedbackBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public FeedbackBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public FeedbackBuilder withReply(String reply) {
            this.reply = reply;
            return this;
        }

        public Feedback build() {
            Feedback feedback = new Feedback();
            feedback.setId(id);
            feedback.setSenderName(senderName);
            feedback.setSenderEmail(senderEmail);
            feedback.setSubject(subject);
            feedback.setMessage(message);
            feedback.setDate(date);
            feedback.setReply(reply);
            return feedback;
        }
    }
}
