package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;

import java.util.List;

public interface TrainerApplicationService {
    boolean sendApplication(int id, String institution,
                            String graduationYear, String instagramLink) throws ServiceException;

    boolean deleteApplication(String id) throws ServiceException;

    boolean approveApplication(String userId, String institution,
                               String graduationYear, String instagramLink) throws ServiceException;

    List<TrainerApplication> getAllApplications() throws ServiceException;
}
