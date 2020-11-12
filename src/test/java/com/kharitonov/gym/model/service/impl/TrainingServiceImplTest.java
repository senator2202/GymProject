package com.kharitonov.gym.model.service.impl;

import com.kharitonov.gym.builder.TrainingBuilder;
import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.exception.DaoException;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.dao.TrainingDao;
import com.kharitonov.gym.model.dao.impl.TrainingDaoImpl;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.service.TrainingService;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

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
        when(dao.add(anyInt(), anyInt(), any(), any())).thenReturn(expected);
        int actual = service.addTraining(trainerId, clientId, date, time);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testAddTrainingException() throws DaoException, ServiceException {
        when(dao.add(anyInt(), anyInt(), any(), any())).thenThrow(new DaoException());
        service.addTraining("22", 24, "2020-05-05", "14:25:00");
    }

    @DataProvider
    @Test
    public Object[][] dataFindTrainings() {
        return new Object[][]{
                {-24, new ArrayList<>()},
                {24, Arrays.asList(TrainingBuilder.aTraining().build())}
        };
    }

    @Test(dataProvider = "dataFindTrainings")
    public void testFindClientTrainings(int clientId, List<Training> expected) throws DaoException, ServiceException {
        when(dao.findClientTrainings(anyInt())).thenReturn(expected);
        List<Training> actual = service.findClientTrainings(clientId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testFindClientTrainings")
    public void testFindClientTrainingsException() throws DaoException, ServiceException {
        when(dao.findClientTrainings(anyInt())).thenThrow(new DaoException());
        service.findClientTrainings(24);
    }

    @Test(dataProvider = "dataFindTrainings")
    public void testFindTrainerTrainings(int trainerId, List<Training> expected) throws DaoException, ServiceException {
        when(dao.findClientTrainings(anyInt())).thenReturn(expected);
        List<Training> actual = service.findClientTrainings(trainerId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testFindTrainerTrainings")
    public void testFindTrainerTrainingsException() throws DaoException, ServiceException {
        when(dao.findTrainerTrainings(anyInt())).thenThrow(new DaoException());
        service.findTrainerTrainings(24);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateDescription")
    public void testUpdateDescription(String trainingId, String description, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updateDescription(anyInt(), anyString())).thenReturn(true);
        boolean actual = service.updateDescription(trainingId, description);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testUpdateDescription")
    public void testUpdateDescriptionException() throws DaoException, ServiceException {
        when(dao.updateDescription(anyInt(), anyString())).thenThrow(new DaoException());
        service.updateDescription("24", "asasasa");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataDeleteTraining")
    public void testDeleteTraining(String trainingId, int userId, boolean expected)
            throws DaoException, ServiceException {
        when(dao.deleteTraining(anyInt(), anyInt())).thenReturn(true);
        boolean actual = service.deleteTraining(trainingId, userId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testDeleteTraining")
    public void testDeleteTrainingException() throws DaoException, ServiceException {
        when(dao.deleteTraining(anyInt(), anyInt())).thenThrow(new DaoException());
        service.deleteTraining("24", 25);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateTraining")
    public void testUpdateTraining(String trainingId, String trainingDate, String trainingTime, String description,
                                   boolean expected) throws DaoException, ServiceException {
        when(dao.updateTraining(anyInt(), any(), any(), anyString())).thenReturn(true);
        boolean actual = service.updateTraining(trainingId, trainingDate, trainingTime, description);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testUpdateTraining")
    public void testUpdateTrainingException() throws DaoException, ServiceException {
        when(dao.updateTraining(anyInt(), any(), any(), anyString())).thenThrow(new DaoException());
        service.updateTraining("25", "2020-12-12", "18:00:00", "asdas");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSetTrainingDone")
    public void testSetTrainingDone(String trainingId, boolean expected) throws DaoException, ServiceException {
        when(dao.setTrainingDone(anyInt())).thenReturn(true);
        boolean actual = service.setTrainingDone(trainingId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testSetTrainingDone")
    public void testSetTrainingDoneException() throws DaoException, ServiceException {
        when(dao.setTrainingDone(anyInt())).thenThrow(new DaoException());
        service.setTrainingDone("25");
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataRateTraining")
    public void testRateTraining(String trainingId, String trainingRating, String trainerId, boolean expected)
            throws DaoException, ServiceException {
        when(dao.updateTrainingRating(anyInt(), anyInt(), anyInt())).thenReturn(true);
        boolean actual = service.rateTraining(trainingId, trainingRating, trainerId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testRateTraining")
    public void testRateTrainingException() throws DaoException, ServiceException {
        when(dao.updateTrainingRating(anyInt(), anyInt(), anyInt())).thenThrow(new DaoException());
        service.rateTraining("25", "4", "35");
    }

    @DataProvider
    @Test
    public Object[][] dataFindTrainingById() {
        Training training = TrainingBuilder.aTraining().build();
        return new Object[][]{
                {20, Optional.of(training)},
                {200, Optional.empty()},
                {-20, Optional.empty()}
        };
    }

    @Test(dataProvider = "dataFindTrainingById")
    public void testFindTrainingById(int trainingId, Optional<Training> expected)
            throws DaoException, ServiceException {
        when(dao.findTrainingById(trainingId)).thenReturn(expected);
        Optional<Training> actual = service.findTrainingById(trainingId);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testFindTrainingById")
    public void testFindTrainingByIdException() throws DaoException, ServiceException {
        when(dao.findTrainingById(anyInt())).thenThrow(new DaoException());
        service.findTrainingById(20);
    }

    @DataProvider
    @Test
    public Object[][] dataFindTrainerClients() {
        return new Object[][]{
                {24, new ArrayList<Client>(), new HashMap<Integer, Client>()},
                {-24, null, new HashMap<Integer, Client>()}
        };
    }

    @Test(dataProvider = "dataFindTrainerClients")
    public void testFindTrainerClients(int trainerId, List<Client> expectedList, Map<Integer, Client> expectedMap)
            throws DaoException, ServiceException {
        when(dao.findTrainerClients(trainerId)).thenReturn(expectedList);
        Map<Integer, Client> actualMap = service.findTrainerClients(trainerId);
        assertEquals(actualMap, expectedMap);
    }

    @Test(expectedExceptions = ServiceException.class, dependsOnMethods = "testFindTrainerClients")
    public void testFindTrainerClientsException() throws DaoException, ServiceException {
        when(dao.findTrainerClients(anyInt())).thenThrow(new DaoException());
        service.findTrainerClients(24);
    }
}