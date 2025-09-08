package com.janz.job_tracker.mappers;

import com.janz.job_tracker.entities.UserEntity;
import com.janz.job_tracker.models.dto.request.CreateUserDTO;
import com.janz.job_tracker.models.dto.response.BasicUserResponseDTO;
import com.janz.job_tracker.models.dto.response.LoginResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public BasicUserResponseDTO entityToBasicDTO(UserEntity user){
        BasicUserResponseDTO basicUserResponseDTO = new BasicUserResponseDTO();
        basicUserResponseDTO.id = user.id;
        basicUserResponseDTO.firstName = user.firstName;
        basicUserResponseDTO.middleName = user.middleName;
        basicUserResponseDTO.lastName = user.lastName;
        basicUserResponseDTO.email = user.email;
        basicUserResponseDTO.phoneNumber = user.phoneNumber;
        basicUserResponseDTO.country = user.country;
        return basicUserResponseDTO;
    }
    public LoginResponseDTO entityToLoginDTO(UserEntity user, String token){
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.user = this.entityToBasicDTO(user);
        loginResponseDTO.token = token;
        return loginResponseDTO;
    }
    public UserEntity registerDTOToEntity(CreateUserDTO user){
        UserEntity userEntity = new UserEntity();
        userEntity.firstName = user.firstName;
        userEntity.middleName = user.middleName;
        userEntity.lastName = user.lastName;
        userEntity.email = user.email;
        return userEntity;
    }
}
