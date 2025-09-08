package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CITIES")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    @ManyToOne(fetch = FetchType.LAZY)
    public CountryEntity country;
}
