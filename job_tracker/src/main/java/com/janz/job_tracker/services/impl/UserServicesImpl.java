package com.janz.job_tracker.services.impl;

import com.janz.job_tracker.configurations.JwtSupport;
import com.janz.job_tracker.mappers.UserMapper;
import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.request.RequestLoginDTO;
import com.janz.job_tracker.models.dto.response.BasicUserResponseDTO;
import com.janz.job_tracker.models.dto.response.LoginResponseDTO;
import com.janz.job_tracker.services.UserServices;
import com.janz.job_tracker.use_cases.UserUseCases;
import com.janz.job_tracker.utils.CryptographyUtils;
import com.janz.job_tracker.utils.ValidationUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserUseCases _userUseCases;
    private final UserMapper _userMapper;
    private final JwtSupport _jwtSupport;

    @Override
    public Mono<LoginResponseDTO> login(RequestLoginDTO user) {
        ValidationUtil.validate_email(user.email);
        return _userUseCases.validateUserCredentials(user)
                .flatMap(userEntity -> Mono.just(_userMapper
                        .entityToLoginDTO(userEntity, _jwtSupport.generateToken(userEntity.id).getValue())));
    }

    @Override
    public Mono<Void> registerUser(CreateUserDTO user) {
        ValidationUtil.validate_email(user.email);
        return _userUseCases.createUser(user, _userMapper);
    }

    @Override
    public Mono<Void> recoveryPassword(String email) {
        ValidationUtil.validate_email(email);
        return _userUseCases.sendVerificationCode(email);
    }

}
