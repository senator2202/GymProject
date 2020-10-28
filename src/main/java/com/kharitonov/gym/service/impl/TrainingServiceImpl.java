package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.service.TrainingService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public class TrainingServiceImpl implements TrainingService {
    private static final String SECONDS_POSTFIX = ":00";
    private static final int TIME_LENGTH = 8;
    private static final String BLANK = "";
    private static final TrainingServiceImpl INSTANCE = new TrainingServiceImpl();

    private TrainingServiceImpl() {
    }

    public static TrainingServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public int addTraining(String sTrainerId, int clientId, String trainingDate, String trainingTime) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int trainerId = Integer.parseInt(sTrainerId);
        Date date = Date.valueOf(trainingDate);
        Time time = Time.valueOf(trainingTime + (trainingTime.length() == TIME_LENGTH ? BLANK : SECONDS_POSTFIX));
        try {
            return dao.addTraining(trainerId, clientId, date, time);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Training> findClientTrainings(int clientId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        try {
            return dao.findClientTrainings(clientId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Training> findTrainerTrainings(int trainerId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        try {
            return dao.findTrainerTrainings(trainerId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateDescription(int trainingId, String description) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        try {
            dao.updateDescription(trainingId, description);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTraining(String trainingId, int userId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int id = Integer.parseInt(trainingId);
        try {
            dao.deleteTraining(id, userId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateTraining(String trainingId, String trainingDate, String trainingTime, String description) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int id = Integer.parseInt(trainingId);
        Date date = Date.valueOf(trainingDate);
        Time time = Time.valueOf(trainingTime + (trainingTime.length() == TIME_LENGTH ? BLANK : SECONDS_POSTFIX));
        try {
            dao.updateTraining(id, date, time, description);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void setTrainingDone(String trainingId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int id = Integer.parseInt(trainingId);
        try {
            dao.setTrainingDone(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void rateTraining(String sTrainingId, String trainingRating) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int trainingId = Integer.parseInt(sTrainingId);
        int rating = Integer.parseInt(trainingRating);
        try {
            dao.updateRating(trainingId, rating);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double averageTrainerRating(String trainerId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        int id = Integer.parseInt(trainerId);
        try {
            return dao.averageTrainerRating(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Training> findTrainingById(int trainingId) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        try {
            return dao.findTrainingById(trainingId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
