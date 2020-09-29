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

public interface UserDao {
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

    default void close(ResultSet resultSet) throws DaoException {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing result set!", e);
            }
        }
    }

    default void close(Statement statement) throws DaoException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DaoException("Error during closing statement!", e);
            }
        }
    }

    default void rollback(Connection connection) throws DaoException {
        if (connection!=null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new DaoException("Unable to rollback!", e);
            }
        }
    }

    default void setAutoCommitTrue(Connection connection) throws DaoException {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DaoException("Unable to set autoCommit = true", e);
            }
        }
    }
}
