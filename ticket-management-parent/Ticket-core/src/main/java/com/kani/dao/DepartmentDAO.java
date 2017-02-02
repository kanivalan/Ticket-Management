package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Department;
import com.kani.util.ConnectionUtil;


public class DepartmentDAO implements DAO<Department>  {

	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	@Override
	public void save(Department dpt) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DEPARTMENTS (NAME) VALUES(?)";
		Object[] params = {dpt.getName()};
		jdbctemplate.update(sql, params);
	}

	@Override
	public void update(Department dpt) {
		// TODO Auto-generated method stub
		String sql = "UPDATE DEPARTMENT SET NAME = ? WHERE ID = ?";
		Object[] params = {dpt.getName(),dpt.getId()};
		jdbctemplate.update(sql,params);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM DEPARTMENT WHERE ID=?";
		Object params = id ;
		jdbctemplate.update(sql, params);
		
	}

	@Override
	public List<Department> findAll() {
		String sql = "SELECT ID,NAME,ACTIVE FROM DEPARTMENTS";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private Department convert(ResultSet rs) throws SQLException {
		Department dpt = new Department();
		dpt.setId(rs.getInt("ID"));
		dpt.setName(rs.getString("NAME"));
		dpt.setActive(rs.getBoolean("ACTIVE"));
		return dpt ;
	}

	@Override
	public Department findOne(int id) {
		String sql = "SELECT NAME,ACTIVE FROM DEPARTMENTS WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}

}
