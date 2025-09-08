package com.janz.job_tracker.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EXPERIENCES")
public class ExperienceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String institution;
    @Column(name = "start_date")
    public LocalDate start;
    @Column(nullable = true, name = "end_date")
    public LocalDate end;
    public List<String> achievements;
    public Boolean remote;
    @ManyToOne(fetch = FetchType.LAZY)
    public CityEntity city;
    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity user;
}
