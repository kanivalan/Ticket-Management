package com.kani.model;

import lombok.Data;

@Data
public class Employee {

	private int Id;
	private String Name;
	private String emailId;
	private String password;
	private Department deptId;
	private boolean active;
	
}
