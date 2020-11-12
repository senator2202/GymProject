package com.kharitonov.gym.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StaticDataProvider {
    public static final String CLIENT_PASSWORD = "qwerty1234";
    public static final String CLIENT_PASSWORD_ENCRYPTED = "AAER~MXQ9Vrgph\\g";

    @DataProvider
    @Test
    public Object[][] dataAddFeedback() {
        return new Object[][]{
                {"alex", "tartar@mai.ru", "", "message", true},
                {"", "tartar@mai.ru", "", "message", true},
                {"", "tartar@mai.ru", "bad", "message", true},
                {"alex", "tartar@mai.ru", "bad", "message", true},
                {null, "ban@gmail.com", "", "m", false},
                {"null", "bsdf123123!@#!@#!@#!@#!@#an@gmail.com", "", "m", false},
                {"null", null, "", "m", false},
                {"null", "alex@tut.by", null, "m", false},
                {"null", "alex@tut.by", "", "", false},
                {"null", "alex@tut.by", "", null, false},
                {"", "", "", "m", false},
                {"", "san@tut.by", "", null, false},
                {"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "asas@tut.by", "", "m", false},
                {"", "asas@tut.by", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "m", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataSendReplyMessage() {
        return new Object[][]{
                {"1", "tartar@mai.ru", "", "message", true},
                {"22", "tartar@mai.ru", "bad", "message", true},
                {null, "ban@gmail.com", "", "m", false},
                {"-1", "ban@gmail.com", "", "m", false},
                {"null", "bsdf123123!@#!@#!@#!@#!@#an@gmail.com", "", "m", false},
                {"null", null, "", "m", false},
                {"null", "alex@tut.by", null, "m", false},
                {"null", "alex@tut.by", "", "", false},
                {"null", "alex@tut.by", "", null, false},
                {"", "", "", "m", false},
                {"", "san@tut.by", "", null, false},
                {"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "asas@tut.by", "", "m", false},
                {"", "asas@tut.by", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "m", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataSendApplication() {
        return new Object[][]{
                {2, "BSU", "2015", "https://www.instagram.com/xzibit", true},
                {2, "BSU", "2015", "", true},
                {2, "BSU", "2015", null, false},
                {2, "BSU", "-2015", "https://www.instagram.com/xzibit", false},
                {2, "BSU", "", "https://www.instagram.com/xzibit", false},
                {2, "BSU", null, "https://www.instagram.com/xzibit", false},
                {2, "BS/asd", "2015", "https://www.instagram.com/xzibit", false},
                {2, null, "2015", "https://www.instagram.com/xzibit", false},
                {2, "", "2015", "https://www.instagram.com/xzibit", false},
                {-2, "BSU", "2015", "https://www.instagram.com/xzibit", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataIdValidation() {
        return new Object[][]{
                {"222", true},
                {null, false},
                {"-22", false},
                {"asdsd22a", false},
                {"0", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataApproveApplication() {
        return new Object[][]{
                {"2", "BSU", "2015", "https://www.instagram.com/xzibit", true},
                {"2", "BSU", "2015", "", true},
                {"2", "BSU", "2015", null, false},
                {"2", "BSU", "-2015", "https://www.instagram.com/xzibit", false},
                {"2", "BSU", "", "https://www.instagram.com/xzibit", false},
                {"2", "BSU", null, "https://www.instagram.com/xzibit", false},
                {"2", "BS/asd", "2015", "https://www.instagram.com/xzibit", false},
                {"2", null, "2015", "https://www.instagram.com/xzibit", false},
                {"2", "", "2015", "https://www.instagram.com/xzibit", false},
                {"-2", "BSU", "2015", "https://www.instagram.com/xzibit", false},
                {null, "BSU", "2015", "https://www.instagram.com/xzibit", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataAddTraining() {
        return new Object[][]{
                {"22", 24, "2020-05-05", "14:25:00", 254},
                {"22", 24, "2020-05-05", "144:25:00", -1},
                {"22", 24, "2020-05-05", null, -1},
                {"22", 24, "202qw0-05-05", "14:25:00", -1},
                {"22", 24, null, "14:25:00", -1},
                {"22", -24, "2020-05-05", "14:25:00", -1},
                {"22sad", 24, "2020-05-05", "14:25:00", -1},
                {null, 24, "2020-05-05", "14:25:00", -1}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateDescription() {
        return new Object[][]{
                {"12", "sadsadasddsa", true},
                {"12", "", true},
                {"12", null, false},
                {"", "asdasdas", false},
                {"-12", "ASdsads", false},
                {null, "ASdasd", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataDeleteTraining() {
        return new Object[][]{
                {"12", 25, true},
                {"12", -25, false},
                {"-12", 25, false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateTraining() {
        return new Object[][]{
                {"25", "2020-12-12", "18:00:00", "asdas", true},
                {"25", "2020-12-12", "18:00:00", "", true},
                {"25", "2020-12-12", "18:00:00", null, false},
                {"25", "2020-12-12", "118:00:00", "asdas", false},
                {"25", "2020-12-12", "", "asdas", false},
                {"25", "2020-12-12", null, "asdas", false},
                {"25", "202011-12-12", "18:00:00", "asdas", false},
                {"25", "", "18:00:00", "asdas", false},
                {"25", null, "18:00:00", "asdas", false},
                {"-1225", "2020-12-12", "18:00:00", "asdas", false},
                {"", "2020-12-12", "18:00:00", "asdas", false},
                {null, "2020-12-12", "18:00:00", "asdas", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataSetTrainingDone() {
        return new Object[][]{
                {"25", true},
                {"", false},
                {"-25", false},
                {null, false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataRateTraining() {
        return new Object[][]{
                {"25", "4", "35", true},
                {"25", "4", "", false},
                {"25", "4", "-35", false},
                {"25", "4", null, false},
                {"25", "", "35", false},
                {"25", "24", "35", false},
                {"25", null, "35", false},
                {"", "4", "35", false},
                {"-252", "4", "35", false},
                {null, "4", "35", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataBuyTrainings() {
        return new Object[][]{
                {"5", true},
                {"0", false},
                {"", false},
                {null, false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateAccount() {
        return new Object[][]{
                {"tratata@mail.ru", "russian", "qwerty", "qwerty", true},
                {"tratata@mail.ru", "russian", "", "", true},
                {"tratata@mail.ru", null, "qwerty", "qwerty", true},
                {"tratata@mail.ru", null, "", "", true},
                {"tratata@mail.ru", "russian", "qwerty", "", false},
                {"tratata@mail.ru", "russian", "", "qwerty", false},
                {"tratata@mail.ru", "russian", null, "qwerty", false},
                {"tratata@mail.ru", "russian", "qwerty", null, false},
                {"tratata@mail.ru", "russian", "q", "q", false},
                {"tratata@mail.ru", "russianaaaaa", "qwerty", "qwerty", false},
                {"tratata@mail.ru", "", "qwerty", "qwerty", false},
                {"", "russian", "qwerty", "qwerty", false},
                {null, "russian", "qwerty", "qwerty", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdatePersonalData() {
        return new Object[][]{
                {25, "alexey", "kharitonov", "+375296543211", true},
                {25, "alexey", "kharitonov", "", true},
                {25, "alexey", "", "", true},
                {25, "", "", "", true},
                {25, "alexey", "kharitonov", "+qwe", false},
                {25, "alexey", "kharitonov", null, false},
                {25, "alexey", "khariton'ov", "+375296543211", false},
                {25, "alexey", null, "+375296543211", false},
                {25, "alex''''ey", "kharitonov", "+375296543211", false},
                {25, null, "kharitonov", "+375296543211", false},
                {-25, "alexey", "kharitonov", "+375296543211", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateUserImage() {
        return new Object[][]{
                {25, "path", true},
                {25, "pathwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww" +
                        "wwwwwwwwwwwwwwwwwwwwwwwwwwwwww", false},
                {25, null, false},
                {-25, "path", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataAddToBalance() {
        return new Object[][]{
                {"100", true},
                {"", false},
                {null, false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateDiscount() {
        return new Object[][]{
                {"15", "10.5", true},
                {"15", "10,5", false},
                {"15", null, false},
                {"15.1", "10.5", false},
                {null, "10.5", false}
        };
    }

    @DataProvider
    @Test
    public Object[][] dataUpdateShortSummary() {
        return new Object[][]{
                {15, "abc", true},
                {-15, "abc", false},
                {15, null, false},
                {15, "abcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                        "aaaaaaaaaaaaaaaaaaa", false}
        };
    }
}
