package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.service.TrainingService;
import com.kharitonov.gym.model.validator.CommonValidator;
import com.kharitonov.gym.model.validator.TrainingValidator;
import com.kharitonov.gym.model.validator.UserValidator;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class TrainingServiceImpl implements TrainingService {
    private static final String SECONDS_POSTFIX = ":00";
    private static final int TIME_LENGTH = 8;
    private static final String BLANK = "";
    private static final int ERROR_VALUE = -1;
    private static final TrainingServiceImpl INSTANCE = new TrainingServiceImpl();
    private final TrainingDao dao = TrainingDaoImpl.getInstance();

    private TrainingServiceImpl() {
    }

    public static TrainingServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public int addTraining(String sTrainerId, int clientId, String trainingDate, String trainingTime)
            throws ServiceException {
        if (!TrainingValidator.correctAddTrainingParameters(sTrainerId, clientId, trainingDate, trainingTime)) {
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
        if (!UserValidator.correctId(clientId)) {
            return new ArrayList<>();
        }
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
            return dao.updateDescription(id, description);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteTraining(String trainingId, int userId) throws ServiceException {
        if (!CommonValidator.correctId(trainingId) || !CommonValidator.correctId(userId)) {
            return false;
        }
        int id = Integer.parseInt(trainingId);
        try {
            return dao.deleteTraining(id, userId);
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
            return dao.updateTraining(id, date, time, description);
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
            return dao.setTrainingDone(id);
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
            return dao.updateTrainingRating(trainingId, trainingRating, trainerId);
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
        if (!CommonValidator.correctId(trainerId)) {
            return new HashMap<>();
        }
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
