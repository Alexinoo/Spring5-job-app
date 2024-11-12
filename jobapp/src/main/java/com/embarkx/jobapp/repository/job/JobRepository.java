package com.embarkx.jobapp.repository.job;

import com.embarkx.jobapp.model.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
