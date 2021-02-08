package com.github.ozzymar.talismansmega.utils.string;

import java.security.SecureRandom;
import java.util.Random;

public class UUIDUtils {

    private final Random rng = new SecureRandom();

    private char randomChar() {
        String POSSIBLE_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/*-+.=+_()[]{}&^%$£!|<>,?";
        return POSSIBLE_CHARS.charAt(rng.nextInt(POSSIBLE_CHARS.length()));
    }

    public String randomUUID(int length) {
        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            if (spacer == 4) {
                sb.append('-');
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }
}
