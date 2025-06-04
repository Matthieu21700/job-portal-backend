package com.dauphine.job_portal_backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.dauphine.job_portal_backend.dto.JobRequestDto;
import com.dauphine.job_portal_backend.model.Job;

public interface JobService {
	List<Job> getAllJobs();
    Job getJobById(UUID id);
    Job createJob(Job job);
    Job updateJob(UUID id, Job job);
    boolean deleteJob(UUID id);
    List<Job> getJobsByUserId(UUID userId);
    List<Job> searchJobs(String titre,String location, String type, String experienceLevel,
            String companyName, String description,BigDecimal salaryMin, BigDecimal salaryMax);
    public List<Job> searchJobsByUserId(UUID id,String titre,String location, String type, String experienceLevel,
                                        String companyName, String description, BigDecimal salaryMin, BigDecimal salaryMax);
}
