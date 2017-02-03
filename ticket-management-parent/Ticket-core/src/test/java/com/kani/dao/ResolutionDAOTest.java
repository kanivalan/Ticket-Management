package com.kani.dao;

import java.util.Iterator;
import java.util.List;

import com.kani.model.Employee;
import com.kani.model.Issue;
import com.kani.model.Resolution;

public class ResolutionDAOTest {

	public static void main(String[] args) {
		Resolution res = new Resolution();
		ResolutionDAO resDAO = new ResolutionDAO();
		
//		Employee emp = new Employee();
//		emp.setId(1);
//		
//		Issue issue = new Issue();
//		issue.setId(1);
//		
//		res.setEmployeeId(emp);
//		res.setIssueId(issue);
//		res.setSolution("fixed");
//		
//		resDAO.save(res);
		
		List<Resolution> list = resDAO.findAll();
		Iterator<Resolution> i = list.iterator();
		while (i.hasNext()) {
			Resolution r = (Resolution) i.next();
			System.out.println(r.getId()+"\t"+r.getIssueId().getId()+"\t"+r.getEmployeeId().getId()+"\t"+r.getSolution());
		
		}
		

	}

}
