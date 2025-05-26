package com.dauphine.job_portal_backend.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class JobRequestDto {
		public String title;
	    public String description;
	    public String responsibilities;
	    public String qualifications;
	    public String location;
	    public BigDecimal salary_min;
	    public BigDecimal salary_max;
	    public String type;
	    public String experienceLevel;
	    public UUID userId; // 
}
