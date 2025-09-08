package com.janz.job_tracker.models.dto.response;

import com.janz.job_tracker.entities.CountryEntity;
import reactor.util.annotation.Nullable;

import java.util.Optional;

public class BasicUserResponseDTO {
    public Integer id;
    public String firstName;
    @Nullable()
    public String middleName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public CountryEntity country;
}
