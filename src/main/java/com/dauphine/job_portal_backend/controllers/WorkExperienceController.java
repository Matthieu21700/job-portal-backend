package com.dauphine.job_portal_backend.controllers;

import com.dauphine.job_portal_backend.model.WorkExperience;
import com.dauphine.job_portal_backend.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/work-experiences")
public class WorkExperienceController {

    private final WorkExperienceService service;

    @Autowired
    public WorkExperienceController(WorkExperienceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WorkExperience> create(@RequestBody WorkExperience workExperience) {
        return ResponseEntity.ok(service.create(workExperience));
    }

    @GetMapping
    public ResponseEntity<List<WorkExperience>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkExperience> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<WorkExperience>> getByApplicationId(@PathVariable UUID applicationId) {
        return ResponseEntity.ok(service.getByApplicationId(applicationId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkExperience> update(@PathVariable UUID id,
                                                 @RequestBody WorkExperience workExperience) {
        return ResponseEntity.ok(service.update(id, workExperience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
