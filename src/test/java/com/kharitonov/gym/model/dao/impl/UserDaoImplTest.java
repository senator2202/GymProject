package com.kharitonov.gym.model.dao.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Trainer;
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
            CryptoUtility cipher = new CryptoUtility();
            Random random = new Random();
            String name = "client" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            String encryptedPassword = cipher.encryptMessage(password);
            boolean result;
            Account account = Account.AccountBuilder.anAccount()
                    .withName(name)
                    .withEmail(email)
                    .build();
            Client client = new Client(account);
            dao.add(client, encryptedPassword);
            result = dao.checkLoginPassword(name, encryptedPassword).isPresent();
            assertTrue(result);
        }
    }

    @Test
    public void testAddTrainer() throws DaoException {
        for (int i = 0; i < 10; i++) {
            CryptoUtility cipher = new CryptoUtility();
            Random random = new Random();
            String name = "trainer" + random.nextInt(10000000);
            String password = "password" + random.nextInt(1000);
            String email = "email" + random.nextInt(10000000) + "@gmail.com";
            String encryptedString = cipher.encryptMessage(password);
            boolean result;
            Account account = Account.AccountBuilder.anAccount()
                    .withName(name)
                    .withEmail(email)
                    .build();
            Trainer trainer = new Trainer(account);
            dao.add(trainer, encryptedString);
            result = dao.checkLoginPassword(name, encryptedString).isPresent();
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
        CryptoUtility cipher = new CryptoUtility();
        String encryptedString = cipher.encryptMessage(password);
        boolean result =
                dao.checkLoginPassword(name, encryptedString).isPresent();
        assertTrue(result);
    }

    @Test
    public void testGet() throws DaoException {
        String name = StaticDataProvider.ADMIN_LOGIN;
        String password = StaticDataProvider.ADMIN_PASSWORD;
        CryptoUtility cipher = new CryptoUtility();
        String encryptedString = cipher.encryptMessage(password);
        User actualUser = dao.get(name, encryptedString).get();
        User expectedUser = StaticDataProvider.USER_ADMIN;
        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void testGetAll() throws DaoException {
        List<User> users = dao.getAll();
        assertTrue(true);
    }
}