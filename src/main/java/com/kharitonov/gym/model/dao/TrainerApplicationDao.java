package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;

public interface TrainerApplicationDao {
    void addApplication(int userId, String institution,
                        int graduationYear, String instagramLink) throws DaoException;

    boolean applicationExists(int userId) throws DaoException;
}
