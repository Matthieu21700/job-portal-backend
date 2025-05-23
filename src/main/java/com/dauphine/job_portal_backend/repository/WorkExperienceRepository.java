package com.dauphine.job_portal_backend.repository;
import java.util.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dauphine.job_portal_backend.model.WorkExperience;
public interface WorkExperienceRepository extends JpaRepository<WorkExperience,UUID>{
	List<WorkExperience> findByApplicationId(UUID applicationId);
}
