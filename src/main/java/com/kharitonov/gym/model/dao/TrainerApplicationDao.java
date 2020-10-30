package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.TrainerApplication;

import java.util.List;

public interface TrainerApplicationDao extends BaseDao {
    void add(int userId, String institution,
             int graduationYear, String instagramLink) throws DaoException;

    boolean exists(int userId) throws DaoException;

    void delete(int userId) throws DaoException;

    List<TrainerApplication> findAll() throws DaoException;

    void approve(int userId, String institution, int graduationYear, String instagramLink) throws DaoException;
}
