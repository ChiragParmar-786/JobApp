package com.example.JobApp.Job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImp implements JobService{

    private List<Job> jobs = new ArrayList<>();

    private int counter = 0;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {

        job.setId(++counter);
        jobs.add(job);

    }

    @Override
    public Job findJobById(Long id) {
        for(Job job : jobs)
        {
            if(job.getId()==id)
               return job;
        }

        return null;
    }

    @Override
    public Boolean removeJobById(Long id) {
        for(Job job : jobs)
        {
            if(job.getId()==id)
            {
                jobs.remove(job);
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean updateJobById(Long id, Job job) {
        for(Job j : jobs)
        {
            if(j.getId()==id)
            {
                j.setDescription(job.getDescription());
                j.setTitle(job.getTitle());
                j.setMinSalary(job.getMinSalary());
                j.setMaxSalary(job.getMaxSalary());
                j.setLocation(job.getLocation());
                return true;
            }
        }

        return false;
    }
}
