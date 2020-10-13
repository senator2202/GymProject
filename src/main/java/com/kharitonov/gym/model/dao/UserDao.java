package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao {
    void addUser(String login, String encryptedPassword, String email) throws DaoException;

    Optional<User> findUser(String name, String encryptedPassword) throws DaoException;

    List<User> findAllUsers() throws DaoException;

    String findPassword(String login) throws DaoException;

    Optional<UserRole> checkLoginPassword(String login, String encryptedPassword)
            throws DaoException;

    void confirmAccount(int id) throws DaoException;

    void updateUserInfo(String firstName, String lastName, String phone, String email,
                        String locale, int id)
            throws DaoException;

    void changeRoleToTrainer(int userId, String institution,
                             int graduationYear, String instagramLink) throws DaoException;

    List<User> findRecentUsers(int days) throws DaoException;

    void updateUserImage(int userId, String imageName) throws DaoException;

    void updateBalanceAndBoughtTrainings(int userId, double decreaseBalance, int increaseTrainings) throws DaoException;

    List<User> findAllTrainers() throws DaoException;

    int findId(String firstName, String lastName) throws DaoException;

    void decrementBoughtTrainings(int userId) throws DaoException;
}
