package com.embarkx.jobapp.repository;

import com.embarkx.jobapp.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
