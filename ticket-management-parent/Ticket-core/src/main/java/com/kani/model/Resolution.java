package com.kani.model;

import lombok.Data;

@Data
public class Resolution {

	private int id;
	private Issue issueId;
	private Employee employeeId;
	private String solution;
}
