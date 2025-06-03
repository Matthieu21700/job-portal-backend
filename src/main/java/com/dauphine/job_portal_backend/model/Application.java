package com.dauphine.job_portal_backend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
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

	@Column(name = "status")
	private String status = "PENDING";

	@Column(name = "decided_at")
	private LocalDateTime decidedAt;

	@Column(name = "recruiter_message")
	private String recruiterMessage;

	@Column(name = "notification_read")
	private boolean notificationRead = false;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "skills", columnDefinition = "TEXT")
	private String skills;

	@Column(name = "work_experiences", columnDefinition = "TEXT")
	private String workExperiences;

	public Application() {
		this.id = UUID.randomUUID();
		this.appliedAt = LocalDateTime.now();
		this.status = "PENDING";
		this.notificationRead = false;
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(String workExperiences) {
		this.workExperiences = workExperiences;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDecidedAt() {
		return decidedAt;
	}

	public void setDecidedAt(LocalDateTime decidedAt) {
		this.decidedAt = decidedAt;
	}

	public String getRecruiterMessage() {
		return recruiterMessage;
	}

	public void setRecruiterMessage(String recruiterMessage) {
		this.recruiterMessage = recruiterMessage;
	}

	public boolean isNotificationRead() {
		return notificationRead;
	}

	public void setNotificationRead(boolean notificationRead) {
		this.notificationRead = notificationRead;
	}
}