package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILL_TYPES")
public class SkillTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    public String name;
}
