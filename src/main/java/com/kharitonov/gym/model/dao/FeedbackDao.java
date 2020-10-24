package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Feedback;

import java.util.List;

public interface FeedbackDao {
    void addFeedback(String name, String email, String subject, String message) throws DaoException;

    List<Feedback> findAllFeedbacks() throws DaoException;

    void addReplyMessage(int feedbackId, String message) throws DaoException;
}
