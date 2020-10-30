package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.validator.TrainingValidator;
import com.kharitonov.gym.validator.ValidationError;
import com.kharitonov.gym.validator.ValidationErrorSet;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public class TrainingServiceImpl implements TrainingService {
    private static final String SECONDS_POSTFIX = ":00";
    private static final int TIME_LENGTH = 8;
    private static final String BLANK = "";
    private static final int ERROR_VALUE = -1;
    private static final TrainingServiceImpl INSTANCE = new TrainingServiceImpl();

    private TrainingServiceImpl() {
    }

    public static TrainingServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public int addTraining(String sTrainerId, int clientId, String trainingDate, String trainingTime) throws ServiceException {
        if (!TrainingValidator.correctAddTrainingParameters(sTrainerId, trainingDate, trainingTime)) {
            return ERROR_VALUE;
        }
        int trainerId = Integer.parseInt(sTrainerId);
        Date date = Date.valueOf(trainingDate);
        Time time = Time.valueOf(trainingTime + (trainingTime.length() == TIME_LENGTH ? BLANK : SECONDS_POSTFIX));
        TrainingDao dao = new TrainingDaoImpl();
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
    public boolean deleteTraining(String trainingId, int userId) throws ServiceException {
        if (!TrainingValidator.correctId(trainingId)) {
            return false;
        }
        TrainingDao dao = new TrainingDaoImpl();
        int id = Integer.parseInt(trainingId);
        try {
            dao.deleteTraining(id, userId);
            return true;
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
    public boolean rateTraining(String sTrainingId, String sTrainingRating, String sTrainerId) throws ServiceException {
        if (!TrainingValidator.correctRateTrainingParameters(sTrainingId, sTrainingRating, sTrainerId)) {
            return false;
        }
        TrainingDao dao = new TrainingDaoImpl();
        int trainingId = Integer.parseInt(sTrainingId);
        int trainingRating = Integer.parseInt(sTrainingRating);
        int trainerId = Integer.parseInt(sTrainerId);
        try {
            dao.updateTrainingRating(trainingId, trainingRating, trainerId);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double averageTrainerRating(String trainerId) throws ServiceException {
        if (!TrainingValidator.correctId(trainerId)) {
            ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
            errorSet.add(ValidationError.INVALID_NUMBER_FORMAT);
            return ERROR_VALUE;
        }
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
        if (!TrainingValidator.correctId(trainingId)) {
            return Optional.empty();
        }
        TrainingDao dao = new TrainingDaoImpl();
        try {
            return dao.findTrainingById(trainingId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
