package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.FeedbackDao;
import com.kharitonov.gym.model.dao.impl.FeedbackDaoImpl;
import com.kharitonov.gym.model.service.FeedbackService;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeedbackServiceImplTest {
    private FeedbackService service;
    private FeedbackDao dao;

    @BeforeClass
    public void init() {
        service = FeedbackServiceImpl.getInstance();
        dao = mock(FeedbackDaoImpl.class);
        Whitebox.setInternalState(FeedbackDaoImpl.class, "INSTANCE", dao);
    }

    @DataProvider
    @Test
    public Object[][] dataAddFeedback() {
        return new Object[][]{

        };
    }

    @Test(dataProvider = "dataAddFeedback")
    public void testAddFeedback(String name, String email, String subject, String message, boolean expected)
            throws ServiceException, DaoException {
        /*when(dao.add(name, email, subject, message))*/
    }
}