package com.embarkx.jobapp.service;

import com.embarkx.jobapp.model.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job findJobById(Long id);
}
