package com.kani.service;

import com.kani.functionDAO.CreateTicket;
import com.kani.exception.PersistenceException;
import com.kani.exception.ServiceException;
import com.kani.exception.ValidatorException;
import com.kani.Validator.CloseTicketValidator;
import com.kani.Validator.CreateTicketValidator;
import com.kani.Validator.RegistrationValidator;
import com.kani.Validator.UpdateTicketValidator;

public class TicketService {
	
	CreateTicketValidator createTicketValidator=new CreateTicketValidator();
	CreateTicket createTicketDao=new CreateTicket();
	
	RegistrationValidator regvalidator = new RegistrationValidator();
	UpdateTicketValidator updateTicketValidator = new UpdateTicketValidator();
	CloseTicketValidator closeTicketValidator = new CloseTicketValidator();
//	RegistrationDAO regDAO = new RegistrationDAO();
	
	public void registration(String name,String emailId,String password) throws ServiceException, PersistenceException{
		
		try {
			regvalidator.registerValidator(name, emailId, password);
			
		} catch (ValidatorException e) {
			throw new ServiceException("Registration Failed",e);
		}
	}
	
	public void createTicket(String emailId,String password,String subject,String description,String department,String priority) throws ServiceException {
		
		try {
			createTicketValidator.createTicketValidator(emailId, password, subject, description, department, priority);
			createTicketDao.createTicket(emailId, password, subject, description, department, priority);
		} 
		catch (ValidatorException e) {
			throw new ServiceException("Cannot Create Ticket",e);
			
		}
	}
	
	
public void updateTicket(String emailId,String password,int issueId,String updateDescription) throws ServiceException, PersistenceException {
		
		try {
			updateTicketValidator.updateTicketValidator(emailId, password, issueId, updateDescription);
			createTicketDao.updateTicket(emailId, password, issueId, updateDescription);
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Update Ticket",e);
			
		}
	}

	public void updateClose(String emailId,String password,int issueId) throws ServiceException, PersistenceException {
		
		try {
			closeTicketValidator.closeTicketValidator(emailId, password,issueId);
			createTicketDao.updateClose(emailId, password,issueId);
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot Close Ticket",e);
			
		}
	}

	public void findUserDetails(String emailId,String password) throws ServiceException, PersistenceException {
		
		try {
			createTicketValidator.findUserDetails(emailId, password);
			createTicketDao.viewUserDetails (emailId,password);
		} catch (ValidatorException e) {
			throw new ServiceException("Cannot View Ticket",e);
			
		}
	}
}
