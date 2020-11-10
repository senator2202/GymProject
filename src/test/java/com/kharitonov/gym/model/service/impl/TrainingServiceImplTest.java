package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.service.TrainingService;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TrainingServiceImplTest {
    private TrainingService service;
    private TrainingDao dao;

    @BeforeClass
    public void init() {
        dao = mock(TrainingDaoImpl.class);
        Whitebox.setInternalState(TrainingDaoImpl.class, "INSTANCE", dao);
        service = TrainingServiceImpl.getInstance();
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddTraining")
    public void testAddTraining(String trainerId, int clientId, String date, String time, int expected)
            throws DaoException, ServiceException {
        when(dao.add(anyInt(), anyInt(), any(), any())). thenReturn(expected);
        int actual = service.addTraining(trainerId, clientId, date, time);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testSendApplicationException() throws DaoException, ServiceException {
        when(dao.add(anyInt(), anyInt(), any(), any())). thenThrow(new DaoException());
        service.addTraining("22", 24, "2020-05-05", "14:25:00");
    }

    @DataProvider
    @Test
    public Object [][] dataFindClientTrainings() {
        return new Object[][] {
                {-24, }
        };
    }

    @Test
    public void testFindClientTrainings(int clientId, List<Training> expected)  throws DaoException, ServiceException {
        when(dao.findClientTrainings(anyInt())).thenReturn(expected);
        List<Training> actual = service.findClientTrainings(clientId);
        assertEquals(actual, expected);
    }
}