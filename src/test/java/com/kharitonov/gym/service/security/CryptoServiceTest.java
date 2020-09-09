package com.kharitonov.gym.service.security;

import org.testng.annotations.Test;

import java.security.Provider;
import java.security.Security;

import static org.testng.Assert.assertEquals;

public class CryptoServiceTest {
    private final CryptoService cryptoService = new CryptoService();

    @Test
    public void testCryptoService() {
        String source = "admin";
        String encrypted = cryptoService.encryptMessage(source);
        String decrypted = cryptoService.decryptMessage(encrypted);
        assertEquals(decrypted, source);
    }
}