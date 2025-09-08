package com.janz.job_tracker.entities;

import jakarta.persistence.*;

//Skill Level
@Entity
@Table(name = "PROFICIENCIES")
public class ProficiencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
    @Column(nullable = true)
    public String description;
}
