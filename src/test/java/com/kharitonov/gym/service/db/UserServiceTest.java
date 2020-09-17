package com.kharitonov.gym.service.db;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserServiceTest {
    private final UserService service = UserService.getInstance();

    @DataProvider
    @Test
    public Object[][] dataCheckLoginPassword() {
        String login = StaticDataProvider.CLIENT_LOGIN;
        String wrightPassword = StaticDataProvider.CLIENT_PASSWORD;
        String wrongPassword = "blablabla";
        return new Object[][]{
                {login, wrightPassword, true},
                {login, wrongPassword, false}
        };
    }

    @Test(dataProvider = "dataCheckLoginPassword")
    public void testCheckLoginPassword(String login, String password,
                                       boolean expected)
            throws ServiceException {
        /*boolean actual = service.checkLoginPassword(login, password);
        assertEquals(actual, expected);*/
    }
}