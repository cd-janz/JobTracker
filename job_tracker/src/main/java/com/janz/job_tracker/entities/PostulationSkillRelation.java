package com.janz.job_tracker.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.UUID;

@Entity
@Table(name = "POSTULATION_SKILLS")
public class PostulationSkillRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    public PostulationEntity postulation;
    @ManyToOne(fetch = FetchType.LAZY)
    public SkillEntity skill;
    @Min(0)
    @Max(50)
    public Integer requiredExperienceYears;
}
