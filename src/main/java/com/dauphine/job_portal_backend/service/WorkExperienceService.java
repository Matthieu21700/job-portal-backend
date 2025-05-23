package com.dauphine.job_portal_backend.service;

import com.dauphine.job_portal_backend.model.WorkExperience;

import java.util.List;
import java.util.UUID;

public interface WorkExperienceService {
    WorkExperience create(WorkExperience workExperience);
    List<WorkExperience> getAll();
    List<WorkExperience> getByApplicationId(UUID applicationId);
    WorkExperience getById(UUID id);
    void delete(UUID id);
    WorkExperience update(UUID id, WorkExperience workExperience);
}
