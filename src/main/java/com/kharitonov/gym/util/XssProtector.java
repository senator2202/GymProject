package com.kharitonov.gym.util;

/**
 * The type Xss protector.
 */
public class XssProtector {
    private static final String EMPTY = "";
    private static final String SCRIPT_REGEX = "</?script>";

    /**
     * Protect string from script injections.
     *
     * @param line the line
     * @return the string
     */
    public static String protect(String line) {
        String securedLine = line;
        if (line != null) {
            securedLine = line.replaceAll(SCRIPT_REGEX, EMPTY);
        }
        return securedLine;
    }
}
