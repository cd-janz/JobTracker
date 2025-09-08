package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.LanguageEntity;
import com.janz.job_tracker.entities.LanguageProficiencyRelation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageProficiencyRepository extends CrudRepository<LanguageProficiencyRelation, Long> {
    List<LanguageProficiencyRelation> findAllByLanguage(LanguageEntity language);
}
