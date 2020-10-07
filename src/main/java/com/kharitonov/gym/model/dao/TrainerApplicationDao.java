package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.TrainerApplication;

import java.util.List;

public interface TrainerApplicationDao extends BaseDao {
    void addApplication(int userId, String institution,
                        int graduationYear, String instagramLink) throws DaoException;

    boolean applicationExists(int userId) throws DaoException;

    void deleteApplication(int userId) throws DaoException;

    List<TrainerApplication> findAllApplications() throws DaoException;
}
