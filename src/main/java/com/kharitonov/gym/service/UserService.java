package com.kharitonov.gym.service;

import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(Map<String, String> parameters)
            throws ServiceException;

    Optional<User> registerUser(Map<String, String> parameters) throws ServiceException;

    boolean confirmAccount(String accountId) throws ServiceException;

    boolean updateAccountData(User user, String email, String locale) throws ServiceException;

    boolean updatePersonalData(int userId, String firstName, String lastName, String phone)
            throws ServiceException;

    List<User> findRecentUsers(String daysNumber) throws ServiceException;

    boolean updateUserImage(int userId, String imageName) throws ServiceException;

    boolean buyTrainings(Client client, String trainingsNumber, double trainingCost) throws ServiceException;

    List<User> findAllTrainers() throws ServiceException;

    boolean addToBalance(Client client, String amount) throws ServiceException;

    Optional<String> findEmailById(int userId) throws ServiceException;

    boolean blockUser(String userId) throws ServiceException;

    boolean unblockUser(String userId) throws ServiceException;

    boolean updateDiscount(String clientId, String discount) throws ServiceException;
}
