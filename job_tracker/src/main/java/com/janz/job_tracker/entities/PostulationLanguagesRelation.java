package com.janz.job_tracker.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "POSTULATION_LANGUAGES")
public class PostulationLanguagesRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    public PostulationEntity postulation;
    @ManyToOne(fetch = FetchType.LAZY)
    public LanguageEntity language;
}
