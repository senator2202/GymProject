package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.UserRole;

import java.util.Optional;

public interface UserService {
    Optional<UserRole> checkLoginPassword(String login, String password)
            throws ServiceException;

    void registerUser(String login, String password, String email, UserRole role)
            throws ServiceException;

    void confirmAccount(int id) throws ServiceException;
}
