package com.dauphine.job_portal_backend.controllers;

import com.dauphine.job_portal_backend.model.ApplicationSkill;
import com.dauphine.job_portal_backend.service.ApplicationSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/application-skills")
public class ApplicationSkillController {

    private final ApplicationSkillService service;

    @Autowired
    public ApplicationSkillController(ApplicationSkillService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApplicationSkill> addSkillToApplication(@RequestParam UUID applicationId,
                                                                   @RequestParam UUID skillId) {
        ApplicationSkill created = service.addSkillToApplication(applicationId, skillId);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<ApplicationSkill>> getSkillsByApplication(@PathVariable UUID applicationId) {
        return ResponseEntity.ok(service.getSkillsByApplicationId(applicationId));
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<ApplicationSkill>> getApplicationsBySkill(@PathVariable UUID skillId) {
        return ResponseEntity.ok(service.getApplicationsBySkillId(skillId));
    }

    @DeleteMapping
    public ResponseEntity<Void> removeSkillFromApplication(@RequestParam UUID applicationId,
                                                           @RequestParam UUID skillId) {
        service.removeSkillFromApplication(applicationId, skillId);
        return ResponseEntity.noContent().build();
    }
}
