package com.kani.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Issue {

	private int Id;
	private User userId;
	private Department deptId;
	private String subject;
	private String description;
	private String priority;
	private LocalDate dateReported;
	private LocalDate dateResolved;
	private String status;
}
