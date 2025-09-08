package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.CityEntity;
import com.janz.job_tracker.entities.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Integer> {
    CityEntity findAllByCountry(CountryEntity country);
    CityEntity findByName(String name);
}
