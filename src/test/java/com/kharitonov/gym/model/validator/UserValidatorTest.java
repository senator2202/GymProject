package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.util.RequestParameterName;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class UserValidatorTest {

    @DataProvider
    @Test
    private static Object[][] dataCorrectLoginParameters() {
        Object[][] objects = new Object[6][2];
        Map<String, String> emptyMap = new HashMap<>();
        Map<String, String> validMap = new HashMap<>();
        Map<String, String> invalidMap = new HashMap<>();
        objects[0][0] = emptyMap;
        objects[0][1] = false;
        validMap.put(RequestParameterName.LOGIN, "tratata");
        validMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[1][0] = validMap;
        objects[1][1] = true;
        invalidMap.put(RequestParameterName.LOGIN, "");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[2][0] = invalidMap;
        objects[2][1] = false;
        invalidMap.put(RequestParameterName.LOGIN, null);
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[3][0] = invalidMap;
        objects[3][1] = false;
        invalidMap.put(RequestParameterName.LOGIN, "tratata");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "");
        objects[4][0] = invalidMap;
        objects[4][1] = false;
        invalidMap.put(RequestParameterName.LOGIN, "tratata");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, null);
        objects[5][0] = invalidMap;
        objects[5][1] = false;
        return objects;
    }

    @DataProvider
    @Test
    private static Object[][] dataCorrectRegisterParameters() {
        Object[][] objects = new Object[11][2];
        Map<String, String> emptyMap = new HashMap<>();
        Map<String, String> validMap = new HashMap<>();
        Map<String, String> invalidMap = new HashMap<>();
        objects[0][0] = emptyMap;
        objects[0][1] = false;
        validMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        validMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[1][0] = validMap;
        objects[1][1] = true;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[2][0] = invalidMap;
        objects[2][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, null);
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[3][0] = invalidMap;
        objects[3][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[4][0] = invalidMap;
        objects[4][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, null);
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[5][0] = invalidMap;
        objects[5][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[6][0] = invalidMap;
        objects[6][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, null);
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[7][0] = invalidMap;
        objects[7][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty1111111111");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[8][0] = invalidMap;
        objects[8][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "");
        objects[9][0] = invalidMap;
        objects[9][1] = false;
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, null);
        objects[10][0] = invalidMap;
        objects[10][1] = false;
        return objects;
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateShortSummary")
    public void testCorrectUpdateSummaryParameters(int id, String summary, boolean expected) {
        boolean actual = UserValidator.correctUpdateSummaryParameters(id, summary);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateUserImage")
    public void testCorrectUpdateImageParameters(int id, String imageName, boolean expected) {
        boolean actual = UserValidator.correctUpdateImageParameters(id, imageName);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdatePersonalData")
    public void testCorrectPersonalDataParameters(int userId, String firstName, String lastName,
                                                  String phone, boolean expected) {
        boolean actual = UserValidator.correctPersonalDataParameters(userId, firstName, lastName, phone);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateAccount")
    public void testCorrectAccountDataParameters(String email, String locale,
                                                 String newPassword, String repeatPassword, boolean expected) {
        boolean actual = UserValidator.correctAccountDataParameters(email, locale, newPassword, repeatPassword);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateDiscount")
    public void testCorrectUpdateDiscountParameters(String id, String discount, boolean expected) {
        boolean actual = UserValidator.correctUpdateDiscountParameters(id, discount);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataCorrectLoginParameters")
    public void testCorrectLoginParameters(Map<String, String> parameters, boolean expected) {
        boolean actual = UserValidator.correctLoginParameters(parameters);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataCorrectRegisterParameters")
    public void testCorrectRegisterParameters(Map<String, String> parameters, boolean expected) {
        boolean actual = UserValidator.correctRegisterParameters(parameters);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddToBalance")
    public void testCorrectDepositAmount(String amount, boolean expected) {
        boolean actual = UserValidator.correctDepositAmount(amount);
        assertEquals(actual, expected);
    }

    @DataProvider
    @Test
    private Object[][] dataCorrectDaysNumber() {
        return new Object[][]{
                {"30", true},
                {"100000", false},
                {"-30", false},
                {null, true}
        };
    }

    @Test(dataProvider = "dataCorrectDaysNumber")
    public void testCorrectDaysNumber(String days, boolean expected) {
        boolean actual = UserValidator.correctDaysNumber(days);
        assertEquals(actual, expected);
    }
}