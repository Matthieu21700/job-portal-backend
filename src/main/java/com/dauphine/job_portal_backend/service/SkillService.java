package com.dauphine.job_portal_backend.service;

import java.util.*;

import com.dauphine.job_portal_backend.model.Skill;

public interface SkillService {
	Skill createSkill(Skill skill);
    List<Skill> getAllSkills();
    Optional<Skill> getSkillById(UUID id);
    Optional<Skill> getSkillByName(String name);
    Skill updateSkill(UUID id, Skill updatedSkill);
    void deleteSkill(UUID id);
}
