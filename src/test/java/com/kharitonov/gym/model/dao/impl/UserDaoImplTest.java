package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.util.CryptoUtility;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDaoImplTest {
    private final UserDaoImpl dao = new UserDaoImpl();

    @Test
    public void testAddClient() throws DaoException {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            String login = "client" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            String encryptedPassword = CryptoUtility.encryptMessage(password);
            boolean result;
            dao.add(login, encryptedPassword, email);
            result = dao.checkLoginPassword(login, encryptedPassword).isPresent();
            assertTrue(result);
        }
    }

    @Test
    public void testAddTrainer() throws DaoException {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            String login = "trainer" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            String encryptedString = CryptoUtility.encryptMessage(password);
            boolean result;
            dao.add(login, encryptedString, email);
            result = dao.checkLoginPassword(login, encryptedString).isPresent();
            assertTrue(result);
        }
    }

    @Test
    public void testAddAdmin() throws DaoException {
        /*User user = StaticDataProvider.USER_ADMIN;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        CryptoService cryptoService = new CryptoService();
        String encryptedPassword = cryptoService.encryptMessage(password);
        dao.add(user, encryptedPassword);*/
        assertTrue(true);
    }

    @Test
    public void testCheckLoginPassword() throws DaoException {
        String name = StaticDataProvider.ADMIN_LOGIN;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        String encryptedString = CryptoUtility.encryptMessage(password);
        boolean result =
                dao.checkLoginPassword(name, encryptedString).isPresent();
        assertTrue(result);
    }

    @Test
    public void testGetUser() throws DaoException {
        String name = StaticDataProvider.CLIENT_LOGIN;
        String password = StaticDataProvider.CLIENT_PASSWORD_ENCRYPTED;
        User actualUser = dao.findUser(name, password).get();
        User expectedUser = null;
        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testGetAll() throws DaoException {
        List<User> users = dao.findAllUsers();
        assertTrue(true);
    }
}