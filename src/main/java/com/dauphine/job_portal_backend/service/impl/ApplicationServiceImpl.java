package com.dauphine.job_portal_backend.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dauphine.job_portal_backend.model.Application;

import com.dauphine.job_portal_backend.model.Application;
import com.dauphine.job_portal_backend.repository.ApplicationRepository;
import com.dauphine.job_portal_backend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application create(Application application) {
        application.setId(UUID.randomUUID()); // on garantit un ID
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> getById(UUID id) {
        return applicationRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        applicationRepository.deleteById(id);
    }

	@Override
	public List<Application> getApplicationsByUserId(UUID id) {
		return applicationRepository.findByUserId(id);
	}
    @Override
    public List<Application> getApplicationsByJobId(UUID jobId) {
        return applicationRepository.findByJobId(jobId);
    }
}
