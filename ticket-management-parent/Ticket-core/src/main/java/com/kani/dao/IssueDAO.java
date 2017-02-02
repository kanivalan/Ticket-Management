package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Department;
import com.kani.model.Issue;
import com.kani.model.User;
import com.kani.util.ConnectionUtil;

public class IssueDAO implements DAO<Issue> {

	
	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	@Override
	public void save(Issue issue) {
		String sql = "INSERT INTO ISSUES(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_REPORTED,DATE_RESOLVED,STATUS) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {issue.getUserId().getId(),issue.getDeptId().getId(),issue.getSubject(),issue.getDescription(),issue.getDateReported(),issue.getDateResolved(),issue.getStatus()};
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
		issue.setDateReported(rs.getDate("REPORTED_DATE").toLocalDate());
        issue.setDateResolved(rs.getDate("DATE_RESOLVED").toLocalDate());
        
		
		return issue;
	}

	@Override
	public Issue findOne(int id) {
		String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,DATE_REPORTED,DATE_RESOLVED,STATUS FROM ISSUES WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}

}
