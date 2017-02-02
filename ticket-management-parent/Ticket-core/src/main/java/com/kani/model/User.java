package com.kani.model;

import lombok.Data;

@Data
public class User {

	private int Id;
	private String Name;
	private String emailId;
	private String password;
	private boolean active;
	
}