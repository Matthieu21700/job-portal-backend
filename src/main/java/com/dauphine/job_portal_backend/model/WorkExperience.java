package com.dauphine.job_portal_backend.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public WorkExperience() {
        this.id = UUID.randomUUID();
    }

    // Getters et setters
}
