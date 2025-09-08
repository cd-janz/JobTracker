package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPANIES")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(length = 256, nullable = false)
    public String businessName;
    @Column(length = 256, nullable = true)
    public String email;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    public CountryEntity country;
}
