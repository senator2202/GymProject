package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Training;

import java.sql.Date;
import java.util.List;

public interface TrainingDao extends BaseDao {
    void addTraining(int trainer_id, int client_id, Date trainingDate) throws DaoException;

    List<Training> findClientTrainings(int clientId) throws DaoException;
}
