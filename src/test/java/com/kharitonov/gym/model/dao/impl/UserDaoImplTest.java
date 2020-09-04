package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.security.WebCipher;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDaoImplTest {
    private final UserDaoImpl dao = new UserDaoImpl();

    @Test
    public void testAdd() throws DaoException {
        /*WebCipher cipher = new WebCipher();
        Random random = new Random();
        String name = "user" + random.nextInt(10000);
        String password = "password" + random.nextInt(1000);
        String email = "email" + random.nextInt(1000000) + "@gmail.com";
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        boolean result;
        User user = User.UserBuilder.aUser()
                .withName(name)
                .withEmail(email)
                .withType(UserRole.CLIENT)
                .build();
        dao.add(user, encryptedBytes);
        result = dao.checkLoginPassword(name, encryptedBytes);
        assertTrue(result);*/
    }

    @Test
    public void testAddAdmin() throws DaoException {
       /* WebCipher cipher = new WebCipher();
        String name = StaticDataProvider.ADMIN_NAME;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        String email = StaticDataProvider.ADMIN_EMAIL;
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        boolean result;
        User user = User.UserBuilder.aUser()
                .withName(name)
                .withEmail(email)
                .withType(UserRole.ADMIN)
                .build();
        dao.add(user, encryptedBytes);
        result = dao.checkLoginPassword(name, encryptedBytes);
        assertTrue(result);*/
    }

    @Test
    public void testCheckLoginPassword() throws DaoException {
        String name = StaticDataProvider.ADMIN_NAME;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        WebCipher cipher = new WebCipher();
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        boolean result = dao.checkLoginPassword(name, encryptedBytes);
        assertTrue(result);
    }

    @Test
    public void testGet() throws DaoException {
        String name = StaticDataProvider.ADMIN_NAME;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        WebCipher cipher = new WebCipher();
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        User actualUser = dao.get(name, encryptedBytes);
        User expectedUser = StaticDataProvider.USER_CLIENT;
        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testGetAll() throws DaoException {
        dao.getAll();
        assertTrue(true);
    }
}