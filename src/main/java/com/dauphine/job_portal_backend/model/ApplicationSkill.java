package com.dauphine.job_portal_backend.model;



import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "application_skills")
@IdClass(ApplicationSkillId.class)
public class ApplicationSkill {

    @Id
    @Column(name = "application_id")
    private UUID applicationId;

    @Id
    @Column(name = "skill_id")
    private UUID skillId;

    public ApplicationSkill() {}

    public ApplicationSkill(UUID applicationId, UUID skillId) {
        this.applicationId = applicationId;
        this.skillId = skillId;
    }

	public UUID getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(UUID applicationId) {
		this.applicationId = applicationId;
	}

	public UUID getSkillId() {
		return skillId;
	}

	public void setSkillId(UUID skillId) {
		this.skillId = skillId;
	}

}
