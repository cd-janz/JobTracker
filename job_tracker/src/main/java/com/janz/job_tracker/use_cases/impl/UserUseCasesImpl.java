package com.janz.job_tracker.use_cases.impl;

import com.janz.job_tracker.configurations.JwtSupport;
import com.janz.job_tracker.entities.UserEntity;
import com.janz.job_tracker.mappers.UserMapper;
import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.request.RequestLoginDTO;
import com.janz.job_tracker.repositories.CountryRepository;
import com.janz.job_tracker.repositories.UserRepository;
import com.janz.job_tracker.use_cases.UserUseCases;
import com.janz.job_tracker.utils.CryptographyUtils;
import lombok.AllArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@SuppressWarnings("BlockingMethodInNonBlockingContext")
@Service
@AllArgsConstructor
public class UserUseCasesImpl implements UserUseCases {

    private final UserRepository _userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserUseCasesImpl.class);

    @Override
    public Mono<UserEntity> validateUserCredentials(RequestLoginDTO user) {
        return Mono.fromCallable(()-> _userRepository.findByEmail(user.email))
                .doOnNext(res -> {
                    if(!CryptographyUtils.checkPassword(user.password, res.password))
                        throw new RuntimeException("Wrong password");
                })
                .flatMap(Mono::just)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Email not found!")));
    }

    @Override
    public Mono<Void> createUser(CreateUserDTO user, UserMapper userMapper) {
        return this.validateEmailAble(user.email)
                .then(Mono.fromCallable(() -> {
                    UserEntity userEntity = userMapper.registerDTOToEntity(user);
                    userEntity.setPassword(CryptographyUtils.encodePassword(user.password));
                    return _userRepository.save(userEntity);
                }))
                .then();
    }

    @Override
    public Mono<Void> sendVerificationCode(String email) {
        logger.info("Sending verification code for email {}", email);
        //TODO: Implement that
        return null;
    }

    private Mono<Void> validateEmailAble(String email) {
        return Mono.fromCallable(()-> _userRepository.findByEmail(email))
                .flatMap(userEntity -> Mono.error(new IllegalArgumentException("Email already in use!")));
    }
}
