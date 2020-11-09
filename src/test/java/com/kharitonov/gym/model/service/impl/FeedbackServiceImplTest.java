package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.service.FeedbackService;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
public class FeedbackServiceImplTest {
    private FeedbackService service;
    private FeedbackDao dao;

    @BeforeClass
    public void init() {
        dao = mock(FeedbackDaoImpl.class);
        Whitebox.setInternalState(FeedbackDaoImpl.class, "INSTANCE", dao);
        service = FeedbackServiceImpl.getInstance();
    }

    @DataProvider
    @Test
    public Object[][] dataAddFeedback() {
        return new Object[][]{
                {"alex", "tartar@mai.ru", "", "message", true},
                {"", "tartar@mai.ru", "", "message", true},
                {"", "tartar@mai.ru", "bad", "message", true},
                {"alex", "tartar@mai.ru", "bad", "message", true},
                {null, "ban@gmail.com", "", "m", false},
                {"null", "bsdf123123!@#!@#!@#!@#!@#an@gmail.com", "", "m", false},
                {"null", null, "", "m", false},
                {"null", "alex@tut.by", null, "m", false},
                {"null", "alex@tut.by", "", "", false},
                {"null", "alex@tut.by", "", null, false},
                {"", "", "", "m", false},
                {"", "san@tut.by", "", null, false},
                {"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "asas@tut.by", "", "m", false},
                {"", "asas@tut.by", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "m", false}
        };
    }

    @Test(dataProvider = "dataAddFeedback")
    public void testAddFeedback(String name, String email, String subject, String message, boolean expected)
            throws DaoException, ServiceException {
        when(dao.add(name, email, subject, message)).thenReturn(true);
        boolean actual = service.addFeedback(name, email, subject, message);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllFeedbacks() throws DaoException, ServiceException {
        List<Feedback> expected = new ArrayList<>();
        when(dao.findAll()).thenReturn(expected);
        List<Feedback> actual = service.findAllFeedbacks();
        assertEquals(actual, expected);
    }

    @DataProvider
    @Test
    public Object[][] dataSendReplyMessage() {
        return new Object[][]{
                {"1", "tartar@mai.ru", "", "message", true},
                {"22", "tartar@mai.ru", "bad", "message", true},
                {null, "ban@gmail.com", "", "m", false},
                {"-1", "ban@gmail.com", "", "m", false},
                {"null", "bsdf123123!@#!@#!@#!@#!@#an@gmail.com", "", "m", false},
                {"null", null, "", "m", false},
                {"null", "alex@tut.by", null, "m", false},
                {"null", "alex@tut.by", "", "", false},
                {"null", "alex@tut.by", "", null, false},
                {"", "", "", "m", false},
                {"", "san@tut.by", "", null, false},
                {"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "asas@tut.by", "", "m", false},
                {"", "asas@tut.by", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "m", false}
        };
    }

    @Test(dataProvider = "dataSendReplyMessage")
    public void testSendReplyMessage(String id, String email, String subject, String message, boolean expected)
            throws DaoException, ServiceException {
        when(dao.addReplyMessage(anyInt(), anyString())).thenReturn(true);
        boolean actual = service.addReplyMessage(id, email, subject, message);
        assertEquals(actual, expected);
    }
}