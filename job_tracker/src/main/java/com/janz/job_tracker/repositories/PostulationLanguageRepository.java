package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.PostulationEntity;
import com.janz.job_tracker.entities.PostulationLanguagesRelation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostulationLanguageRepository extends CrudRepository<PostulationLanguagesRelation, UUID> {
    List<PostulationLanguagesRelation> findAllByPostulation(PostulationEntity postulation);
}
