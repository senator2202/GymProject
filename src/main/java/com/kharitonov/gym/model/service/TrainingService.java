package com.kharitonov.gym.model.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The interface Training service.
 */
public interface TrainingService {
    /**
     * Add training int.
     *
     * @param trainerId    the trainer id
     * @param clientId     the client id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @return the int
     * @throws ServiceException the service exception
     */
    int addTraining(String trainerId, int clientId, String trainingDate, String trainingTime) throws ServiceException;

    /**
     * Find client trainings list.
     *
     * @param clientId the client id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Training> findClientTrainings(int clientId) throws ServiceException;

    /**
     * Find trainer trainings list.
     *
     * @param trainerId the trainer id
     * @return the list
     * @throws ServiceException the service exception
     */
    List<Training> findTrainerTrainings(int trainerId) throws ServiceException;

    /**
     * Update description boolean.
     *
     * @param trainingId  the training id
     * @param description the description
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateDescription(String trainingId, String description) throws ServiceException;

    /**
     * Delete training boolean.
     *
     * @param trainingId the training id
     * @param userId     the user id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean deleteTraining(String trainingId, int userId) throws ServiceException;

    /**
     * Update training boolean.
     *
     * @param trainingId   the training id
     * @param trainingDate the training date
     * @param trainingTime the training time
     * @param description  the description
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateTraining(String trainingId, String trainingDate, String trainingTime, String description)
            throws ServiceException;

    /**
     * Sets training done.
     *
     * @param trainingId the training id
     * @return the training done
     * @throws ServiceException the service exception
     */
    boolean setTrainingDone(String trainingId) throws ServiceException;

    /**
     * Rate training boolean.
     *
     * @param trainingId the training id
     * @param rating     the rating
     * @param trainerId  the trainer id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean rateTraining(String trainingId, String rating, String trainerId) throws ServiceException;

    /**
     * Find training by id optional.
     *
     * @param trainingId the training id
     * @return the optional
     * @throws ServiceException the service exception
     */
    Optional<Training> findTrainingById(int trainingId) throws ServiceException;

    /**
     * Find trainer clients map.
     *
     * @param trainerId the trainer id
     * @return the map
     * @throws ServiceException the service exception
     */
    Map<Integer, Client> findTrainerClients(int trainerId) throws ServiceException;
}
