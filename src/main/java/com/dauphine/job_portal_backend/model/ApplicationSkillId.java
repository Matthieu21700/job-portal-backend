package com.dauphine.job_portal_backend.model;


import java.io.Serializable;
import java.util.UUID;
import java.util.Objects;

public class ApplicationSkillId implements Serializable {

    private UUID applicationId;
    private UUID skillId;

    public ApplicationSkillId() {}

    public ApplicationSkillId(UUID applicationId, UUID skillId) {
        this.applicationId = applicationId;
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationSkillId)) return false;
        ApplicationSkillId that = (ApplicationSkillId) o;
        return Objects.equals(applicationId, that.applicationId) &&
               Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, skillId);
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
