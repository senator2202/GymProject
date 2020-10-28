package com.kharitonov.gym.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FeedbackValidatorTest {
    @DataProvider
    @Test
    private Object[][] dataCorrectAddParameters() {
        return new Object[][]{
                {"", "alex22@mail.ru", "sub", "donald duck", true},
                {null, "aza22@mail.ru", "sub", "donald duck", false},
                {"alex", "1233312", "", "donald", false}
        };
    }

    @Test(dataProvider = "dataCorrectAddParameters")
    public void testCorrectAddParameters(String name, String email, String subject, String message, boolean expected) {
        boolean actual = FeedbackValidator.correctAddParameters(name, email, subject, message);
        assertEquals(actual, expected);
    }
}