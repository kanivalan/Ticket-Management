package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Department;
import com.kani.model.Issue;
import com.kani.model.Resolution;
import com.kani.model.User;
import com.kani.util.ConnectionUtil;

public class IssueDAO implements DAO<Issue> {

	
	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	@Override
	public void save(Issue issue) {
		String sql = "INSERT INTO ISSUES(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,DATE_REPORTED,DATE_RESOLVED,STATUS) VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = {issue.getUserId().getId(),issue.getDeptId().getId(),issue.getSubject(),issue.getDescription(),issue.getPriority(),issue.getDateReported(),issue.getDateResolved(),issue.getStatus()};
		jdbctemplate.update(sql, params);
	}

	@Override
	public void update(Issue issue) {
		String sql = "UPDATE ISSUES SET USER_ID = ?,DEPARTMENT_ID = ?,SUBJECT = ?,DESCRIPTION = ?,DATE_REPORTED = ?,DATE_RESOLVED = ?,STATUS =? WHERE ID =?";
		Object[] params = {issue.getUserId().getId(),issue.getDeptId().getId(),issue.getSubject(),issue.getDescription(),issue.getDateReported(),issue.getDateResolved(),issue.getStatus(),issue.getId()};
		jdbctemplate.update(sql, params);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM ISSUES WHERE ID = ?";
		Object params = id;
		jdbctemplate.update(sql,params);
	}

	@Override
	public List<Issue> findAll() {
		String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_REPORTED,DATE_RESOLVED,STATUS FROM ISSUES";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private Issue convert(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("ID"));
		
		Department dpt = new Department();
		dpt.setId(rs.getInt("ID"));
		
		Issue issue = new Issue();
		issue.setId(rs.getInt("ID"));
		issue.setUserId(user);
		issue.setDeptId(dpt);
		issue.setSubject(rs.getString("SUBJECT"));
		issue.setDescription(rs.getString("DESCRIPTION"));
		issue.setDateResolved(rs.getDate("DATE_RESOLVED").toLocalDate());
		issue.setDateReported(rs.getDate("DATE_REPORTED").toLocalDate());
		
		
        
		
		return issue;
	}

	
	public Issue findOne(int id) {
		String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_REPORTED,DATE_RESOLVED,STATUS FROM ISSUES WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}
	
	public Issue findStatus(int userId,int id) {
		String sql = "SELECT STATUS FROM ISSUES WHERE USER_ID=? AND ID = ?";
		Object[] params = { userId,id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Issue issue=new Issue();
			issue.setStatus(rs.getString("STATUS"));
			return issue;
		
		});

	}
	//USER CAN CHANGE 
	public void updateDescription(Issue issue) {
		String sql = "UPDATE ISSUES SET DESCRIPTION=?,STATUS=? WHERE ID=? AND USER_ID=?";
		Object[] params = {issue.getDescription(),issue.getStatus(),issue.getId(),issue.getUserId().getId()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}
	
	//USER CLOSE THE TICKET, STATUS UPDATED TO CLOSED
	public void updateClose(Issue issue) {
		String sql = "UPDATE ISSUES SET STATUS = 'closed' WHERE ID=? AND USER_ID=?";
		Object[] params = {issue.getId(),issue.getUserId().getId()};
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}
	
	// USER VIEW HIS/HER TICKETS
	public List<Issue> viewMyTicket(int userId) {
		String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_REPORTED,DATE_RESOLVED FROM ISSUES WHERE USER_ID = ?";
		Object[] params = { userId };
		return jdbctemplate.query(sql, params, (rs, rowNo) -> convert(rs));
	}
	
	//AFTER USER CREATE AN TICKET, STATUS UPDATED TO "IN PROGRESS"
	public void updateIssue(Issue issue) {
		String sql = "UPDATE ISSUES SET EMPLOYEE_ID = ?,STATUS='In Progress' WHERE ID=?";
		Object[] params = { issue.getEmpId().getId(),issue.getId() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}
	
	
	//UPDATE ISSUE TABLE STATUS TO "RESOLVED" AFTER EMPLOYEE GIVE AN SOLUTION TO THE USER
	public void updateIssueStatus(Issue issue) {
		String sql = "UPDATE ISSUES SET STATUS='Resolved',DATE_RESOLVED=NOW() WHERE ID=?";
		Object[] params = { issue.getId() };
		int rows = jdbctemplate.update(sql, params);
		System.out.println(rows);

	}
	
	//EMPLOYEE VIEW ALL TICKETS
	public List<Issue> viewEmployeeTicket(int empId) {
		String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_RESOLVED FROM ISSUES WHERE EMPLOYEE_ID = ? " ;
		Object[] params = { empId };
		return jdbctemplate.query(sql, params, (rs, rowNo) -> {
			Issue issue=new Issue();
			User user = new User();
			user.setId(rs.getInt("ID"));
			
			Department dept = new Department();
			dept.setId(rs.getInt("ID"));
			
			issue.setId(rs.getInt("ID"));
			issue.setUserId(user);
			issue.setDeptId(dept);
			issue.setSubject(rs.getString("SUBJECT"));
			issue.setDescription(rs.getString("DESCRIPTION"));
		    issue.setDateResolved(rs.getDate("DATE_RESOLVED").toLocalDate());
			return issue;
		
		});
	}
	
	public Issue findIssueId(int userId, String subject, String description) {
		String sql = "SELECT ID FROM ISSUES WHERE USER_ID=? AND SUBJECT=? AND DESCRIPTION=?";
		Object[] params = { userId, subject, description };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Issue issue = new Issue();
			issue.setId(rs.getInt("ID"));
			return issue;

		});

}
	
}
