package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TrainerApplicationValidatorTest {

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataApproveApplication")
    public void testCorrectApplicationParameters(String userId, String institution,
                                                 String graduationYear, String instagramLink, boolean expected) {
        boolean actual = TrainerApplicationValidator.correctApplicationParameters(userId, institution,
                graduationYear, instagramLink);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSendApplication")
    public void testCorrectSendParameters(int id, String institution, String year, String instagram, boolean expected) {
        boolean actual = TrainerApplicationValidator.correctSendParameters(id, institution, year, instagram);
        assertEquals(actual, expected);
    }
}