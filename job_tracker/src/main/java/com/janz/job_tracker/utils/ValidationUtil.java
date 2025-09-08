package com.janz.job_tracker.utils;

import jakarta.validation.ValidationException;

import java.util.regex.Pattern;

public final class ValidationUtil {

    private final static Pattern _email = Pattern.compile("^[A-Za-z0-9._%+-]+@(gmail|hotmail|outlook)\\.com$",
            Pattern.CASE_INSENSITIVE);

    public static void validate_email(String email){
        if(!_email.matcher(email).matches()) throw new ValidationException("Invalid email address");
    }

}
