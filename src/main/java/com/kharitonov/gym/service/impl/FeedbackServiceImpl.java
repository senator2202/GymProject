package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.service.FeedbackService;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static final FeedbackServiceImpl INSTANCE = new FeedbackServiceImpl();

    public static FeedbackServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addFeedback(String name, String email, String subject, String message) throws ServiceException {
        FeedbackDao dao = new FeedbackDaoImpl();
        try {
            dao.addFeedback(name, email, subject, message);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> findAllFeedbacks() throws ServiceException {
        FeedbackDao dao = new FeedbackDaoImpl();
        try {
            return dao.findAllFeedbacks();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
