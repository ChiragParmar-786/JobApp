package com.example.JobApp.Job;

import com.example.JobApp.Company.CompanyRepository;
import com.example.JobApp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService{


    JobRepository jobRepository;

    CompanyService companyService;

    public JobServiceImp(JobRepository jobRepository,CompanyService companyService) {
        this.jobRepository = jobRepository;
        this.companyService = companyService;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Boolean createJob(Job job) {
        if(companyService.findCompanyById(job.getId()) != null){
            jobRepository.save(job);
            return true;
        }
       else {
            return false;
        }
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean removeJobById(Long id) {
       if(jobRepository.existsById(id)){
           jobRepository.deleteById(id);
           return true;
       }
       else{
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
