package com.dauphine.job_portal_backend.service.impl;

import java.util.List;
import java.util.UUID;



import org.springframework.stereotype.Service;

import com.dauphine.job_portal_backend.dto.JobRequestDto;
import com.dauphine.job_portal_backend.model.Job;
import com.dauphine.job_portal_backend.repository.JobRepository;
import com.dauphine.job_portal_backend.repository.UserRepository;
import com.dauphine.job_portal_backend.service.JobService;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional; 
import com.dauphine.job_portal_backend.model.User;


@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    public JobServiceImpl(JobRepository jobRepository,UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository=userRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(UUID id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job createJob(Job job) {
        // Récupérer l'utilisateur lié au job
        UUID userId = job.getUser().getId(); // Attention : ici tu pars du principe que le user est déjà partiellement instancié

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Utilisateur avec l'ID " + userId + " introuvable");
        }

        return jobRepository.save(job);
    }


    @Override
    public Job updateJob(UUID id, Job updatedJob) {
        return jobRepository.findById(id)
            .map(job -> {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setResponsibilities(updatedJob.getResponsibilities());
                job.setQualifications(updatedJob.getQualifications());
                job.setLocation(updatedJob.getLocation());
                job.setSalaryMin(updatedJob.getSalaryMin());
                job.setSalaryMax(updatedJob.getSalaryMax());
                job.setType(updatedJob.getType());
                job.setExperienceLevel(updatedJob.getExperienceLevel());
                return jobRepository.save(job);
            }).orElse(null);
    }

    @Override
    public boolean deleteJob(UUID id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Job> searchJobs(String location, String type, String experienceLevel) {
        List<Job> jobs = jobRepository.findAll();

        if (location != null && !location.isBlank()) {
            jobs = jobs.stream()
                    .filter(job -> location.equalsIgnoreCase(job.getLocation()))
                    .toList();
        }

        if (type != null && !type.isBlank()) {
            jobs = jobs.stream()
                    .filter(job -> type.equalsIgnoreCase(job.getType()))
                    .toList();
        }

        if (experienceLevel != null && !experienceLevel.isBlank()) {
            jobs = jobs.stream()
                    .filter(job -> experienceLevel.equalsIgnoreCase(job.getExperienceLevel()))
                    .toList();
        }

        return jobs;
    }

}
