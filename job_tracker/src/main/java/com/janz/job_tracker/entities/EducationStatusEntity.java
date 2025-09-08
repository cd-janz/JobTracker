package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EDUCATION_STATUS")
public class EducationStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
    @Column(nullable = true)
    public String description;
}
