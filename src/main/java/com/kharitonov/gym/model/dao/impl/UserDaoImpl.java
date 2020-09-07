package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.creator.TableColumnName;
import com.kharitonov.gym.model.creator.UserCreator;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.pool.ConnectionPool;
import com.kharitonov.gym.model.pool.impl.BasicConnectionPool;
import com.kharitonov.gym.model.util.DataBaseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER =
            LogManager.getLogger(UserDaoImpl.class);
    private static final ConnectionPool POOL =
            BasicConnectionPool.getInstance();
    private static final DataBaseHelper DB_HELPER =
            DataBaseHelper.getINSTANCE();

    @Override
    public void add(User user, byte[] password) throws DaoException {
        Connection connection = POOL.getConnection();
        addAccount(connection, user, password);
        defineAccountId(connection, user, password);
        addUser(connection, user.getAccount().getId());
        addUserInheritor(connection, user);
        POOL.releaseConnection(connection);
    }

    private void addAccount(Connection connection, User user,
                            byte[] password) throws DaoException {
        try (PreparedStatement insertAccount =
                     DB_HELPER.statementInsertAccount(connection, user, password)) {
            insertAccount.execute();
        } catch (SQLException e) {
            POOL.releaseConnection(connection);
            throw new DaoException(e);
        }
    }

    private void addUser(Connection connection, int id) throws DaoException {
        try (PreparedStatement insertUser =
                     DB_HELPER.statementInsertUser(connection, id)) {
            insertUser.execute();
        } catch (SQLException e) {
            POOL.releaseConnection(connection);
            throw new DaoException(e);
        }
    }

    private void addUserInheritor(Connection connection, User user)
            throws DaoException {
        if (user.getAccount().getRole() != UserRole.ADMIN) {
            try (PreparedStatement insertInheritor =
                         DB_HELPER.statementInsertUserInheritor(connection, user)) {
                insertInheritor.execute();
            } catch (SQLException e) {
                POOL.releaseConnection(connection);
                throw new DaoException(e);
            }
        }
    }

    private void defineAccountId(Connection connection, User user, byte[] password)
            throws DaoException {
        String userName = user.getAccount().getName();
        try (PreparedStatement select =
                     DB_HELPER.statementSelect(connection, userName, password);
             ResultSet resultSet = select.executeQuery()) {
            int id;
            resultSet.next();
            id = resultSet.getInt(TableColumnName.USER_ID);
            user.getAccount().setId(id);
        } catch (SQLException e) {
            POOL.releaseConnection(connection);
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> get(String name, byte[] encryptedPassword)
            throws DaoException {
        Connection connection = POOL.getConnection();
        try (PreparedStatement statementSelect =
                     DB_HELPER.statementSelect(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(UserCreator.create(resultSet));
            } else {
                LOGGER.warn("There is no user with such name and password!");
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> getAll() throws DaoException {
        Connection connection = POOL.getConnection();
        List<User> users = new ArrayList<>();
        try (PreparedStatement statementSelect =
                     DB_HELPER.statementSelectAll(connection);
             ResultSet resultSet = statementSelect.executeQuery()) {
            while (resultSet.next()) {
                User user = UserCreator.create(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            POOL.releaseConnection(connection);
        }
    }

    @Override
    public boolean checkLoginPassword(String name, byte[] encryptedPassword)
            throws DaoException {
        Connection connection = POOL.getConnection();
        try (PreparedStatement statementSelect =
                     DB_HELPER.statementSelect(connection, name, encryptedPassword);
             ResultSet resultSet = statementSelect.executeQuery()) {
            return resultSet.next();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            POOL.releaseConnection(connection);
        }
    }
}
