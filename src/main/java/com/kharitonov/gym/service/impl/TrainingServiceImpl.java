package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.service.TrainingService;

import java.sql.Date;
import java.util.List;

public class TrainingServiceImpl implements TrainingService {
    private static final TrainingServiceImpl INSTANCE = new TrainingServiceImpl();

    private TrainingServiceImpl() {
    }

    public static TrainingServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addTraining(int trainerId, int clientId, Date trainingDate) throws ServiceException {
        TrainingDao dao = new TrainingDaoImpl();
        try {
            dao.addTraining(trainerId, clientId, trainingDate);
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
}
