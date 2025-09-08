package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.UserEntity;
import com.janz.job_tracker.entities.UserSkillRelation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserSkillRepository extends CrudRepository<UserSkillRelation, UUID> {
    List<UserSkillRelation> findAllByUser(UserEntity user);
}
