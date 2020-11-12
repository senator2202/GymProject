package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Feedback;

import java.sql.Date;

/**
 * The type Feedback builder.
 */
public final class FeedbackBuilder {
    private final Feedback feedback;

    private FeedbackBuilder() {
        feedback = new Feedback();
    }

    /**
     * A feedback feedback builder.
     *
     * @return the feedback builder
     */
    public static FeedbackBuilder aFeedback() {
        return new FeedbackBuilder();
    }

    /**
     * With id feedback builder.
     *
     * @param id the id
     * @return the feedback builder
     */
    public FeedbackBuilder withId(int id) {
        feedback.setId(id);
        return this;
    }

    /**
     * With sender name feedback builder.
     *
     * @param senderName the sender name
     * @return the feedback builder
     */
    public FeedbackBuilder withSenderName(String senderName) {
        feedback.setSenderName(senderName);
        return this;
    }

    /**
     * With sender email feedback builder.
     *
     * @param senderEmail the sender email
     * @return the feedback builder
     */
    public FeedbackBuilder withSenderEmail(String senderEmail) {
        feedback.setSenderEmail(senderEmail);
        return this;
    }

    /**
     * With subject feedback builder.
     *
     * @param subject the subject
     * @return the feedback builder
     */
    public FeedbackBuilder withSubject(String subject) {
        feedback.setSubject(subject);
        return this;
    }

    /**
     * With message feedback builder.
     *
     * @param message the message
     * @return the feedback builder
     */
    public FeedbackBuilder withMessage(String message) {
        feedback.setMessage(message);
        return this;
    }

    /**
     * With date feedback builder.
     *
     * @param date the date
     * @return the feedback builder
     */
    public FeedbackBuilder withDate(Date date) {
        feedback.setDate(date);
        return this;
    }

    /**
     * With reply feedback builder.
     *
     * @param reply the reply
     * @return the feedback builder
     */
    public FeedbackBuilder withReply(String reply) {
        feedback.setReply(reply);
        return this;
    }

    /**
     * Build feedback.
     *
     * @return the feedback
     */
    public Feedback build() {
        return feedback;
    }
}
