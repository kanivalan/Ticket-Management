package com.kani.functionDAO;

import java.util.Iterator;
import java.util.List;

import com.kani.dao.DepartmentDAO;
import com.kani.dao.IssueDAO;
import com.kani.dao.UserDAO;
import com.kani.exception.PersistenceException;
import com.kani.model.Department;
import com.kani.model.Issue;
import com.kani.model.Resolution;
import com.kani.dao.ResolutionDAO;
import com.kani.dao.RoleDAO;
import com.kani.model.Employee;
import com.kani.dao.EmployeeDAO;
import com.kani.model.User;

public class CreateTicket {
	Issue issue = new Issue();
	IssueDAO issueDAO = new IssueDAO();

	//create ticket method
 public void createTicket(String emailId, String password, String department, String subject, String description,String priority) throws PersistenceException {
		
	 LoginDAO loginDao = new LoginDAO();
	 
		if (loginDao.userLogin(emailId, password)) {

			Department dept = new Department();
			DepartmentDAO deptDAO = new DepartmentDAO();

			User user = new User();
			UserDAO userDAO = new UserDAO();

			int userId = userDAO.findUserId(emailId).getId();
			user.setId(userId);

			int deptid = deptDAO.findId(department).getId();
			dept.setId(deptid);

			issue.setUserId(user);
			issue.setDeptId(dept);
			issue.setSubject(subject);
			issue.setDescription(description);
			issue.setPriority(priority);
			issue.setStatus("open");

			issueDAO.save(issue);
			
			
			int issueId = issueDAO.findIssueId(userId, subject, description).getId();
			Resolution solution = new Resolution();
			ResolutionDAO resolutionDAO = new ResolutionDAO();
	
			
			issue.setId(issueId);
			solution.setIssueId(issue);
			resolutionDAO.save(solution);
		} 
	}

    //update Ticket Method
	public void updateTicket(String emailId, String password, int issueId, String updateDescription) throws PersistenceException {

		LoginDAO loginDao = new LoginDAO();
		if (loginDao.userLogin(emailId, password)) {
			User user = new User();
			UserDAO userDao = new UserDAO();

			int userId = userDao.findUserId(emailId).getId();
			user.setId(userId);
			issue.setUserId(user);

			if ("Closed".equals(issueDAO.findStatus(userId, issueId).getStatus())  ||
				"CLOSED".equals(issueDAO.findStatus(userId, issueId).getStatus())) {

				System.out.println("You cant update now! because you closed your ticket");
			} 
			else {

				issue.setUserId(user);
				issue.setId(issueId);
				issue.setStatus("Inprogress");
				issue.setDescription(updateDescription);
				issueDAO.updateDescription(issue);

			}
		} else {
			System.out.println("Incorrect user name or password");
		}
	}

	//close ticket method
	public void updateClose(String emailId, String password, int issueId) throws PersistenceException {
		LoginDAO loginDao = new LoginDAO();
		if (loginDao.userLogin(emailId, password)) {

			User user = new User();
			UserDAO userDao = new UserDAO();

			int userId = userDao.findUserId(emailId).getId();
			user.setId(userId);

			issue.setUserId(user);

			issue.setId(issueId);

			issueDAO.updateClose(issue);

		} else {
			System.out.println("Incorrect user name or password");
		}
	}
	
	//User can view all ticket details
	public void viewUserDetails(String emailId,String password) throws PersistenceException {
		
		LoginDAO loginDao = new LoginDAO();
		if (loginDao.userLogin(emailId, password)) {

			User user = new User();
			UserDAO userDao = new UserDAO();

			int userId = userDao.findUserId(emailId).getId();
			user.setId(userId);

			issue.setUserId(user);
			
			issueDAO.viewMyTicket(user.getId());
			List<Issue> list = issueDAO.viewMyTicket(userId);
			
			Iterator<Issue> i = list.iterator();
			
			while (i.hasNext()) {
				Issue issue = (Issue) i.next();
				System.out.println(issue.getId()+ "\t"+issue.getUserId().getId()+"\t" +issue.getSubject() + "\t"
						+ issue.getDescription() + "\t"+ issue.getStatus());
			}
		}
			else
			{
				System.out.println("Incorrect user name or password");
			}
	}		
	
	
	
