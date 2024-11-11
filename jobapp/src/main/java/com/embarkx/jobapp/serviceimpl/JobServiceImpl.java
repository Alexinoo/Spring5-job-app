package com.embarkx.jobapp.serviceimpl;

import com.embarkx.jobapp.model.Job;
import com.embarkx.jobapp.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {
    private Long id = 1L;

    private List<Job> jobs  = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job newJob) {
        newJob.setId(id++);
        jobs.add(newJob);
    }

    @Override
    public Job findJobById(Long id) {
        for (Job job : jobs){
            if (id.equals(job.getId()))
                return job;
        }
        return null;
    }


}
