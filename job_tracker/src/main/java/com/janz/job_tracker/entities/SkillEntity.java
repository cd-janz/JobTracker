package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILLS")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    public String name;
    @ManyToOne(fetch = FetchType.LAZY)
    public SkillTypeEntity type;
    @ManyToOne(fetch = FetchType.LAZY)
    public SkillCategoryEntity category;
}
