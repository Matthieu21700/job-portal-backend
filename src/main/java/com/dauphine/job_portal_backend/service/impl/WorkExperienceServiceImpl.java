package com.dauphine.job_portal_backend.service.impl;

import com.dauphine.job_portal_backend.model.WorkExperience;
import com.dauphine.job_portal_backend.repository.WorkExperienceRepository;
import com.dauphine.job_portal_backend.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    private final WorkExperienceRepository repository;

    @Autowired
    public WorkExperienceServiceImpl(WorkExperienceRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkExperience create(WorkExperience workExperience) {
        workExperience.setId(UUID.randomUUID());
        return repository.save(workExperience);
    }

    @Override
    public List<WorkExperience> getAll() {
        return repository.findAll();
    }

    @Override
    public List<WorkExperience> getByApplicationId(UUID applicationId) {
        return repository.findByApplicationId(applicationId);
    }

    @Override
    public WorkExperience getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public WorkExperience update(UUID id, WorkExperience updated) {
        WorkExperience existing = getById(id);
        if (existing != null) {
            existing.setTitle(updated.getTitle());
            existing.setDescription(updated.getDescription());
            existing.setStartDate(updated.getStartDate());
            existing.setEndDate(updated.getEndDate());
            return repository.save(existing);
        }
        return null;
    }
}
