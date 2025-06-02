package com.dauphine.job_portal_backend.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dauphine.job_portal_backend.model.Application;
import com.dauphine.job_portal_backend.model.ApplicationSkill;

public interface ApplicationRepository extends JpaRepository<Application,UUID>{
	List<Application> findByUserId(UUID userId);
	List<Application> findByJobId(UUID jobId);

}
