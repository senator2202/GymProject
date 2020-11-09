package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Feedback;

import java.util.List;

public interface FeedbackDao {
    boolean add(String name, String email, String subject, String message) throws DaoException;

    List<Feedback> findAll() throws DaoException;

    boolean addReplyMessage(int feedbackId, String message) throws DaoException;
}
