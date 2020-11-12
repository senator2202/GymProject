package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.TrainerApplication;

import java.util.List;

/**
 * The interface Trainer application dao.
 */
public interface TrainerApplicationDao extends BaseDao {
    /**
     * Add new trainer application boolean.
     *
     * @param userId         the user id
     * @param institution    the institution
     * @param graduationYear the graduation year
     * @param instagramLink  the instagram link
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(int userId, String institution,
                int graduationYear, String instagramLink) throws DaoException;

    /**
     * Check if the application was already sent by user boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean exists(int userId) throws DaoException;

    /**
     * Delete trainer application boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean delete(int userId) throws DaoException;

    /**
     * Find all trainer applications list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<TrainerApplication> findAll() throws DaoException;

    /**
     * Approve trainer application boolean.
     *
     * @param userId         the user id
     * @param institution    the institution
     * @param graduationYear the graduation year
     * @param instagramLink  the instagram link
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean approve(int userId, String institution, int graduationYear, String instagramLink) throws DaoException;
}
