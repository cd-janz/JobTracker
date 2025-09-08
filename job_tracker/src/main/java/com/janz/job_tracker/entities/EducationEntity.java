package com.janz.job_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EDUCATIONS")
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String institution;
    @Column(name = "start_date")
    public LocalDate start;
    @Column(name = "end_date")
    public LocalDate end;
    @Column(nullable = true)
    public List<String> achievements;
    public Boolean remote;
    @ManyToOne(fetch = FetchType.LAZY)
    public EducationStatusEntity status;
    @ManyToOne(fetch = FetchType.LAZY)
    public EducationTypeEntity type;
    @ManyToOne(fetch = FetchType.LAZY)
    public CityEntity city;
    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity user;
}