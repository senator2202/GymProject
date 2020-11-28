package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.service.FeedbackService;
import com.kharitonov.gym.model.validator.FeedbackValidator;

import java.util.List;

/**
 * The type Feedback service.
 */
public class FeedbackServiceImpl implements FeedbackService {
    private static final FeedbackServiceImpl INSTANCE = new FeedbackServiceImpl();
    private final FeedbackDao dao = FeedbackDaoImpl.getInstance();

    private FeedbackServiceImpl() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static FeedbackServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean addFeedback(String name, String email, String subject, String message) throws ServiceException {
        if (!FeedbackValidator.correctAddParameters(name, email, subject, message)) {
            return false;
        }
        try {
            return dao.add(name, email, subject, message);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> findAllFeedbacks() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addReplyMessage(String feedbackId, String email, String subject, String replyMessage) throws ServiceException {
        if (!FeedbackValidator.correctReplyParameters(feedbackId, email, subject, replyMessage)) {
            return false;
        }
        int id = Integer.parseInt(feedbackId);
        try {
            return dao.addReplyMessage(id, replyMessage);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
