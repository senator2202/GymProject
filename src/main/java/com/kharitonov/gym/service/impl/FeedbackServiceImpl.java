package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.PropertyReaderException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.service.FeedbackService;
import com.kharitonov.gym.util.mail.MailUtility;

import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private static final FeedbackServiceImpl INSTANCE = new FeedbackServiceImpl();
    private static final String BLANK = "";

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

    @Override
    public void sendReplyMessage(String feedbackId, String email, String subject, String replyMessage) throws ServiceException {
        FeedbackDao dao = new FeedbackDaoImpl();
        int id = Integer.parseInt(feedbackId);
        try {
            dao.addReplyMessage(id, replyMessage);
            MailUtility utility = new MailUtility();
            try {
                utility.sendMessage(email, subject, replyMessage);
            } catch (PropertyReaderException e) {
                dao.addReplyMessage(id, BLANK);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
