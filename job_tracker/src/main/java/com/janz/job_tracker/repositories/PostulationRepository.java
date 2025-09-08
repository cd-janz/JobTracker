package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.PostulationEntity;
import com.janz.job_tracker.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostulationRepository extends CrudRepository<PostulationEntity, UUID> {
    List<PostulationEntity> findAllByUser(UserEntity user);
}
