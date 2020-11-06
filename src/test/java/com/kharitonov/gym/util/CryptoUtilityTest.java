package com.kharitonov.gym.util;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import com.kharitonov.gym.util.CryptoUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CryptoUtilityTest {
    @DataProvider
    public Object[][] dataEncrypt() {
        return new Object[][]{
                {StaticDataProvider.CLIENT_PASSWORD, StaticDataProvider.CLIENT_PASSWORD_ENCRYPTED, true},
                {StaticDataProvider.CLIENT_PASSWORD, "blablabla", false},
        };
    }

    @Test(dataProvider = "dataEncrypt")
    public void testEncrypt(String source, String expectedEncrypted,
                            boolean expected) {
        String actualEncrypted = CryptoUtility.encryptMessage(source);
        boolean actual = actualEncrypted.equals(expectedEncrypted);
        assertEquals(actual, expected);
    }
}