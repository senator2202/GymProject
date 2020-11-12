package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Feedback;

import java.util.List;

/**
 * The interface Feedback dao.
 */
public interface FeedbackDao {
    /**
     * Add new feedback boolean.
     *
     * @param name    the name
     * @param email   the email
     * @param subject the subject
     * @param message the message
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(String name, String email, String subject, String message) throws DaoException;

    /**
     * Find all feedbacks list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Feedback> findAll() throws DaoException;

    /**
     * Add reply message to existing feedback boolean.
     *
     * @param feedbackId the feedback id
     * @param message    the message
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean addReplyMessage(int feedbackId, String message) throws DaoException;
}
