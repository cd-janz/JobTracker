package com.janz.job_tracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.UUID;

@Entity
@Table(name = "USER_SKILLS")
public class UserSkillRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Min(0)
    @Max(600)
    public Integer experienceMonths;
    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    public SkillEntity skill;
    @ManyToOne(fetch = FetchType.LAZY)
    public ProficiencyEntity proficiency;
}
