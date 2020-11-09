package com.kharitonov.gym.model.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    boolean addFeedback(String name, String email, String subject, String message) throws ServiceException;

    List<Feedback> findAllFeedbacks() throws ServiceException;

    boolean addReplyMessage(String feedbackId, String email, String subject, String replyMessage) throws ServiceException;
}
