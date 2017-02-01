package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Employee;
import com.kani.model.Issue;
import com.kani.model.Resolution;

import com.kani.util.ConnectionUtil;

public class ResolutionDAO implements DAO<Resolution> {

	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	@Override
	public void save(Resolution r) {
		String sql = "INSERT INTO RESOLUTIONS(ISSUE_ID) VALUES(?)";
		Object[] params = {r.getIssueId().getId()};
		jdbctemplate.update(sql, params);
	}

	@Override
	public void update(Resolution r) {
		String sql = "UPDATE RESOLUTIONS SET ISSUE_ID = ?,EMPLOYEE_ID = ?,SOLUTION = ? WHERE ID = ?";
		Object[] params = {r.getIssueId().getId(),r.getEmployeeId().getId(),r.getSolution(),r.getId()};
		jdbctemplate.update(sql, params);
		
	}
	
	public void updateEmployeeId(Resolution r) {
		String sql = "UPDATE RESOLUTIONS SET EMPLOYEE_ID = ? WHERE ISSUE_ID = ? ";
		Object[] params = {r.getEmployeeId().getId(),r.getIssueId().getId()};
		jdbctemplate.update(sql, params);
		
	}
	
	public void updateSolution(Resolution r) {
		String sql = "UPDATE RESOLUTIONS SET SOLUTION = ? WHERE ISSUE_ID = ? ";
		Object[] params = {r.getSolution(),r.getIssueId().getId()};
		jdbctemplate.update(sql, params);
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM RESOLUTIONS WHERE ISSUE_ID = ?";
		Object[] params = {id};
		jdbctemplate.update(sql,params);
		
	}

	@Override
	public List<Resolution> findAll() {
		String sql = "SELECT ID,ISSUE_ID,EMPLOYEE_ID,SOLUTION FROM RESOLUTIONS";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private Resolution convert(ResultSet rs) throws SQLException {
		Resolution r = new Resolution();
		
		Issue i = new Issue();
		i.setId(rs.getInt("ID"));
		
		Employee e = new Employee();
		e.setId(rs.getInt("ID"));
		
		r.setId(rs.getInt("ID"));
		r.setIssueId(i);
		r.setEmployeeId(e);
		r.setSolution(rs.getString("SOLUTION"));
		return r;
		
	}

	@Override
	public Resolution findOne(int id) {
		String sql = "SELECT ID,ISSUE_ID,EMPLOYEE_ID,SOLUTION FROM RESOLUTIONS WHERE ID =?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}
	

}
