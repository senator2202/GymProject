package com.kharitonov.gym.model.validator;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FeedbackValidatorTest {

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataAddFeedback")
    public void testCorrectAddParameters(String name, String email, String subject, String message, boolean expected) {
        boolean actual = FeedbackValidator.correctAddParameters(name, email, subject, message);
        assertEquals(actual, expected);
    }

    @Test(dataProviderClass = StaticDataProvider.class, dataProvider = "dataSendReplyMessage")
    public void testCorrectReplyParameters(String id, String email, String subject, String message, boolean expected) {
        boolean actual = FeedbackValidator.correctReplyParameters(id, email, subject, message);
        assertEquals(actual, expected);
    }
}