package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.service.TrainingService;
import com.kharitonov.gym.model.validator.TrainingValidator;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TrainingServiceImpl implements TrainingService {
    private final TrainingDao dao = TrainingDaoImpl.getInstance();
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
        try {
            return dao.add(trainerId, clientId, date, time);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Training> findClientTrainings(int clientId) throws ServiceException {
        try {
            return dao.findClientTrainings(clientId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Training> findTrainerTrainings(int trainerId) throws ServiceException {
        try {
            return dao.findTrainerTrainings(trainerId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateDescription(String trainingId, String description) throws ServiceException {
        if (!TrainingValidator.correctUpdateDescriptionParameters(trainingId, description)) {
            return false;
        }
        int id = Integer.parseInt(trainingId);
        try {
            dao.updateDescription(id, description);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteTraining(String trainingId, int userId) throws ServiceException {
        if (!TrainingValidator.correctId(trainingId)) {
            return false;
        }
        int id = Integer.parseInt(trainingId);
        try {
            dao.deleteTraining(id, userId);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateTraining(String trainingId, String trainingDate, String trainingTime, String description)
            throws ServiceException {
        if (!TrainingValidator.correctUpdateTrainingParameters(trainingId, trainingDate, trainingTime, description)) {
            return false;
        }
        int id = Integer.parseInt(trainingId);
        Date date = Date.valueOf(trainingDate);
        Time time = Time.valueOf(trainingTime + (trainingTime.length() == TIME_LENGTH ? BLANK : SECONDS_POSTFIX));
        try {
            dao.updateTraining(id, date, time, description);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean setTrainingDone(String trainingId) throws ServiceException {
        if (!TrainingValidator.correctId(trainingId)) {
            return false;
        }
        int id = Integer.parseInt(trainingId);
        try {
            dao.setTrainingDone(id);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean rateTraining(String sTrainingId, String sTrainingRating, String sTrainerId) throws ServiceException {
        if (!TrainingValidator.correctRateTrainingParameters(sTrainingId, sTrainingRating, sTrainerId)) {
            return false;
        }
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
    public Optional<Training> findTrainingById(int trainingId) throws ServiceException {
        if (!TrainingValidator.correctId(trainingId)) {
            return Optional.empty();
        }
        try {
            return dao.findTrainingById(trainingId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Map<Integer, Client> findTrainerClients(int trainerId) throws ServiceException {
        try {
            List<Client> clients = dao.findTrainerClients(trainerId);
            Map<Integer, Client> clientMap = new HashMap<>();
            clients.forEach(c -> clientMap.put(c.getAccount().getId(), c));
            return clientMap;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
