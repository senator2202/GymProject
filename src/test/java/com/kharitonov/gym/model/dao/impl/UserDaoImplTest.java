package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.security.WebCipher;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDaoImplTest {
    private final UserDaoImpl dao = new UserDaoImpl();

    @Test
    public void testAdd() throws DaoException {
        WebCipher cipher = new WebCipher();
        Random random = new Random();
        String name = "user" + random.nextInt(10000);
        String password = "password" + random.nextInt(1000);
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        boolean result;
        User user = new User(name, password, false);
        dao.add(user, encryptedBytes);
        result = dao.checkLoginPassword(name, encryptedBytes);
        assertTrue(result);
    }

    @Test
    public void testCheckLoginPassword() throws DaoException {
        WebCipher cipher = new WebCipher();
        byte[] encryptedBytes = cipher.encryptMessage("admin".getBytes());
        boolean result = dao.checkLoginPassword("admin", encryptedBytes);
        assertTrue(result);
    }

    @Test
    public void testGet() throws DaoException {
        WebCipher cipher = new WebCipher();
        byte[] encryptedBytes = cipher.encryptMessage("admin".getBytes());
        User actualUser = dao.get("admin", encryptedBytes);
        User expectedUser = new User("admin", "admin", true);
        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testGetAll() throws DaoException {
        dao.getAll();
        assertTrue(true);
    }
}