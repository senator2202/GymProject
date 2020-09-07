package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.impl.Client;
import com.kharitonov.gym.model.entity.impl.Trainer;
import com.kharitonov.gym.security.WebCipher;
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
            WebCipher cipher = new WebCipher();
            Random random = new Random();
            String name = "client" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
            boolean result;
            Account account = Account.AccountBuilder.anAccount()
                    .withName(name)
                    .withEmail(email)
                    .build();
            Client client = new Client(account);
            dao.add(client, encryptedBytes);
            result = dao.checkLoginPassword(name, encryptedBytes);
            assertTrue(result);
        }
    }

    @Test
    public void testAddTrainer() throws DaoException {
        for (int i = 0; i < 10; i++) {
            WebCipher cipher = new WebCipher();
            Random random = new Random();
            String name = "trainer" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
            boolean result;
            Account account = Account.AccountBuilder.anAccount()
                    .withName(name)
                    .withEmail(email)
                    .build();
            Trainer trainer = new Trainer(account);
            dao.add(trainer, encryptedBytes);
            result = dao.checkLoginPassword(name, encryptedBytes);
            assertTrue(result);
        }
    }

    @Test
    public void testAddAdmin() throws DaoException {
        /*User user = StaticDataProvider.USER_ADMIN;
        byte[] password = StaticDataProvider.ADMIN_PASSWORD_ENCRYPTED;
        dao.add(user, password);
        assertTrue(true);*/
    }

    @Test
    public void testCheckLoginPassword() throws DaoException {
        for (int i = 0; i<10; i++) {
            String name = StaticDataProvider.ADMIN_NAME;
            String password = StaticDataProvider.ADMIN_PASSWORD;
            WebCipher cipher = new WebCipher();
            byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
            boolean result = dao.checkLoginPassword(name, encryptedBytes);
            assertTrue(result);
        }
    }

    @Test
    public void testGet() throws DaoException {
        String name = StaticDataProvider.ADMIN_NAME;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        WebCipher cipher = new WebCipher();
        byte[] encryptedBytes = cipher.encryptMessage(password.getBytes());
        User actualUser = dao.get(name, encryptedBytes).get();
        User expectedUser = StaticDataProvider.USER_ADMIN;
        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testGetAll() throws DaoException {
        List<User> users = dao.getAll();
        assertTrue(true);
    }
}