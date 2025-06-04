package com.dauphine.job_portal_backend.controllers;

import com.dauphine.job_portal_backend.model.Job;
import com.dauphine.job_portal_backend.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return ResponseEntity.ok(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job created = jobService.createJob(job);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable UUID id, @RequestBody Job job) {
        Job updated = jobService.updateJob(id, job);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable UUID id) {
        if (jobService.deleteJob(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam(required = false) String titre,
                                @RequestParam(required = false) String location,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String companyName,
                                @RequestParam(required = false) String description,
                                @RequestParam(required = false) String experienceLevel,
                                @RequestParam(required = false) BigDecimal salaryMin,
                                @RequestParam(required = false) BigDecimal salaryMax) {
        return jobService.searchJobs(titre,location, type, experienceLevel, companyName, description,salaryMin,salaryMax);
    }

    @GetMapping("/user/{userId}")
    public List<Job> getJobsByUserId(@PathVariable UUID userId) {
        return jobService.getJobsByUserId(userId);
    }

    @GetMapping("/{jobId}/can-edit/{userId}")
    public ResponseEntity<Boolean> canUserEditJob(@PathVariable UUID jobId, @PathVariable UUID userId) {
        Job job = jobService.getJobById(jobId);
        if (job != null && job.getUser() != null && job.getUser().getId().equals(userId)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }
    @GetMapping("/search/{userId}")
    public List<Job> searchJobsByUserId(@PathVariable UUID userId,
                                @RequestParam(required = false) String titre,
                                @RequestParam(required = false) String location,
                                @RequestParam(required = false) String type,
                                @RequestParam(required = false) String companyName,
                                @RequestParam(required = false) String description,
                                @RequestParam(required = false) String experienceLevel,
                                @RequestParam(required = false) BigDecimal salaryMin,
                                @RequestParam(required = false) BigDecimal salaryMax) {
        return jobService.searchJobsByUserId(userId,titre,location, type, experienceLevel, companyName, description,salaryMin,salaryMax);
    }
}