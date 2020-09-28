package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;

public interface TrainerApplicationService {
    boolean sendApplication(int id, String institution,
                            int graduationYear, String instagramLink) throws ServiceException;
}
