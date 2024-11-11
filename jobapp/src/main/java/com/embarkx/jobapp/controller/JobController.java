package com.embarkx.jobapp.controller;

import com.embarkx.jobapp.model.Job;
import com.embarkx.jobapp.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String addJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job foundJob = jobService.findJobById(id);

        if (foundJob != null)
             return foundJob;
        return new Job(10L,"No Job","No Desc","No minSal",
                "No maxSal","No Loc");
    }
}
