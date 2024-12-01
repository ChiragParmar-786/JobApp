package com.example.JobApp.Job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService{


    JobRepository jobRepository;

    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
       jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean removeJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateJobById(Long id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);

            if(optionalJob.isPresent())
            {
                Job jobToUpdate = optionalJob.get();
                jobToUpdate.setDescription(job.getDescription());
                jobToUpdate.setTitle(job.getTitle());
                jobToUpdate.setMinSalary(job.getMinSalary());
                jobToUpdate.setMaxSalary(job.getMaxSalary());
                jobToUpdate.setLocation(job.getLocation());
                jobRepository.save(jobToUpdate);
                return true;
            }
        return false;
    }
}
