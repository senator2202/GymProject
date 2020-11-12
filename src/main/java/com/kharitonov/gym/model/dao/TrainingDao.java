package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

/**
 * The interface Training dao.
 */
public interface TrainingDao extends BaseDao {
    /**
     * Add new training int.
     *
     * @param trainerId    the trainer id
     * @param clientId     the client id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @return the int
     * @throws DaoException the dao exception
     */
    int add(int trainerId, int clientId, Date trainingDate, Time trainingTime) throws DaoException;

    /**
     * Find all client trainings list.
     *
     * @param clientId the client id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Training> findClientTrainings(int clientId) throws DaoException;

    /**
     * Find all trainer trainings list.
     *
     * @param trainerId the trainer id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Training> findTrainerTrainings(int trainerId) throws DaoException;

    /**
     * Update trainer description boolean.
     *
     * @param trainingId  the training id
     * @param description the description
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateDescription(int trainingId, String description) throws DaoException;

    /**
     * Delete training boolean.
     *
     * @param trainingId the training id
     * @param userId     the user id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean deleteTraining(int trainingId, int userId) throws DaoException;

    /**
     * Update training boolean.
     *
     * @param trainingId   the training id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @param description  the description
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateTraining(int trainingId, Date trainingDate, Time trainingTime, String description) throws DaoException;

    /**
     * Sets training done boolean.
     *
     * @param trainingId the training id
     * @return the training done
     * @throws DaoException the dao exception
     */
    boolean setTrainingDone(int trainingId) throws DaoException;

    /**
     * Update training rating boolean.
     *
     * @param trainingId the training id
     * @param rating     the rating
     * @param trainerId  the trainer id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateTrainingRating(int trainingId, int rating, int trainerId) throws DaoException;

    /**
     * Count average trainer rating double.
     *
     * @param trainerId the trainer id
     * @return the double
     * @throws DaoException the dao exception
     */
    double countAverageTrainerRating(int trainerId) throws DaoException;

    /**
     * Find training by id optional.
     *
     * @param trainingId the training id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<Training> findTrainingById(int trainingId) throws DaoException;

    /**
     * Find trainer clients list.
     *
     * @param trainerId the trainer id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Client> findTrainerClients(int trainerId) throws DaoException;
}
