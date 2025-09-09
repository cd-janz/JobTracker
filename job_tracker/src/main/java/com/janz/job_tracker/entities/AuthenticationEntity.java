package com.janz.job_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "AUTHENTICATIONS")
public class AuthenticationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(nullable = false, updatable = false)
    public String code;
    @Column(updatable = false)
    public LocalDateTime createdAt = LocalDateTime.now();
    @Column(updatable = false)
    public LocalDateTime validUntil = LocalDateTime.now().plusMinutes(20);
    public Boolean isUsed = false;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(updatable = false)
    public UserEntity user;
}
