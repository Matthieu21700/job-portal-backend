package com.dauphine.job_portal_backend.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dauphine.job_portal_backend.model.Application;

public interface ApplicationRepository extends JpaRepository<Application,UUID>{
		
}
