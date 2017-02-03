package com.kani.functionDAO;

import java.util.Iterator;
import java.util.List;

import com.kani.dao.DepartmentDAO;
import com.kani.dao.IssueDAO;
import com.kani.dao.UserDAO;
import com.kani.model.Department;
import com.kani.model.Issue;
import com.kani.model.User;

public class CreateTicket {
	Issue issue = new Issue();
	IssueDAO issueDAO = new IssueDAO();

	//create ticket method
 public void createTicket(String emailId, String password, String department, String subject, String description,String priority) {
		
	 LoginDAO loginDao = new LoginDAO();
	 
		if (loginDao.login(emailId, password)) {

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

			issueDAO.save(issue);
		} else {
			System.out.println("Incorrect user name or password");
		}

	}

    //update Ticket Method
	public void updateTicket(String emailId, String password, int issueId, String updateDescription) {

		LoginDAO loginDao = new LoginDAO();
		if (loginDao.login(emailId, password)) {
			User user = new User();
			UserDAO userDao = new UserDAO();

			int userId = userDao.findUserId(emailId).getId();
			user.setId(userId);
			issue.setUserId(user);

			if ("Closed".equals(issueDAO.findStatus(userId, issueId).getStatus())  ||
				"CLOSED".equals(issueDAO.findStatus(userId, issueId).getStatus())) {

				System.out.println("You cant update now! because you closed your ticket");
			} else {

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
	public void updateClose(String emailId, String password, int issueId) {
		LoginDAO loginDao = new LoginDAO();
		if (loginDao.login(emailId, password)) {

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
	public void viewUserDetails(String emailId,String password) {
		LoginDAO loginDao = new LoginDAO();
		if (loginDao.login(emailId, password)) {

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
}


