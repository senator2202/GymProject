package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String login, String password)
            throws ServiceException;

    User registerUser(String login, String password, String email)
            throws ServiceException;

    void confirmAccount(int id) throws ServiceException;

    void updateUserInfo(String firstName, String lastName, String phone, String email,
                        String locale, int id)
            throws ServiceException;

    void appointTrainer(int userId, String institution,
                        int graduationYear, String instagramLink) throws ServiceException;

    List<User> getRecentUsers() throws ServiceException;
}
