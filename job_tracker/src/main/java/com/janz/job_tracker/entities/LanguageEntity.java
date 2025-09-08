package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LANGUAGES")
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
}
