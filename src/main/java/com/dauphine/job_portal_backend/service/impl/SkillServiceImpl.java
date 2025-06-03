package com.dauphine.job_portal_backend.service.impl;



import com.dauphine.job_portal_backend.model.Skill;
import com.dauphine.job_portal_backend.repository.SkillRepository;
import com.dauphine.job_portal_backend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill createSkill(Skill skill) {
        skill.setId(UUID.randomUUID());
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> getSkillById(UUID id) {
        return skillRepository.findById(id);
    }

    @Override
    public Optional<Skill> getSkillByName(String name) {
        return skillRepository.findByName(name);
    }

    @Override
    public Skill updateSkill(UUID id, Skill updatedSkill) {
        return skillRepository.findById(id).map(skill -> {
            skill.setName(updatedSkill.getName());
            return skillRepository.save(skill);
        }).orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
    }

    @Override
    public void deleteSkill(UUID id) {
        skillRepository.deleteById(id);
    }
}
