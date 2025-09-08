package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LANGUAGES_PROFICIENCY")
public class LanguageProficiencyRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    public LanguageEntity language;
    @ManyToOne(fetch = FetchType.LAZY)
    public ProficiencyEntity proficiency;
}
