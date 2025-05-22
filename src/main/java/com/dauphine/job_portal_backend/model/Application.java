package com.dauphine.job_portal_backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

	@Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    public Application() {
        this.id = UUID.randomUUID();
        this.appliedAt = LocalDateTime.now();
    }

    // Getters et setters
}
