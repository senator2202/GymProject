package com.kharitonov.gym.model.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;

import java.util.List;

/**
 * The interface Trainer application service.
 */
public interface TrainerApplicationService {
    /**
     * Add application boolean.
     *
     * @param id             the id
     * @param institution    the institution
     * @param graduationYear the graduation year
     * @param instagramLink  the instagram link
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addApplication(int id, String institution,
                           String graduationYear, String instagramLink) throws ServiceException;

    /**
     * Delete application boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean deleteApplication(String id) throws ServiceException;

    /**
     * Approve application boolean.
     *
     * @param userId         the user id
     * @param institution    the institution
     * @param graduationYear the graduation year
     * @param instagramLink  the instagram link
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean approveApplication(String userId, String institution,
                               String graduationYear, String instagramLink) throws ServiceException;

    /**
     * Gets all applications.
     *
     * @return the all applications
     * @throws ServiceException the service exception
     */
    List<TrainerApplication> getAllApplications() throws ServiceException;
}
