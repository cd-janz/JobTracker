package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.ExperienceEntity;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<ExperienceEntity, Integer> {
}
