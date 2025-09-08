package com.janz.job_tracker.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTRIES")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(unique = true)
    public String name;
    @Column(unique = true)
    public Integer code;
}
