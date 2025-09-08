package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.EducationEntity;
import com.janz.job_tracker.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationRepository extends CrudRepository<EducationEntity, Long> {
    List<EducationEntity> findAllByUser(UserEntity user);
}
