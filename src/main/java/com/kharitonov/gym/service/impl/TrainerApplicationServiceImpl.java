package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.impl.TrainerApplicationDaoImpl;
import com.kharitonov.gym.service.TrainerApplicationService;

public class TrainerApplicationServiceImpl implements TrainerApplicationService {
    @Override
    public boolean sendApplication(int id, String institution,
                                   int graduationYear, String instagramLink) throws ServiceException {
        TrainerApplicationDaoImpl dao = new TrainerApplicationDaoImpl();
        try {
            boolean firstAttempt;
            if (!dao.applicationExists(id)) {
                dao.addApplication(id, institution, graduationYear, instagramLink);
                firstAttempt = true;
            } else {
                firstAttempt = false;
            }
            return firstAttempt;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
