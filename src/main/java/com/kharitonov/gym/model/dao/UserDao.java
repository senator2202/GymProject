package com.kharitonov.gym.model.dao;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user, String encryptedPassword) throws DaoException;

    Optional<User> get(String name, String encryptedPassword) throws DaoException;

    List<User> getAll() throws DaoException;

    String getPassword(String login) throws DaoException;

    Optional<UserRole> checkLoginPassword(String login, String encryptedPassword)
            throws DaoException;

    void confirmAccount(int id) throws DaoException;

    default void close(ResultSet resultSet) throws DaoException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing result set!");
            }
        }
    }

    default void close(Statement statement) throws DaoException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing statement!");
            }
        }
    }
}
