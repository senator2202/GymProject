package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao {
    void addUser(String login, String encryptedPassword, String email) throws DaoException;

    Optional<User> getUser(String name, String encryptedPassword) throws DaoException;

    List<User> getAllUsers() throws DaoException;

    String getPassword(String login) throws DaoException;

    Optional<UserRole> checkLoginPassword(String login, String encryptedPassword)
            throws DaoException;

    void confirmAccount(int id) throws DaoException;

    void updateUserInfo(String firstName, String lastName, String phone, String email,
                        String locale, int id)
            throws DaoException;

    void changeRoleToTrainer(int userId, String institution,
                             int graduationYear, String instagramLink) throws DaoException;

    List<User> findRecentUsers() throws DaoException;
}
