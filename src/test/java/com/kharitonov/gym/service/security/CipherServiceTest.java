package com.kharitonov.gym.service.security;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CipherServiceTest {
    private final CipherService cipher = new CipherService();

    @Test
    public void testWebCipher() {
        String sourceText = "qwerty";
        byte[] encryptedBytes = cipher.encryptMessage(sourceText.getBytes());
        byte[] decryptedBytes = cipher.decryptMessage(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        assertEquals(sourceText, decryptedText);
    }
}