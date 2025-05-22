package com.dauphine.job_portal_backend.model;
import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.math.BigDecimal;


import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name = "qualifications")
    private String qualifications;

    @Column(name = "location")
    private String location;

    @Column(name = "salary_min")
    private BigDecimal salaryMin;

    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(BigDecimal salaryMin) {
		this.salaryMin = salaryMin;
	}

	public BigDecimal getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(BigDecimal salaryMax) {
		this.salaryMax = salaryMax;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "salary_max")
    private BigDecimal salaryMax;

    @Column(name = "type")
    private String type;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Job() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    // Getters et setters
}

