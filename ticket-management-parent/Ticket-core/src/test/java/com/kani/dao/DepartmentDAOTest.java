package com.kani.dao;

import java.util.Iterator;
import java.util.List;

import com.kani.model.Department;

public class DepartmentDAOTest {
	public static void main(String[] args) {
		
	//insert	
	Department dpt = new Department();
	DepartmentDAO dptDAO = new DepartmentDAO();
	
	dpt.setName("HR");
	dptDAO.save(dpt);
	
	
	//select all
	List<Department> list = dptDAO.findAll();
	Iterator<Department> i = list.iterator();
	while (i.hasNext()) {
		Department dept = (Department) i.next();
		System.out.println(dept.getId()+"\t"+dept.getName()+"\t"+dept.isActive());
	
	}
}
}
