package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.kharitonov.gym.model.dao.impl.FeedbackStatementCreator.*;

public class FeedbackDaoImpl implements FeedbackDao {
    private final ConnectionPool pool = BasicConnectionPool.getInstance();

    @Override
    public void add(String name, String email, String subject, String message) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementAddFeedback(connection, name, email, subject, message)) {
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Feedback> findAll() throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementSelectAll(connection);
             ResultSet resultSet = statement.executeQuery()) {
            List<Feedback> feedbacks = new ArrayList<>();
            while (resultSet.next()) {
                Feedback feedback = create(resultSet);
                feedbacks.add(feedback);
            }
            return feedbacks;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void addReplyMessage(int feedbackId, String message) throws DaoException {
        try (Connection connection = pool.getConnection();
             PreparedStatement statement = statementUpdateReplyMessage(connection, feedbackId, message)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Feedback create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.FEEDBACK_ID);
        String name = resultSet.getString(TableColumnName.FEEDBACK_SENDER_NAME);
        String email = resultSet.getString(TableColumnName.FEEDBACK_SENDER_EMAIL);
        String subject = resultSet.getString(TableColumnName.FEEDBACK_SUBJECT);
        String message = resultSet.getString(TableColumnName.FEEDBACK_MESSAGE);
        Date date = resultSet.getDate(TableColumnName.FEEDBACK_DATETIME);
        String reply = resultSet.getString(TableColumnName.FEEDBACK_REPLY_MESSAGE);
        return Feedback.FeedbackBuilder.aFeedback()
                .withId(id)
                .withSenderName(name)
                .withSenderEmail(email)
                .withSubject(subject)
                .withMessage(message)
                .withDate(date)
                .withReply(reply)
                .build();
    }
}
