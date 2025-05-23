package com.dauphine.job_portal_backend.service.impl;

import com.dauphine.job_portal_backend.model.ApplicationSkill;
import com.dauphine.job_portal_backend.model.ApplicationSkillId;
import com.dauphine.job_portal_backend.repository.ApplicationSkillRepository;
import com.dauphine.job_portal_backend.service.ApplicationSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationSkillServiceImpl implements ApplicationSkillService {

    private final ApplicationSkillRepository repository;

    @Autowired
    public ApplicationSkillServiceImpl(ApplicationSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public ApplicationSkill addSkillToApplication(UUID applicationId, UUID skillId) {
        ApplicationSkill as = new ApplicationSkill(applicationId, skillId);
        return repository.save(as);
    }

    @Override
    public List<ApplicationSkill> getSkillsByApplicationId(UUID applicationId) {
        return repository.findByApplicationId(applicationId);
    }

    @Override
    public List<ApplicationSkill> getApplicationsBySkillId(UUID skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public void removeSkillFromApplication(UUID applicationId, UUID skillId) {
        repository.deleteById(new ApplicationSkillId(applicationId, skillId));
    }
}
