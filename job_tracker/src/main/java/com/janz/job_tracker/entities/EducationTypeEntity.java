package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EDUCATION_TYPES")
public class EducationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
    @Column(nullable = true)
    public String description;
}
