package com.dauphine.job_portal_backend.controllers;

import com.dauphine.job_portal_backend.model.Application;
import com.dauphine.job_portal_backend.model.User;
import com.dauphine.job_portal_backend.model.Job;
import com.dauphine.job_portal_backend.service.ApplicationService;
import com.dauphine.job_portal_backend.service.UserService;
import com.dauphine.job_portal_backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final UserService userService;
    private final JobService jobService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, UserService userService, JobService jobService) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Map<String, Object> applicationData) {
        try {
            System.out.println("Données reçues: " + applicationData);

            Application application = new Application();

            // Récupérer et assigner l'utilisateur
            if (applicationData.get("user") != null) {
                Map<String, Object> userData = (Map<String, Object>) applicationData.get("user");
                UUID userId = UUID.fromString((String) userData.get("id"));
                User user = userService.getUserById(userId);
                application.setUser(user);
            }

            // Récupérer et assigner le job
            if (applicationData.get("job") != null) {
                Map<String, Object> jobData = (Map<String, Object>) applicationData.get("job");
                UUID jobId = UUID.fromString((String) jobData.get("id"));
                Job job = jobService.getJobById(jobId);
                application.setJob(job);
            }

            // Assigner les informations personnelles
            application.setFirstName((String) applicationData.get("firstName"));
            application.setLastName((String) applicationData.get("lastName"));
            application.setEmail((String) applicationData.get("email"));
            application.setPhone((String) applicationData.get("phone"));

            // Assigner les compétences et expériences (déjà en format JSON)
            application.setSkills((String) applicationData.get("skills"));
            application.setWorkExperiences((String) applicationData.get("workExperiences"));

            Application created = applicationService.create(application);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de la candidature: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable UUID id) {
        return applicationService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable UUID id) {
        applicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUserId(@PathVariable UUID userId) {
        return applicationService.getApplicationsByUserId(userId);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJobId(@PathVariable UUID jobId) {
        List<Application> applications = applicationService.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(applications);
    }
}