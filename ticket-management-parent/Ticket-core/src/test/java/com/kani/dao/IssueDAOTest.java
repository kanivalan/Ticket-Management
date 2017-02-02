package com.kani.dao;

import com.kani.model.Department;
import com.kani.model.Issue;
import com.kani.model.User;

public class IssueDAOTest {
	public static void main(String[] args) {
		Issue issue = new Issue();
		IssueDAO issueDAO = new IssueDAO();
		
		User user = new User();
		user.setId(1);
		
		Department dpt = new Department();
		dpt.setId(1);
		
		issue.setUserId(user);
		issue.setDeptId(dpt);
		issue.setSubject("not working");
		issue.setDescription("not worked");
		issue.getDateResolved();
		issue.setStatus("open");
	}

}
