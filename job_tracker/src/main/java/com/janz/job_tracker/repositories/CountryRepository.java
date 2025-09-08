package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {
    CountryEntity findByName(String name);
    CountryEntity findByCode(Integer code);
}
