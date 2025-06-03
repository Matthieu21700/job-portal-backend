package com.dauphine.job_portal_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dauphine.job_portal_backend.model.Application;

public interface ApplicationService {
    Application create(Application application);
    List<Application> getAll();
    Optional<Application> getById(UUID id);
    void delete(UUID id);
    List<Application> getApplicationsByUserId(UUID id);
    List<Application> getApplicationsByJobId(UUID jobId);
    Application acceptApplication(UUID applicationId, String recruiterMessage);
    Application rejectApplication(UUID applicationId, String recruiterMessage);
    Application markNotificationAsRead(UUID applicationId);
    List<Application> getUnreadNotifications(UUID userId);
}