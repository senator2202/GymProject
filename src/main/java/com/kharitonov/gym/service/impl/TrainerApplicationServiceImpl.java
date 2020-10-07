package com.kharitonov.gym.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.dao.impl.TrainerApplicationDaoImpl;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.service.TrainerApplicationService;

import java.util.List;

public class TrainerApplicationServiceImpl implements TrainerApplicationService {
    private static final TrainerApplicationServiceImpl INSTANCE =
            new TrainerApplicationServiceImpl();

    private TrainerApplicationServiceImpl() {}

    public static TrainerApplicationServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean sendApplication(int id, String institution,
                                   int graduationYear, String instagramLink) throws ServiceException {
        TrainerApplicationDao dao = new TrainerApplicationDaoImpl();
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

    @Override
    public List<TrainerApplication> deleteApplication(int userId) throws ServiceException {
        TrainerApplicationDao dao = new TrainerApplicationDaoImpl();
        try {
            dao.deleteApplication(userId);
            return dao.findAllApplications();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TrainerApplication> getAllApplications() throws ServiceException {
        TrainerApplicationDao dao = new TrainerApplicationDaoImpl();
        try {
            return dao.findAllApplications();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
