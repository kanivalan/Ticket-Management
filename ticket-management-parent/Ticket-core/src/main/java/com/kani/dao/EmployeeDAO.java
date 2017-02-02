package com.kani.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Department;
import com.kani.model.Employee;
import com.kani.util.ConnectionUtil;

public class EmployeeDAO implements DAO<Employee>{

	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	@Override
	public void save(Employee employee) {
		String sql = "INSERT INTO EMPLOYEES(NAME,EMAIL_ID,PASSWORD,DEPT_ID) VALUES(?,?,?,?)";
		Object[] params = {employee.getName(),employee.getEmailId(),employee.getPassword(),employee.getDeptId().getId()};
		jdbctemplate.update(sql, params);
		
	}

	@Override
	public void update(Employee employee) {
		String sql = "UPDATE EMPLOYEES SET NAME = ?,MAIL_ID=?,PASSWORD=?,DEPT_ID=? WHERE ID = ?";
		Object[] params = {employee.getName(),employee.getEmailId(),employee.getPassword(),employee.getDeptId().getId(),employee.getId()};
		jdbctemplate.update(sql,params);
	}

	@Override
	public void delete(int id) {
	    String sql = "DELETE FROM EMPLOYEES WHERE ID = ?";
	    Object[] params = {id};
	    jdbctemplate.update(sql,params);
		
	}

	@Override
	public List<Employee> findAll() {
		String sql = "SELECT ID,NAME,EMAIL_ID,PASSWORD,DEPT_ID,ACTIVE FROM EMPLOYEES";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private Employee convert(ResultSet rs) throws SQLException {
		Department dpt = new Department();
		dpt.setId(rs.getInt("ID"));
		
		Employee employee = new Employee();
		employee.setId(rs.getInt("ID"));
		employee.setName(rs.getString("NAME"));
		employee.setEmailId(rs.getString("EMAIL_ID"));
		employee.setPassword(rs.getString("PASSWORD"));
		employee.setDeptId(dpt);
		employee.setActive(rs.getBoolean("ACTIVE"));
		return employee;
	}

	@Override
	public Employee findOne(int id) {
		String sql = "SELECT ID,NAME,EMAIL_ID,PASSWORD,DEPT_ID,ACTIVE FROM EMPLOYEES WHERE ID =?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}

	
}
