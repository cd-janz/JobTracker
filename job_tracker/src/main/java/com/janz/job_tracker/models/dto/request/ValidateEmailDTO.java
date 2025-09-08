package com.janz.job_tracker.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ValidateEmailDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Email address contains invalid characters")
    public String email;
}
