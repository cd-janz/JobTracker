package com.janz.job_tracker.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequestLoginDTO {
    @NotBlank(message = "email must be provided")
    @Email(message = "invalid email provided")
    public String email;
    @NotBlank(message = "you must write your password")
    @Size(min = 8, max = 16, message = "password length must be between 8 and 16")
    public String password;
}
