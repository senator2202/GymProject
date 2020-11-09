package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.dao.impl.TrainerApplicationDaoImpl;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.service.TrainerApplicationService;
import com.kharitonov.gym.model.validator.CommonValidator;
import com.kharitonov.gym.model.validator.TrainerApplicationValidator;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;

import java.util.List;

public class TrainerApplicationServiceImpl implements TrainerApplicationService {
    private static final TrainerApplicationServiceImpl INSTANCE = new TrainerApplicationServiceImpl();
    private final TrainerApplicationDao dao = TrainerApplicationDaoImpl.getInstance();

    private TrainerApplicationServiceImpl() {
    }

    public static TrainerApplicationServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean sendApplication(int id, String institution,
                                   String graduationYear, String instagramLink) throws ServiceException {
        if (!TrainerApplicationValidator.correctSendParameters(id, institution, graduationYear, instagramLink)) {
            return false;
        }
        int year = Integer.parseInt(graduationYear);
        try {
            boolean result;
            if (dao.exists(id)) {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                errorSet.add(ValidationError.APPLICATION_EXISTS);
                result = false;
            } else {
                result = dao.add(id, institution, year, instagramLink);
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteApplication(String userId) throws ServiceException {
        if (!CommonValidator.correctId(userId)) {
            return false;
        }
        int id = Integer.parseInt(userId);
        try {
            return dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean approveApplication(String userId, String institution, String graduationYear, String instagramLink)
            throws ServiceException {
        if (!TrainerApplicationValidator.correctApplicationParameters(userId, institution,
                graduationYear, instagramLink)) {
            return false;
        }
        int id = Integer.parseInt(userId);
        int year = Integer.parseInt(graduationYear);
        try {
            return dao.approve(id, institution, year, instagramLink);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TrainerApplication> getAllApplications() throws ServiceException {
        try {
            return dao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