	//VERSION - 2 (ASSIGN EMPLOYEE TO THE TICKET )
	public void assignTicketToEmployee (String emailId,String password, int issueId, int empId)throws PersistenceException {
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee = new Employee();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				EmployeeDAO employeeDao = new EmployeeDAO();
				
				
				int currentEmployeeDeptId = employeeDao.findEmpDeptId(emailId, password).getDeptId().getId();
				int EmployeeDeptId = employeeDao.findDeptId(empId).getDeptId().getId();
				
				if (currentEmployeeDeptId == EmployeeDeptId) {

					Resolution resolution = new Resolution();
					ResolutionDAO solutionDao = new ResolutionDAO();

			
					employee.setId(empId);
					issue.setEmpId(employee);
					
					issue.setId(issueId);
					resolution.setIssueId(issue);
					
					employee.setId(empId);
					resolution.setEmployeeId(employee);
					
					solutionDao.updateEmployeeId(resolution);
					
					issueDAO.updateIssue(issue);
				} else {
					System.out.println("Department dosent match");
				}
			
		     } 
		}catch (PersistenceException e) {
			throw new PersistenceException("Login Failed", e);
		}

	}
	
	//update the solution status to resolved after employee will give a solution to user
	public void ticketSolution(String emailId, String password, int issueId, String ticketSolution)throws PersistenceException {
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Resolution resolution = new Resolution();
	
				EmployeeDAO empDAO = new EmployeeDAO();
				Employee emp = new Employee();
				
				int empId = empDAO.findEmployeeId(emailId, password).getId();
				
				ResolutionDAO resolutionDao = new ResolutionDAO();
				
				issue.setId(issueId);
				resolution.setIssueId(issue);
				emp.setId(empId);
				resolution.setEmployeeId(emp);
				resolution.setSolution(ticketSolution);

				resolutionDao.updateSolution(resolution);
				

				issueDAO.updateIssueStatus(issue);
			}
		} catch (PersistenceException e) {
			throw new PersistenceException("Login Failed", e);
		}

	}
	
	//Only Admin can delete tickets
	public void deleteTicket(String emailId,String password,int issueId) throws PersistenceException {
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee=new Employee();
				EmployeeDAO employeeDao=new EmployeeDAO();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeRoleId=employeeDao.findEmployeeRoleId(emailId, password).getRoleId().getId();
				
				
				RoleDAO roleDao=new RoleDAO();
				int adminRoleId=roleDao.findRoleId("admin").getId();

				if(employeeRoleId==adminRoleId){
					ResolutionDAO solutionDao=new ResolutionDAO();
					solutionDao.delete(issueId);
					issueDAO.delete(issueId);
				}
				else{
					System.out.println("You dont have enough rights to delete");
				}
				
				
			}

	}catch (PersistenceException e) {
		throw new PersistenceException("Login Failed", e);
	}
	}

	public void findEmployeeTickets(String emailId, String password) throws PersistenceException{
		LoginDAO loginDao = new LoginDAO();
		try {
			if (loginDao.employeeLogin(emailId, password)) {
				Employee employee=new Employee();
				EmployeeDAO employeeDao=new EmployeeDAO();
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeId=employeeDao.findEmployeeId(emailId, password).getId();
				
				issueDAO.viewEmployeeTicket(employeeId);
				List<Issue> list = issueDAO.viewEmployeeTicket(employeeId);
				Iterator<Issue> i = list.iterator();
				while (i.hasNext()) {
					Issue issues = (Issue) i.next();
					System.out.println(issues.getId()+ "\t" +issues.getSubject() + "\t"
							+ issues.getDescription() +"\t"+issues.getDateResolved());
				}
				
			}
		
	}catch (PersistenceException e) {
		throw new PersistenceException("Login Failed", e);
	}
		
}
}



