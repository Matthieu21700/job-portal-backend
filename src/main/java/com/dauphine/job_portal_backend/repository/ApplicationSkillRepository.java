package com.dauphine.job_portal_backend.repository;


import com.dauphine.job_portal_backend.model.ApplicationSkill;
import com.dauphine.job_portal_backend.model.ApplicationSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationSkillRepository extends JpaRepository<ApplicationSkill, ApplicationSkillId> {
    List<ApplicationSkill> findByApplicationId(UUID applicationId);
    List<ApplicationSkill> findBySkillId(UUID skillId);
}

