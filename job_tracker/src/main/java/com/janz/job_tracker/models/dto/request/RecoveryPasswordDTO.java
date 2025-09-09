package com.janz.job_tracker.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RecoveryPasswordDTO {
    @Email(message = "invalid email provided")
    @NotBlank(message = "email ain't optional")
    public String email;
}
