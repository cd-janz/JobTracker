package com.janz.job_tracker.models.dto.response;

import jakarta.validation.constraints.NotNull;

public class LoginResponseDTO {
    @NotNull()
    public String token;
    public BasicUserResponseDTO user;
}
