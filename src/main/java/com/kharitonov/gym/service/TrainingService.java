package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    int addTraining(String trainerId, int clientId, String trainingDate, String trainingTime) throws ServiceException;

    List<Training> findClientTrainings(int clientId) throws ServiceException;

    List<Training> findTrainerTrainings(int trainerId) throws ServiceException;

    void updateDescription(int trainingId, String description) throws ServiceException;

    boolean deleteTraining(String trainingId, int userId) throws ServiceException;

    void updateTraining(String trainingId, String trainingDate, String trainingTime, String description)
            throws ServiceException;

    void setTrainingDone(String trainingId) throws ServiceException;

    boolean rateTraining(String trainingId, String rating, String trainerId) throws ServiceException;

    double averageTrainerRating(String trainerId) throws ServiceException;

    Optional<Training> findTrainingById(int trainingId) throws ServiceException;
}
