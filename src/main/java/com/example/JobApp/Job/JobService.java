package com.example.JobApp.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job findJobById(Long id);

    Boolean removeJobById(Long id);

    Boolean updateJobById(Long id, Job job);
}
