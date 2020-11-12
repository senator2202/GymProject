package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainerApplicationDao;
import com.kharitonov.gym.model.dao.impl.TrainerApplicationDaoImpl;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.service.TrainerApplicationService;
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
import static org.testng.Assert.assertFalse;

public class TrainerApplicationServiceImplTest {
    private TrainerApplicationService service;
    private TrainerApplicationDao dao;

    @BeforeClass
    public void init() {
        dao = mock(TrainerApplicationDaoImpl.class);
        Whitebox.setInternalState(TrainerApplicationDaoImpl.class, "INSTANCE", dao);
        service = TrainerApplicationServiceImpl.getInstance();
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSendApplication")
    public void testSendApplicationNotExisting(int id, String institution, String graduationYear, String instagramLink,
                                               boolean expected) throws DaoException, ServiceException {
        when(dao.exists(id)).thenReturn(false);
        when(dao.add(anyInt(), anyString(), anyInt(), anyString())).thenReturn(true);
        boolean actual = service.addApplication(id, institution, graduationYear, instagramLink);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSendApplication")
    public void testSendApplicationExisting(int id, String institution, String graduationYear, String instagramLink,
                                            boolean expected) throws DaoException, ServiceException {
        when(dao.exists(id)).thenReturn(true);
        boolean actual = service.addApplication(id, institution, graduationYear, instagramLink);
        assertFalse(actual);
    }

    @Test(expectedExceptions = ServiceException.class,
            dependsOnMethods = {"testSendApplicationExisting", "testSendApplicationNotExisting"})
    public void testSendApplicationException() throws DaoException, ServiceException {
        when(dao.add(anyInt(), anyString(), anyInt(), anyString())).thenThrow(new DaoException());
        service.addApplication(2, "BSU", "2015", "https://www.instagram.com/xzibit");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataIdValidation")
    public void testDeleteApplication(String userId, boolean expected) throws DaoException, ServiceException {
        when(dao.delete(anyInt())).thenReturn(expected);
        boolean actual = service.deleteApplication(userId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testDeleteApplicationException() throws DaoException, ServiceException {
        when(dao.delete(anyInt())).thenThrow(new DaoException());
        service.deleteApplication("24");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataApproveApplication")
    public void testApproveApplication(String userId, String institution, String graduationYear,
                                       String instagramLink, boolean expected) throws DaoException, ServiceException {
        when(dao.approve(anyInt(), anyString(), anyInt(), anyString())).thenReturn(expected);
        boolean actual = service.approveApplication(userId, institution, graduationYear, instagramLink);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testApproveApplicationException() throws DaoException, ServiceException {
        when(dao.approve(anyInt(), anyString(), anyInt(), anyString())).thenThrow(new DaoException());
        service.approveApplication("2", "BSU", "2015", "https://www.instagram.com/xzibit");
    }

    @Test
    public void testGetAllApplications() throws DaoException, ServiceException {
        List<TrainerApplication> expected = new ArrayList<>();
        when(dao.findAll()).thenReturn(expected);
        List<TrainerApplication> actual = service.getAllApplications();
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testGetAllApplications")
    public void testGetAllApplicationsException() throws DaoException, ServiceException {
        List<TrainerApplication> expected = new ArrayList<>();
        when(dao.findAll()).thenThrow(new DaoException());
        service.getAllApplications();
    }
}