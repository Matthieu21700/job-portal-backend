package com.dauphine.job_portal_backend.service;

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
    
    // Méthode pour chercher avec filtres (exemple simple)
    List<Job> searchJobs(String location, String type, String experienceLevel);
}
