package com.dauphine.job_portal_backend.repository;

import java.util.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dauphine.job_portal_backend.model.Job;
public interface JobRepository extends JpaRepository<Job,UUID> {
	List<Job> findByUserId(UUID userId);

	List<Job> findByLocationAndTypeAndExperienceLevel(String location, String type, String experienceLevel);
}

