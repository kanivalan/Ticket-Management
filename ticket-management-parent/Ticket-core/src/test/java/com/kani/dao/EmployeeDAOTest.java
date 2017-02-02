package com.kani.dao;

import java.util.Iterator;
import java.util.List;

import com.kani.model.Employee;

public class EmployeeDAOTest {

	public static void main(String[] args) {
		//insert
//		Employee employee = new Employee();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
//		Department dpt = new Department();
//		dpt.setId(1);
//		
//		employee.setName("arun");
//		employee.setEmailId("arun376@gmail.com");
//		employee.setPassword("arun123");
//		employee.setDeptId(dpt);
//		employee.setActive(true);
//		
//		employeeDAO.save(employee);
		
		//select all
		List<Employee> list = employeeDAO.findAll();
		Iterator<Employee> i = list.iterator();
		while (i.hasNext()) {
			Employee emp = (Employee) i.next();
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getEmailId()+"\t"+emp.getPassword()+"\t"+emp.getDeptId().getId());
		
		}
	}
}
