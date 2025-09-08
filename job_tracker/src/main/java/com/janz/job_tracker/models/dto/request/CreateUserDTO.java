package com.janz.job_tracker.models.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserDTO {
    @NotBlank(message = "first name ain't optional")
    @Size(max = 128, message = "first name must have a max length of 128 characters")
    public String firstName;
    @Nullable()
    @Size(min = 0, max = 128, message = "middle name must have a max length of 128 characters")
    public String middleName;
    @NotBlank(message = "last name ain't optional,")
    @Size(max = 128, message = "last name must have a max length of 128 characters")
    public String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email provided")
    public String email;
    @NotBlank(message = "You must provide a password")
    public String password;
}
