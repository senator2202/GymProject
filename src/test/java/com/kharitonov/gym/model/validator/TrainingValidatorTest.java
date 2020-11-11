package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TrainingValidatorTest {

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateDescription")
    public void testCorrectUpdateDescriptionParameters(String id, String description, boolean expected) {
        boolean actual = TrainingValidator.correctUpdateDescriptionParameters(id, description);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataUpdateTraining")
    public void testCorrectUpdateTrainingParameters(String trainingId, String trainingDate,
                                                    String trainingTime, String description, boolean expected) {
        boolean actual = TrainingValidator.correctUpdateTrainingParameters(trainingId, trainingDate,
                trainingTime, description);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddTraining")
    public void testCorrectAddTrainingParameters(String trainerId, int clientId, String trainingDate,
                                                 String trainingTime, int expected) {
        boolean actual = TrainingValidator.correctAddTrainingParameters(trainerId, clientId, trainingDate, trainingTime);
        assertEquals(actual, expected > 0);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataRateTraining")
    public void testCorrectRateTrainingParameters(String trainingId, String trainingRating,
                                                  String trainerId, boolean expected) {
        boolean actual = TrainingValidator.correctRateTrainingParameters(trainingId, trainingRating, trainerId);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataBuyTrainings")
    public void testCorrectTrainingsNumber(String trainingsNumber, boolean expected) {
        boolean actual = TrainingValidator.correctTrainingsNumber(trainingsNumber);
        assertEquals(actual, expected);
    }
}