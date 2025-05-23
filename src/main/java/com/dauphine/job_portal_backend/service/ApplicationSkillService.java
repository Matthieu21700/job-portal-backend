package com.dauphine.job_portal_backend.service;

import com.dauphine.job_portal_backend.model.ApplicationSkill;

import java.util.List;
import java.util.UUID;

public interface ApplicationSkillService {
    ApplicationSkill addSkillToApplication(UUID applicationId, UUID skillId);
    List<ApplicationSkill> getSkillsByApplicationId(UUID applicationId);
    List<ApplicationSkill> getApplicationsBySkillId(UUID skillId);
    void removeSkillFromApplication(UUID applicationId, UUID skillId);
}
