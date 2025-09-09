package com.janz.job_tracker.controllers;

import com.janz.job_tracker.models.ApiResponse;
import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.request.RecoveryPasswordDTO;
import com.janz.job_tracker.models.dto.request.RequestLoginDTO;
import com.janz.job_tracker.models.dto.response.LoginResponseDTO;
import com.janz.job_tracker.services.UserServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/public")
@AllArgsConstructor
public class PublicController {

    private final UserServices _userServices;

    @GetMapping("hello")
    public Mono<ApiResponse<Void>> hello_world(){
        return Mono.just(new ApiResponse.Builder<Void>().message("Hello world!").build());
    }

    @PostMapping("login")
    public Mono<ApiResponse<LoginResponseDTO>> login(@Valid @RequestBody RequestLoginDTO user){
        return _userServices.login(user)
                .map(response -> new ApiResponse.Builder<LoginResponseDTO>()
                        .message("logged successfully")
                        .data(response)
                        .build());
    }

    @PostMapping("register")
    public Mono<ApiResponse<Void>> register(@Valid @RequestBody CreateUserDTO user){
        return _userServices.registerUser(user)
                .then(Mono.fromCallable(() -> new ApiResponse.Builder<Void>()
                        .message("User registered successfully").build()));
    }

    @PostMapping("recovery")
    public Mono<ApiResponse<Void>> recovery(@Valid @RequestBody RecoveryPasswordDTO user){
        return _userServices.recoveryPassword(user.email)
                .then(Mono.fromCallable(() -> new ApiResponse.Builder<Void>()
                        .message("Recovery code sent successfully").build()));
    }

}
