package com.janz.job_tracker.use_cases;

import com.janz.job_tracker.entities.UserEntity;
import com.janz.job_tracker.mappers.UserMapper;
import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.request.RequestLoginDTO;
import reactor.core.publisher.Mono;

public interface UserUseCases {
    Mono<UserEntity> validateUserCredentials(RequestLoginDTO user);
    Mono<Void> createUser(CreateUserDTO user, UserMapper userMapper);
}
