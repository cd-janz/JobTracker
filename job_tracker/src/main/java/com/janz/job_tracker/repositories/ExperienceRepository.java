package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.ExperienceEntity;
import com.janz.job_tracker.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExperienceRepository extends CrudRepository<ExperienceEntity, Long> {
    List<ExperienceEntity> findAllByUser(UserEntity user);
}
