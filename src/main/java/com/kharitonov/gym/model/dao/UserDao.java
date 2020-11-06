package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao {
    int add(String login, String encryptedPassword, String email) throws DaoException;

    Optional<User> findUser(String name, String encryptedPassword) throws DaoException;

    List<User> findAllUsers() throws DaoException;

    boolean loginExists(String login) throws DaoException;

    int findByEmail(String email) throws DaoException;

    Optional<UserRole> checkLoginPassword(String login, String encryptedPassword)
            throws DaoException;

    void confirmAccount(int id) throws DaoException;

    void updateAccountData(int userId, String email, String locale, String password) throws DaoException;

    void updatePersonalData(int userId, String firstName, String lastName, String phone)
            throws DaoException;

    List<User> findRecentUsers(int days) throws DaoException;

    void updateUserImage(int userId, String imageName) throws DaoException;

    void updateBalanceAndBoughtTrainings(int userId, double decreaseBalance, int increaseTrainings) throws DaoException;

    List<Trainer> findAllTrainers() throws DaoException;

    void addToBalance(int userId, int amount) throws DaoException;

    Optional<String> findEmailById(int userId) throws DaoException;

    void blockUser(int userId) throws DaoException;

    void unblockUser(int userId) throws DaoException;

    void updateDiscount(int clientId, double discount) throws DaoException;

    void updateShortSummary(int trainerId, String shortSummary) throws DaoException;

    String findPassword(int userId) throws DaoException;
}
