package com.janz.job_tracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "POSTULATIONS")
public class PostulationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String title;
    public String position;
    @Min(0)
    public Integer requiredExperienceYears;
    public String jobObligations;
    @Column(nullable = true)
    public String description;
    @Column(nullable = true)
    public String latexCV;
    @Column(nullable = true)
    public String localCVPath;
    public LocalDate createdAt;
    public LocalDate updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    public CompanyEntity company;
    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity user;
}
