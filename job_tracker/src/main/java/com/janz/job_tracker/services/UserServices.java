package com.janz.job_tracker.services;

import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.request.RequestLoginDTO;
import com.janz.job_tracker.models.dto.response.LoginResponseDTO;
import reactor.core.publisher.Mono;

public interface UserServices {
    Mono<LoginResponseDTO> login(RequestLoginDTO user);
    Mono<Void> registerUser(CreateUserDTO user);
    Mono<Void> recoveryPassword(String email);
}
