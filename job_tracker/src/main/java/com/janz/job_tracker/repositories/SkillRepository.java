package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.SkillCategoryEntity;
import com.janz.job_tracker.entities.SkillEntity;
import com.janz.job_tracker.entities.SkillTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<SkillEntity, Long> {
    List<SkillEntity> findAllByCategory(SkillCategoryEntity category);
    List<SkillEntity> findAllByType(SkillTypeEntity type);
}
