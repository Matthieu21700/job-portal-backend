package com.dauphine.job_portal_backend.repository;
import com.dauphine.job_portal_backend.model.Skill;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SkillRepository extends JpaRepository<Skill,UUID>{
	Optional<Skill> findByName(String name);
}
