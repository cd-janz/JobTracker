package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILL_CATEGORIES")
public class SkillCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
    @Column(nullable = true)
    public String description;
}
