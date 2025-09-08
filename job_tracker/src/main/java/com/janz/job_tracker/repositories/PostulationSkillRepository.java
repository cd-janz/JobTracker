package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.PostulationEntity;
import com.janz.job_tracker.entities.PostulationSkillRelation;
import com.janz.job_tracker.entities.SkillEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostulationSkillRepository extends CrudRepository<PostulationSkillRelation, UUID> {
    List<PostulationSkillRelation> findAllByPostulation(PostulationEntity postulation);
    List<PostulationSkillRelation> findAllBySkill(SkillEntity skill);
}
