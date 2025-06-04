package com.dauphine.job_portal_backend.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.dauphine.job_portal_backend.model.Job;
import com.dauphine.job_portal_backend.repository.JobRepository;
import com.dauphine.job_portal_backend.repository.UserRepository;
import com.dauphine.job_portal_backend.service.JobService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return jobRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public Job getJobById(UUID id) {
        return jobRepository.findById(id).orElse(null);
    }
    @Override
    public List<Job> getJobsByUserId(UUID userId) {
        List<Job> jobs = jobRepository.findByUserId(userId);
        return jobs.stream()
                .sorted((job1, job2) -> job2.getCreatedAt().compareTo(job1.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public Job createJob(Job job) {
        UUID userId = job.getUser().getId();
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
                job.setCompanyName(updatedJob.getCompanyName());
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
    public List<Job> searchJobs(String titre,String location, String type, String experienceLevel,
                                String companyName, String description, BigDecimal salaryMin, BigDecimal salaryMax) {
        List<Job> jobs = jobRepository.findAll();

        if (titre != null && !titre.isBlank()) {
            String titleLower = titre.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getTitle() != null &&
                            job.getTitle().toLowerCase().contains(titleLower))
                    .toList();
        }

        if (location != null && !location.isBlank()) {
            String locLower = location.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getLocation() != null &&
                            job.getLocation().toLowerCase().contains(locLower))
                    .toList();
        }

        if (type != null && !type.isBlank()) {
            String typeLower = type.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getType() != null &&
                            job.getType().toLowerCase().contains(typeLower))
                    .toList();
        }

        if (experienceLevel != null && !experienceLevel.isBlank()) {
            String levelLower = experienceLevel.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getExperienceLevel() != null &&
                            job.getExperienceLevel().toLowerCase().contains(levelLower))
                    .toList();
        }

        if (companyName != null && !companyName.isBlank()) {
            String companyLower = companyName.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getCompanyName() != null &&
                            job.getCompanyName().toLowerCase().contains(companyLower))
                    .toList();
        }

        if (description != null && !description.isBlank()) {
            String descLower = description.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getDescription() != null &&
                            job.getDescription().toLowerCase().contains(descLower))
                    .toList();
        }

        if (salaryMin != null) {
            jobs = jobs.stream()
                    .filter(job -> job.getSalaryMin() != null &&
                            job.getSalaryMin().compareTo(salaryMin) >= 0)
                    .toList();
        }

        if (salaryMax != null) {
            jobs = jobs.stream()
                    .filter(job -> job.getSalaryMax() != null &&
                            job.getSalaryMax().compareTo(salaryMax) <= 0)
                    .toList();
        }

        return jobs;
    }
    @Override
    public List<Job> searchJobsByUserId(UUID id,String titre,String location, String type, String experienceLevel,
                                String companyName, String description, BigDecimal salaryMin, BigDecimal salaryMax) {
        List<Job> jobs = jobRepository.findByUserId(id);

        if (titre != null && !titre.isBlank()) {
            String titleLower = titre.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getTitle() != null &&
                            job.getTitle().toLowerCase().contains(titleLower))
                    .toList();
        }

        if (location != null && !location.isBlank()) {
            String locLower = location.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getLocation() != null &&
                            job.getLocation().toLowerCase().contains(locLower))
                    .toList();
        }

        if (type != null && !type.isBlank()) {
            String typeLower = type.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getType() != null &&
                            job.getType().toLowerCase().contains(typeLower))
                    .toList();
        }

        if (experienceLevel != null && !experienceLevel.isBlank()) {
            String levelLower = experienceLevel.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getExperienceLevel() != null &&
                            job.getExperienceLevel().toLowerCase().contains(levelLower))
                    .toList();
        }

        if (companyName != null && !companyName.isBlank()) {
            String companyLower = companyName.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getCompanyName() != null &&
                            job.getCompanyName().toLowerCase().contains(companyLower))
                    .toList();
        }

        if (description != null && !description.isBlank()) {
            String descLower = description.toLowerCase();
            jobs = jobs.stream()
                    .filter(job -> job.getDescription() != null &&
                            job.getDescription().toLowerCase().contains(descLower))
                    .toList();
        }

        if (salaryMin != null) {
            jobs = jobs.stream()
                    .filter(job -> job.getSalaryMin() != null &&
                            job.getSalaryMin().compareTo(salaryMin) >= 0)
                    .toList();
        }

        if (salaryMax != null) {
            jobs = jobs.stream()
                    .filter(job -> job.getSalaryMax() != null &&
                            job.getSalaryMax().compareTo(salaryMax) <= 0)
                    .toList();
        }

        return jobs;
    }
}
