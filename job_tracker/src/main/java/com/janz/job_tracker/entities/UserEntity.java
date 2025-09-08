package com.janz.job_tracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(length = 128, nullable = false)
    public String firstName;
    @Column(length = 128, nullable = true)
    public String middleName;
    @Column(length = 128, nullable = false)
    public String lastName;
    @Email(message = "Invalid email")
    @Column(length = 255, unique = true, nullable = false)
    public String email;
    @Column(length = 160)
    public String password;
    @Column(length = 20, nullable = true)
    public String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    public CountryEntity country;
}
