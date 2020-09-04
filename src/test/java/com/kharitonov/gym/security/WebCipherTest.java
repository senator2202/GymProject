package com.kharitonov.gym.security;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebCipherTest {
    private final WebCipher cipher = new WebCipher();

    @Test
    public void testWebCipher() {
        String sourceText = "qwerty";
        byte[] encryptedBytes = cipher.encryptMessage(sourceText.getBytes());
        byte[] decryptedBytes = cipher.decryptMessage(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        assertEquals(sourceText, decryptedText);
    }
}