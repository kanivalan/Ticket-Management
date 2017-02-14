package com.kani.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kani.dao.UserDAO;
import com.kani.exception.PersistenceException;
import com.kani.exception.ServiceException;
import com.kani.functionDAO.LoginDAO;
import com.kani.model.Issue;
import com.kani.model.User;
import com.kani.service.*;



@Controller
@RequestMapping("/tickets")
public class CreateTicketController {
	private static final Logger LOGGER = Logger.getLogger(CreateTicketController.class.getName());
	

	@GetMapping
	public void index(){
		System.out.println("TicketController->index");
	}
	
	@GetMapping("/register")
	public String registerNewUser(@RequestParam("Name") String name, @RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password) throws ServiceException {
		
		System.out.println("TicketController-> register- name:"+ name +",emailid=" + emailId  + ",password:" + password);
		User user = new User();
		TicketService ticketService=new TicketService();
		user.setEmailId(emailId);
		user.setName(name);
		user.setPassword(password);

		System.out.println(user);
		try {
			ticketService.registration(name, emailId, password);
			return "redirect:../index.jsp";

		} catch (ServiceException e) {
			
			LOGGER.log(Level.SEVERE, "Registration Failed Exception Occured!!", e);
			return "register.jsp";
			
		}

	}
	
	@GetMapping("/login")
	public String userLogin(@RequestParam("EmailId") String emailId,@RequestParam("Password") String password) throws ServiceException {
		System.out.println("TicketController-> login - emailid=" + emailId  + ",password:" + password);
		LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.userLogin(emailId, password);
			return "redirect:../ticket.jsp";

		} catch ( PersistenceException e) {
			
			LOGGER.log(Level.SEVERE, "Registration Failed Exception Occured!!", e);
			return "register.jsp";
			
		}

	}

	@GetMapping("/employeeLogin")
	public String employeeLogin(@RequestParam("EmailId") String emailId,@RequestParam("Password") String password) throws ServiceException {
		System.out.println("TicketController-> login - emailid=" + emailId  + ",password:" + password);
		LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.employeeLogin(emailId, password);
			return "redirect:../employeePage.jsp";

		} catch ( PersistenceException e) {
			
			LOGGER.log(Level.SEVERE, "Registration Failed Exception Occured!!", e);
			return "register.jsp";
			
		}

	}
	
	
	@GetMapping("/create_ticket")
	public String createTicket(@RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password,@RequestParam("Subject") String subject,@RequestParam("Description") String description,@RequestParam("Department") String department,@RequestParam("Priority") String priority) throws ServiceException {
		
		System.out.println("TicketController->create ticket-EmailId" + emailId  + ",Password:" + password + ",Subject" +subject+ ",Description:"+ ",Department:" + department + description+ ",Priority:" + priority);
		User user = new User();
		TicketService ticketService=new TicketService();
		user.setEmailId(emailId);
		user.setPassword(password);
		
		System.out.println(user);
		try {
			ticketService.createTicket(emailId, password, subject, description, department, priority);
			return "redirect:../login.jsp";

		} catch (ServiceException e) {
			
			LOGGER.log(Level.SEVERE, "Ticket Creation Failed Exception Occured!!", e);
			return "create_ticket.jsp";
			
		}

	}
	@GetMapping("/update_ticket")
	public String updateTicket(@RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password, @RequestParam("IssueId") int issueId,
			@RequestParam("UpdateDescription") String updateDescription) throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password
				+ ",IssueId" + issueId + ",Description:" + updateDescription);
		TicketService createTicketService = new TicketService();

		try {
			createTicketService.updateTicket(emailId, password, issueId, updateDescription);
			return "redirect:../ticket.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Updating Description Exception Occured!!", e);
			return "update_ticket.jsp";

		}

	}

	@GetMapping("/update_close")
	public String updateClose(@RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password, @RequestParam("IssueId") int issueId) throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password
				+ ",IssueId" + issueId);
		TicketService createTicketService = new TicketService();

		try {
			createTicketService.updateClose(emailId, password, issueId);
			return "redirect:../ticket_closed.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Closing TicketException Occured!!", e);
			return "update_close.jsp";

		}

	}

	@GetMapping("/find_user_details")
	public String findUserDetails(@RequestParam("EmailId") String emailId, @RequestParam("Password") String password,ModelMap map)
			throws ServiceException {

		System.out.println("TicketController-> viewTicket- name:EmailId" + emailId + ",Password:" + password);
		TicketService createTicketService = new TicketService();
	try{
		List<Issue> i=createTicketService.findUserDetails(emailId,password);
		map.addAttribute("list", i);
		return "../viewUserdetailTable.jsp";
	}
	catch (ServiceException e) {
		map.addAttribute("ERROR", e.getMessage());
		LOGGER.log(Level.SEVERE, "Assigning Employee  Ticket Exception Occured!!", e);
		return "../find_user_details.jsp";

	}
	}

	@GetMapping("/assign_employee")
	public String assignEmployee(@RequestParam("EmailId") String emailId,@RequestParam("Password") String password, @RequestParam("IssueId") int issueId, @RequestParam("EmployeeId") int employeeId)
			throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password+",IssueId:"+issueId+",EmployeeId:"+employeeId);
		TicketService createTicketService = new TicketService();

		try {
			createTicketService.assignTicketToEmployee(emailId, password, issueId, employeeId);
			return "redirect:../employeeLogin.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Assigning Employee  Ticket Exception Occured!!", e);
			return "assign_employee.jsp";

		}

	}
	
	@GetMapping("/ticket_solution")
	public String ticketSolution(@RequestParam("EmailId") String emailId,@RequestParam("Password") String password, @RequestParam("IssueId") int issueId, @RequestParam("TicketSolution") String ticketSolution)
			throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password+",IssueId:0"+issueId+",TicketSolution:"+ticketSolution);
		TicketService createTicketService = new TicketService();

		try {
			createTicketService.ticketSolution(emailId, password, issueId, ticketSolution);
			return "redirect:../employeePage.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Assigning Solution to  Ticket Exception Occured!!", e);
			return "ticket_solution.jsp";

		}

	}

	@GetMapping("/find_employee_tickets")
	public String findEmployeeTickets(@RequestParam("EmailId") String emailId, @RequestParam("Password") String password,ModelMap map)
			throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password);
		TicketService createTicketService = new TicketService();

		try{
						
			List<Issue> i= createTicketService.findEmployeeTickets(emailId, password);
			map.addAttribute("list", i);
			return "../viewEmployeedetailtable.jsp";
		}
 catch (ServiceException e) {
			map.addAttribute("ERROR", e.getMessage());
			LOGGER.log(Level.SEVERE, "Viewing  Ticket Exception Occured!!", e);
			return "../find_employee_tickets.jsp";
 }

		}


	@GetMapping("/delete_ticket")
	public String deleteTicket(@RequestParam("EmailId") String emailId,@RequestParam("Password") String password, @RequestParam("IssueId") int issueId)
			throws ServiceException {

		System.out.println("TicketController-> updateTicket- name:EmailId" + emailId + ",Password:" + password+",IssueId:0"+issueId);
		TicketService createTicketService = new TicketService();

		try {
			createTicketService.deleteTickets(emailId, password, issueId);
			return "redirect:../tickest_deleted.jsp";

		} catch (ServiceException e) {

			LOGGER.log(Level.SEVERE, "Deleting Ticket Exception Occured!!", e);
			return "delete_ticket.jsp";

		}

	}
	
}

