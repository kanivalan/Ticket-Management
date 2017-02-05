package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kani.model.Role;
import com.kani.util.ConnectionUtil;

public class RoleDAO implements DAO<Role>{

	JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ROLES (NAME) VALUES (?)";
		Object[] params = {role.getName()};
		jdbctemplate.update(sql,params);
		
	}

	@Override
	public void update(Role role) {
		String sql = "UPDATE FROM ROLES SET NAME = ? WHERE ID = ? ";
		Object[] params = {role.getName(),role.getId()};
		jdbctemplate.update(sql,params);
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM ROLES WHERE ID = ?";
		Object[] params = {id};
		jdbctemplate.update(sql,params);
		
	}

	@Override
	public List<Role> findAll() {
		String sql = "SELECT ID,NAME FROM ROLES";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private Role convert(ResultSet rs) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("ID"));
		role.setName(rs.getString("NAME"));
		return role;
	}

	@Override
	public Role findOne(int id) {
		String sql = "SELECT ID,NAME FROM ROLES WHERE ID = ?";
		return jdbctemplate.queryForObject(sql, (rs, rowNo) -> convert(rs));
		
	}
	public Role findRoleId(String name) {
		String sql = "SELECT ID FROM ROLES WHERE NAME = ? "; 
		Object[] params = {name};
		return jdbctemplate.queryForObject(sql, params,(rs, rowNo) -> {
			Role role = new Role();
		role.setId(rs.getInt("ID"));
		
		return role;
		});
	}

}
