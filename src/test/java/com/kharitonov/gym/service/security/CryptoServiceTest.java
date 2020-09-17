package com.kharitonov.gym.service.security;

import com.kharitonov.gym.data_provider.StaticDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CryptoServiceTest {
    private final CryptoService cryptoService = new CryptoService();

    @DataProvider
    public static Object[][] dataDecrypt() {
        return new Object[][]{
                {StaticDataProvider.CLIENT_PASSWORD_ENCRYPTED,
                        StaticDataProvider.CLIENT_PASSWORD, true},
                {StaticDataProvider.CLIENT_PASSWORD_ENCRYPTED,
                        "blablabla", false}
        };
    }

    @DataProvider
    public Object[][] dataEncrypt() {
        return new Object[][]{
                {StaticDataProvider.CLIENT_PASSWORD,
                        StaticDataProvider.CLIENT_PASSWORD_ENCRYPTED, true},
                {StaticDataProvider.CLIENT_PASSWORD, "blablabla", false},
        };
    }

    @Test(dataProvider = "dataEncrypt")
    public void testEncrypt(String source, String expectedEncrypted,
                            boolean expected) {
        String actualEncrypted = cryptoService.encryptMessage(source);
        boolean actual = actualEncrypted.equals(expectedEncrypted);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataDecrypt")
    public void testDecrypt(String encrypted, String expectedSource,
                            boolean expected) {
        String actualSource = cryptoService.decryptMessage(encrypted);
        boolean actual = actualSource.equals(expectedSource);
        assertEquals(actual, expected);
    }
}