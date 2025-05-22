package com.dauphine.job_portal_backend.model;


import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    public Skill() {
        this.id = UUID.randomUUID();
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
