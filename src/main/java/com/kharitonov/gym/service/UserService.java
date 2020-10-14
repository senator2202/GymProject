package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(String login, String password)
            throws ServiceException;

    User registerUser(String login, String password, String email)
            throws ServiceException;

    void confirmAccount(int id) throws ServiceException;

    void updateUserInfo(String firstName, String lastName, String phone, String email,
                        String locale, int id)
            throws ServiceException;

    void appointTrainer(int userId, String institution,
                        int graduationYear, String instagramLink) throws ServiceException;

    List<User> findRecentUsers(int days) throws ServiceException;

    void updateUserImage(int userId, String imageName) throws ServiceException;

    void buyTrainings(Client client, int trainingsNumber, double trainingCost) throws ServiceException;

    List<User> findAllTrainers() throws ServiceException;

    int findId(String name) throws ServiceException;
}
