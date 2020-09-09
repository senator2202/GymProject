package com.kharitonov.gym.service.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CipherService {
    private static final Logger LOGGER = LogManager.getLogger(CipherService.class);
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY_BYTES =
            new byte[]{-75, 30, 47, -15, -2, -68, 9, 115, -49, -117, 85, -15,
                    80, -59, -87, -76};

    public byte[] encryptMessage(byte[] bytes) {
        int mode = Cipher.ENCRYPT_MODE;
        return encryptAlgorithm(bytes, mode);
    }

    public byte[] decryptMessage(byte[] bytes) {
        int mode = Cipher.DECRYPT_MODE;
        return encryptAlgorithm(bytes, mode);
    }

    private byte[] encryptAlgorithm(byte[] sourceBytes, int encryptMode) {
        byte[] finalBytes;
        Cipher cipher = createCipher(encryptMode);
        try {
            finalBytes = cipher.doFinal(sourceBytes);
        } catch (BadPaddingException
                | IllegalBlockSizeException
                | NullPointerException e) {
            LOGGER.error("Impossible to encrypt text!", e);
            finalBytes = null;
        }
        return finalBytes;
    }

    private Cipher createCipher(int encryptMode) {
        SecretKey secretKey = createSecretKey();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(encryptMode, secretKey);
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | InvalidKeyException e) {
            LOGGER.error("Impossible to create Cipher object!", e);
        }
        return cipher;
    }

    private SecretKey createSecretKey() {
        SecretKey secretKey;
        try {
            MessageDigest md;
            byte[] key;
            md = MessageDigest.getInstance("SHA-1");
            key = md.digest(KEY_BYTES);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Impossible to create secret key!", e);
            secretKey = null;
        }
        return secretKey;
    }
}
