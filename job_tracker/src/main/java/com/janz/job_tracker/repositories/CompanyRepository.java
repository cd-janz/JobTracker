package com.janz.job_tracker.repositories;

import com.janz.job_tracker.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
    CompanyEntity findByBusinessName(String name);
    CompanyEntity findByEmail(String email);
}
