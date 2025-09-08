package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.ProficiencyEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProficiencyRepository extends CrudRepository<ProficiencyEntity, Integer> {
}
