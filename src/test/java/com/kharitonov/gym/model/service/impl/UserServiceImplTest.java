package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.builder.AccountBuilder;
import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.UserDao;
import com.kharitonov.gym.model.dao.impl.UserDaoImpl;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.UserService;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestParameterName;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class UserServiceImplTest {
    private UserService service;
    private UserDao dao;

    @BeforeClass
    public void init() {
        dao = mock(UserDaoImpl.class);
        Whitebox.setInternalState(UserDaoImpl.class, "INSTANCE", dao);
        service = UserServiceImpl.getInstance();
    }

    @DataProvider
    @Test
    public Object[][] dataFindUser() {
        Object[][] objects = new Object[6][2];
        Map<String, String> emptyMap = new HashMap<>();
        Map<String, String> validMap = new HashMap<>();
        Map<String, String> invalidMap = new HashMap<>();
        objects[0][0] = emptyMap;
        objects[0][1] = Optional.empty();
        validMap.put(RequestParameterName.LOGIN, "tratata");
        validMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[1][0] = validMap;
        objects[1][1] = Optional.of(new Client(new Account()));
        invalidMap.put(RequestParameterName.LOGIN, "");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[2][0] = invalidMap;
        objects[2][1] = Optional.empty();
        invalidMap.put(RequestParameterName.LOGIN, null);
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        objects[3][0] = invalidMap;
        objects[3][1] = Optional.empty();
        invalidMap.put(RequestParameterName.LOGIN, "tratata");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, "");
        objects[4][0] = invalidMap;
        objects[4][1] = Optional.empty();
        invalidMap.put(RequestParameterName.LOGIN, "tratata");
        invalidMap.put(RequestParameterName.LOGIN_PASSWORD, null);
        objects[5][0] = invalidMap;
        objects[5][1] = Optional.empty();
        return objects;
    }

    @Test(dataProvider = "dataFindUser", groups = "login")
    public void testFindUserExisting(Map<String, String> parameters, Optional<User> expected)
            throws DaoException, ServiceException {
        when(dao.findUserByLoginPassword(anyString(), anyString())).thenReturn(expected);
        Optional<User> actual = service.findUser(parameters);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataFindUser", groups = "login")
    public void testFindUserNotExisting(Map<String, String> parameters, Optional<User> expected)
            throws DaoException, ServiceException {
        when(dao.findUserByLoginPassword(anyString(), anyString())).thenReturn(Optional.empty());
        Optional<User> actual = service.findUser(parameters);
        assertEquals(actual, Optional.empty());
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnGroups = "login")
    public void testFindUserException() throws DaoException, ServiceException {
        Map<String, String> map = new HashMap<>();
        map.put(RequestParameterName.LOGIN, "tratata");
        map.put(RequestParameterName.LOGIN_PASSWORD, "qwerty");
        when(dao.findUserByLoginPassword(anyString(), anyString())).thenThrow(new DaoException());
        service.findUser(map);
    }

    @DataProvider
    @Test
    public Object[][] dataRegisterUser() {
        Object[][] objects = new Object[11][2];
        Map<String, String> emptyMap = new HashMap<>();
        Map<String, String> validMap = new HashMap<>();
        Map<String, String> invalidMap = new HashMap<>();
        objects[0][0] = emptyMap;
        objects[0][1] = Optional.empty();
        validMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        validMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[1][0] = validMap;
        objects[1][1] = Optional.of(new Client(AccountBuilder.anAccount().build()));
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[2][0] = invalidMap;
        objects[2][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, null);
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[3][0] = invalidMap;
        objects[3][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[4][0] = invalidMap;
        objects[4][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, null);
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[5][0] = invalidMap;
        objects[5][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[6][0] = invalidMap;
        objects[6][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, null);
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[7][0] = invalidMap;
        objects[7][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty1111111111");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        objects[8][0] = invalidMap;
        objects[8][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, "");
        objects[9][0] = invalidMap;
        objects[9][1] = Optional.empty();
        invalidMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        invalidMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        invalidMap.put(RequestParameterName.REGISTRATION_EMAIL, null);
        objects[10][0] = invalidMap;
        objects[10][1] = Optional.empty();
        return objects;
    }

    @Test(dataProvider = "dataRegisterUser", groups = "register")
    public void testRegisterUserNotExisting(Map<String, String> parameters, Optional<User> expected)
            throws DaoException, ServiceException {
        when(dao.loginExists(anyString())).thenReturn(false);
        when(dao.findByEmail(anyString())).thenReturn(0);
        when(dao.add(anyString(), anyString(), anyString())).thenReturn(254);
        when(dao.findUserById(254)).thenReturn(expected);
        Optional<User> actual = service.registerUser(parameters);
        assertEquals(actual, expected);
    }

    @Test(groups = "register")
    public void testRegisterUserLoginExisting() throws DaoException, ServiceException {
        Map<String, String> validMap = new HashMap<>();
        validMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        validMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        when(dao.loginExists("tratata")).thenReturn(true);
        Optional<User> actual = service.registerUser(validMap);
        ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
        boolean result = errorSet.contains(ValidationError.LOGIN_EXISTS) && actual.isEmpty();
        errorSet.clear();
        assertTrue(result);
    }

    @Test(groups = "register")
    public void testRegisterUserEmailExisting() throws DaoException, ServiceException {
        Map<String, String> validMap = new HashMap<>();
        validMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        validMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        when(dao.loginExists("tratata")).thenReturn(false);
        when(dao.findByEmail("qwerty@gmail.com")).thenReturn(254);
        Optional<User> actual = service.registerUser(validMap);
        ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
        boolean result = errorSet.contains(ValidationError.EMAIL_EXISTS) && actual.isEmpty();
        errorSet.clear();
        assertTrue(result);
    }

    @Test(dependsOnGroups = "register")
    public void testRegisterUserException() throws DaoException, ServiceException {
        Map<String, String> validMap = new HashMap<>();
        validMap.put(RequestParameterName.REGISTRATION_LOGIN, "tratata");
        validMap.put(RequestParameterName.REGISTRATION_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REPEAT_PASSWORD, "qwerty");
        validMap.put(RequestParameterName.REGISTRATION_EMAIL, "qwerty@gmail.com");
        when(dao.loginExists(anyString())).thenThrow(new DaoException());
        service.findUser(validMap);
    }

    @DataProvider
    @Test
    public Object[][] dataConfirmAccount() {
        return new Object[][]{
                {"12", true},
                {"-12", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataConfirmAccount", groups = "confirm")
    public void testConfirmAccountExisting(String accountId, boolean expected) throws ServiceException, DaoException {
        when(dao.confirmAccount(anyInt())).thenReturn(true);
        boolean actual = service.confirmAccount(accountId);
        assertEquals(actual, expected);
    }

    @Test(groups = "confirm")
    public void testConfirmAccountNotExisting() throws ServiceException, DaoException {
        when(dao.confirmAccount(12)).thenReturn(false);
        boolean actual = service.confirmAccount("12");
        assertFalse(actual);
    }

    @Test(dependsOnGroups = "confirm", expectedExceptions = ServiceException.class)
    public void testConfirmAccountException() throws DaoException, ServiceException {
        when(dao.confirmAccount(12)).thenThrow(new DaoException());
        service.confirmAccount("12");
    }

    @Test(groups = "updateAccount")
    public void testUpdateAccountDataEmailExisting() throws DaoException, ServiceException {
        when(dao.findByEmail(anyString())).thenReturn(99);
        boolean actual = service.updateAccountData(new User(AccountBuilder.anAccount().withId(22).build()),
                "qwerty@mail.ru", "russian", "qwerty", "qwerty");
        ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
        boolean result = errorSet.contains(ValidationError.CHANGE_EMAIL_EXISTS) && !actual;
        errorSet.clear();
        assertTrue(result);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateAccount", groups = "updateAccount")
    public void testUpdateAccountDataEmailNotExisting(String email, String locale, String newPassword,
                                                      String repeatPassword, boolean expected)
            throws DaoException, ServiceException {
        Account account = AccountBuilder.anAccount().withId(222).withLocale(Account.AccountLocale.ENGLISH).build();
        User user = new Client(account);
        when(dao.findByEmail(anyString())).thenReturn(0);
        when(dao.updateAccountData(anyInt(), anyString(), any(), any())).thenReturn(true);
        boolean actual = service.updateAccountData(user, email, locale, newPassword, repeatPassword);
        assertEquals(actual, expected);
    }

    @Test(dependsOnGroups = "updateAccount", expectedExceptions = ServiceException.class)
    public void testUpdateAccountDataException() throws DaoException, ServiceException {
        Account account = AccountBuilder.anAccount().withId(222).withLocale(Account.AccountLocale.ENGLISH).build();
        User user = new Client(account);
        when(dao.updateAccountData(anyInt(), anyString(), any(), any())).thenThrow(new DaoException());
        service.updateAccountData(user, "russ@mail.ru", "russian", "qwerty", "qwerty");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdatePersonalData")
    public void testUpdatePersonalData(int userId, String firstName, String lastName, String phone, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updatePersonalData(anyInt(), anyString(), anyString(), anyString())).thenReturn(true);
        boolean actual = service.updatePersonalData(userId, firstName, lastName, phone);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testUpdatePersonalData", expectedExceptions = ServiceException.class)
    public void testUpdatePersonalDataException() throws DaoException, ServiceException {
        when(dao.updatePersonalData(anyInt(), anyString(), anyString(), anyString())).thenThrow(new DaoException());
        service.updatePersonalData(25, "alex", "tartar", "");
    }

    @DataProvider
    @Test
    public Object[][] dataFindRecentUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(AccountBuilder.anAccount().build()));
        return new Object[][]{
                {"30", users},
                {"100000", Collections.emptyList()},
                {"-30", Collections.emptyList()}
        };
    }

    @Test(dataProvider = "dataFindRecentUsers")
    public void testFindRecentUsers(String daysNumber, List<User> expected) throws DaoException, ServiceException {
        when(dao.findRecentUsers(anyInt())).thenReturn(expected);
        List<User> actual = service.findRecentUsers(daysNumber);
        assertEquals(actual, expected);
    }


    @Test(dependsOnMethods = "testFindRecentUsers", expectedExceptions = ServiceException.class)
    public void testFindRecentUsersException() throws DaoException, ServiceException {
        when(dao.findRecentUsers(anyInt())).thenThrow(new DaoException());
        service.findRecentUsers("30");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateUserImage")
    public void testUpdateUserImage(int userId, String imageName, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updateUserImage(userId, imageName)).thenReturn(true);
        boolean actual = service.updateUserImage(userId, imageName);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testUpdateUserImage", expectedExceptions = ServiceException.class)
    public void testUpdateUserImageException() throws DaoException, ServiceException {
        when(dao.updateUserImage(anyInt(), anyString())).thenThrow(new DaoException());
        service.updateUserImage(25, "path");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataBuyTrainings")
    public void testBuyTrainings(String trainingsNumber, boolean expected) throws DaoException, ServiceException {
        Client client = new Client();
        client.getAccount().setId(25);
        client.setMoneyBalance(100);
        client.setBoughtTrainings(10);
        client.setPersonalDiscount(0);
        when(dao.updateBalanceAndBoughtTrainings(anyInt(), anyDouble(), anyInt())).thenReturn(true);
        boolean actual = service.buyTrainings(client, trainingsNumber);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testBuyTrainings", expectedExceptions = ServiceException.class)
    public void testBuyTrainingsException() throws DaoException, ServiceException {
        Client client = new Client();
        client.getAccount().setId(25);
        client.setMoneyBalance(100);
        client.setBoughtTrainings(10);
        client.setPersonalDiscount(0);
        when(dao.updateBalanceAndBoughtTrainings(anyInt(), anyDouble(), anyInt())).thenThrow(new DaoException());
        service.buyTrainings(client, "5");
    }

    @Test
    public void testFindAllTrainers() throws DaoException, ServiceException {
        List<Trainer> expected = new ArrayList<>();
        when(dao.findAllTrainers()).thenReturn(expected);
        List<Trainer> actual = service.findAllTrainers();
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testFindAllTrainers", expectedExceptions = ServiceException.class)
    public void testFindAllTrainersException() throws DaoException, ServiceException {
        when(dao.findAllTrainers()).thenThrow(new DaoException());
        service.findAllTrainers();
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddToBalance")
    public void testAddToBalance(String stringAmount, boolean expected) throws DaoException, ServiceException {
        Client client = new Client();
        client.getAccount().setId(25);
        client.setMoneyBalance(100);
        when(dao.addToBalance(anyInt(), anyInt())).thenReturn(true);
        boolean actual = service.addToBalance(client, stringAmount);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testAddToBalance", expectedExceptions = ServiceException.class)
    public void testAddToBalanceException() throws DaoException, ServiceException {
        Client client = new Client();
        client.getAccount().setId(25);
        client.setMoneyBalance(100);
        when(dao.addToBalance(anyInt(), anyInt())).thenThrow(new DaoException());
        service.addToBalance(client, "100");
    }

    @DataProvider
    @Test
    public Object[][] dataFindEmailById() {
        return new Object[][]{
                {15, Optional.of(new Client())},
                {2222222, Optional.empty()},
                {-15, Optional.empty()},
        };
    }

    @Test(dataProvider = "dataFindEmailById")
    public void testFindEmailById(int userId, Optional<String> expected) throws DaoException, ServiceException {
        when(dao.findEmailById(userId)).thenReturn(expected);
        Optional<String> actual = service.findEmailById(userId);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testFindEmailById", expectedExceptions = ServiceException.class)
    public void testFindEmailByIdException() throws DaoException, ServiceException {
        when(dao.findEmailById(15)).thenThrow(new DaoException());
        service.findEmailById(15);
    }

    @DataProvider
    @Test
    public Object[][] dataBlockUser() {
        return new Object[][]{
                {"15", true},
                {"2222222", false},
                {"-15", false},
        };
    }

    @Test(dataProvider = "dataBlockUser")
    public void testBlockUser(String userId, boolean expected) throws DaoException, ServiceException {
        when(dao.blockUser(anyInt())).thenReturn(expected);
        boolean actual = service.blockUser(userId);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testBlockUser", expectedExceptions = ServiceException.class)
    public void testBlockUserException() throws DaoException, ServiceException {
        when(dao.blockUser(15)).thenThrow(new DaoException());
        service.blockUser("15");
    }

    @DataProvider
    @Test
    public Object[][] dataUnblockUser() {
        return new Object[][]{
                {"15", true},
                {"2222222", false},
                {"-15", false},
        };
    }

    @Test(dataProvider = "dataUnblockUser")
    public void testUnblockUser(String userId, boolean expected) throws DaoException, ServiceException {
        when(dao.unblockUser(anyInt())).thenReturn(expected);
        boolean actual = service.unblockUser(userId);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testUnblockUser", expectedExceptions = ServiceException.class)
    public void testUnblockUserException() throws DaoException, ServiceException {
        when(dao.unblockUser(15)).thenThrow(new DaoException());
        service.unblockUser("15");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateDiscount")
    public void testUpdateDiscount(String clientId, String personalDiscount, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updateDiscount(anyInt(), anyDouble())).thenReturn(expected);
        boolean actual = service.updateDiscount(clientId, personalDiscount);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testUpdateDiscount", expectedExceptions = ServiceException.class)
    public void testUpdateDiscountException() throws DaoException, ServiceException {
        when(dao.updateDiscount(anyInt(), anyDouble())).thenThrow(new DaoException());
        service.updateDiscount("15", "10.5");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateShortSummary")
    public void testUpdateShortSummary(int trainerId, String shortSummary, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updateShortSummary(anyInt(), anyString())).thenReturn(expected);
        boolean actual = service.updateShortSummary(trainerId, shortSummary);
        assertEquals(actual, expected);
    }

    @Test(dependsOnMethods = "testUpdateShortSummary", expectedExceptions = ServiceException.class)
    public void testUpdateShortSummaryException() throws DaoException, ServiceException {
        when(dao.updateShortSummary(anyInt(), anyString())).thenThrow(new DaoException());
        service.updateShortSummary(15, "abc");
    }
}