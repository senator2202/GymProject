package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface TrainingDao extends BaseDao {
    int add(int trainerId, int clientId, Date trainingDate, Time trainingTime) throws DaoException;

    List<Training> findClientTrainings(int clientId) throws DaoException;

    List<Training> findTrainerTrainings(int trainerId) throws DaoException;

    void updateDescription(int trainingId, String description) throws DaoException;

    void deleteTraining(int trainingId, int userId) throws DaoException;

    void updateTraining(int trainingId, Date trainingDate, Time trainingTime, String description) throws DaoException;

    void setTrainingDone(int trainingId) throws DaoException;

    void updateTrainingRating(int trainingId, int rating, int trainerId) throws DaoException;

    double averageTrainerRating(int trainerId) throws DaoException;

    Optional<Training> findTrainingById(int trainingId) throws DaoException;

    List<Client> findTrainerClients(int trainerId) throws DaoException;
}
