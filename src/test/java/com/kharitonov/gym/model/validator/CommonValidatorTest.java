package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CommonValidatorTest {

    @DataProvider
    @Test
    public Object[][] dataCorrectId() {
        return new Object[][]{
                {15, true},
                {0, false},
                {-15, false}
        };
    }

    @Test(dataProvider = "dataCorrectId")
    public void testCorrectId(int id, boolean expected) {
        boolean actual = CommonValidator.correctId(id);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataIdValidation")
    public void testCorrectId(String id, boolean expected) {
        boolean actual = CommonValidator.correctId(id);
        assertEquals(actual, expected);
    }
}