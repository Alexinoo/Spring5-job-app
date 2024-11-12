package com.embarkx.jobapp.service.job;

import com.embarkx.jobapp.model.job.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job findJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Job updateJob ,Long id);
}
