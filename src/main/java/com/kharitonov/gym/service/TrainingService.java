package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Training;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface TrainingService {
    void addTraining(int trainerId, int clientId, Date trainingDate, Time time) throws ServiceException;

    List<Training> findClientTrainings(int clientId) throws ServiceException;

    List<Training> findTrainerTrainings(int trainerId) throws ServiceException;

    void updateDescription(int trainingId, String description) throws ServiceException;

    void deleteTraining(int trainingId, int userId) throws ServiceException;

    void updateDateTime(String trainingId, String trainingDate, String trainingTime) throws ServiceException;

    void setTrainingDone(String trainingId) throws ServiceException;
}
