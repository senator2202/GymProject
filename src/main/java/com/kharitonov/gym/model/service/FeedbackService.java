package com.kharitonov.gym.model.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Feedback;

import java.util.List;

/**
 * The interface Feedback service.
 */
public interface FeedbackService {
    /**
     * Add feedback boolean.
     *
     * @param name    the name
     * @param email   the email
     * @param subject the subject
     * @param message the message
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addFeedback(String name, String email, String subject, String message) throws ServiceException;

    /**
     * Find all feedbacks list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Feedback> findAllFeedbacks() throws ServiceException;

    /**
     * Add reply message boolean.
     *
     * @param feedbackId   the feedback id
     * @param email        the email
     * @param subject      the subject
     * @param replyMessage the reply message
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addReplyMessage(String feedbackId, String email, String subject, String replyMessage) throws ServiceException;
}
