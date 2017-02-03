package com.kani.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import com.kani.model.Department;
import com.kani.model.Employee;
import com.kani.model.Issue;
import com.kani.model.User;

public class IssueDAOTest {
	public static void main(String[] args) {
//		Issue issue = new Issue();
		IssueDAO issueDAO = new IssueDAO();
		
//		User user = new User();
//		user.setId(1);
//		
//		Department dpt = new Department();
//		dpt.setId(1);
//		
//		issue.setUserId(user);
//		issue.setDeptId(dpt);
//		issue.setSubject("not working");
//		issue.setDescription("not worked");
////		LocalTime dateresolved = LocalDate.parse("");
//		issue.getDateResolved();
//		issue.setStatus("open");
//		issueDAO.save(issue);
		
		List<Issue> list = issueDAO.findAll();
		Iterator<Issue> i = list.iterator();
		while (i.hasNext()) {
			Issue is = (Issue) i.next();
			System.out.println(is.getId()+"\t"+is.getUserId().getId()+"\t"+is.getDeptId().getId()+"\t"+is.getSubject()+"\t"+is.getDescription()+"\t"+is.getDateReported()+"\t"+is.getDateResolved()+"\t"+is.getStatus());
		
		}
		
	}

}
