package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.SkillCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface SkillCategoryRepository extends CrudRepository<SkillCategoryEntity, Integer> {
}
