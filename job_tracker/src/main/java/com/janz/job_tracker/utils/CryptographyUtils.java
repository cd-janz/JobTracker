package com.janz.job_tracker.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class CryptographyUtils {

    private final static BCryptPasswordEncoder _passwordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return _passwordEncoder.encode(password);
    }

    public static Boolean checkPassword(String password, String hashedPassword) {
        return _passwordEncoder.matches(password, hashedPassword);
    }
}
