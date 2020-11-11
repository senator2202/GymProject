package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.service.FeedbackService;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
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

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddFeedback")
    public void testAddFeedback(String name, String email, String subject, String message, boolean expected)
            throws DaoException, ServiceException {
        when(dao.add(name, email, subject, message)).thenReturn(true);
        boolean actual = service.addFeedback(name, email, subject, message);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testAddFeedbackException()
            throws DaoException, ServiceException {
        when(dao.add(anyString(), anyString(), anyString(), anyString())).thenThrow(new DaoException());
        service.addFeedback("alex", "tartar@mai.ru", "", "message");
    }

    @Test
    public void testFindAllFeedbacks() throws DaoException, ServiceException {
        List<Feedback> expected = new ArrayList<>();
        when(dao.findAll()).thenReturn(expected);
        List<Feedback> actual = service.findAllFeedbacks();
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testFindAllFeedbacksException() throws DaoException, ServiceException {
        when(dao.findAll()).thenThrow(new DaoException());
        List<Feedback> actual = service.findAllFeedbacks();
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSendReplyMessage")
    public void testSendReplyMessage(String id, String email, String subject, String message, boolean expected)
            throws DaoException, ServiceException {
        when(dao.addReplyMessage(anyInt(), anyString())).thenReturn(true);
        boolean actual = service.addReplyMessage(id, email, subject, message);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testSendReplyMessageException() throws DaoException, ServiceException {
        when(dao.addReplyMessage(anyInt(), anyString())).thenThrow(new DaoException());
        service.addReplyMessage("1", "tartar@mai.ru", "", "message");
    }
}