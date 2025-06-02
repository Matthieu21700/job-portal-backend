package com.dauphine.job_portal_backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dauphine.job_portal_backend.model.Application;
import com.dauphine.job_portal_backend.repository.ApplicationRepository;
import com.dauphine.job_portal_backend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application create(Application application) {
        application.setId(UUID.randomUUID());
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

    // NOUVELLES IMPLÉMENTATIONS
    @Override
    public Application acceptApplication(UUID applicationId, String recruiterMessage) {
        Optional<Application> optionalApplication = applicationRepository.findById(applicationId);
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setStatus("ACCEPTED");
            application.setDecidedAt(LocalDateTime.now());
            application.setRecruiterMessage(recruiterMessage);
            application.setNotificationRead(false); // Nouvelle notification
            return applicationRepository.save(application);
        }
        throw new RuntimeException("Application not found with id: " + applicationId);
    }

    @Override
    public Application rejectApplication(UUID applicationId, String recruiterMessage) {
        Optional<Application> optionalApplication = applicationRepository.findById(applicationId);
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setStatus("REJECTED");
            application.setDecidedAt(LocalDateTime.now());
            application.setRecruiterMessage(recruiterMessage);
            application.setNotificationRead(false); // Nouvelle notification
            return applicationRepository.save(application);
        }
        throw new RuntimeException("Application not found with id: " + applicationId);
    }

    @Override
    public Application markNotificationAsRead(UUID applicationId) {
        Optional<Application> optionalApplication = applicationRepository.findById(applicationId);
        if (optionalApplication.isPresent()) {
            Application application = optionalApplication.get();
            application.setNotificationRead(true);
            return applicationRepository.save(application);
        }
        throw new RuntimeException("Application not found with id: " + applicationId);
    }

    @Override
    public List<Application> getUnreadNotifications(UUID userId) {
        return applicationRepository.findByUserIdAndNotificationReadFalseAndStatusNot(userId, "PENDING");
    }
}