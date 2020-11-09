package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.PropertyReaderException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.service.FeedbackService;
import com.kharitonov.gym.model.validator.FeedbackValidator;
import com.kharitonov.gym.util.mail.MailUtility;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static final FeedbackServiceImpl INSTANCE = new FeedbackServiceImpl();

    public static FeedbackServiceImpl getInstance() {
        return INSTANCE;
    }

    private FeedbackServiceImpl () {}

    @Override
    public boolean addFeedback(String name, String email, String subject, String message) throws ServiceException {
        if (!FeedbackValidator.correctAddParameters(name, email, subject, message)) {
            return false;
        }
        FeedbackDao dao = new FeedbackDaoImpl();
        try {
            dao.add(name, email, subject, message);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Feedback> findAllFeedbacks() throws ServiceException {
        FeedbackDao dao = new FeedbackDaoImpl();
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean sendReplyMessage(String feedbackId, String email, String subject, String replyMessage) throws ServiceException {
        if (!FeedbackValidator.correctReplyParameters(feedbackId, email, subject, replyMessage)) {
            return false;
        }
        FeedbackDao dao = new FeedbackDaoImpl();
        int id = Integer.parseInt(feedbackId);
        try {
            dao.addReplyMessage(id, replyMessage);
            MailUtility utility = new MailUtility();
            utility.sendMessage(email, subject, replyMessage);
            return true;
        } catch (DaoException | PropertyReaderException e) {
            throw new ServiceException(e);
        }
    }
}
