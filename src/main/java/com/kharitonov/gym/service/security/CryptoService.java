package com.kharitonov.gym.service.security;

import java.util.Base64;

public class CryptoService {
    private static final int OFFSET = 4;

    public String encryptMessage(String text) {
        String b64encoded =
                Base64.getEncoder().encodeToString(text.getBytes());
        String reverse = new StringBuffer(b64encoded).reverse().toString();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < reverse.length(); i++) {
            tmp.append((char) (reverse.charAt(i) + OFFSET));
        }
        return tmp.toString();
    }

    public String decryptMessage(String text) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            tmp.append((char) (text.charAt(i) - OFFSET));
        }
        String reversed = new StringBuffer(tmp.toString()).reverse().toString();
        return new String(Base64.getDecoder().decode(reversed));
    }
}
