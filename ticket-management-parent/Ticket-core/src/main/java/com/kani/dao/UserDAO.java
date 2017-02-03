package com.kani.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kani.model.User;
import com.kani.util.ConnectionUtil;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO implements DAO<User> {

	private JdbcTemplate jdbctemplate = ConnectionUtil.getJdbcTemplate();
	
	
	@Override
	public void save(User user) {
		String sql = "INSERT INTO USERS(NAME,EMAIL_ID,PASSWORD)VALUES(?,?,?)";
		Object[] params = {user.getName(),user.getEmailId(),user.getPassword() };
		jdbctemplate.update(sql, params);
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE USERS SET NAME=?,EMAIL_ID=?,PASSWORD=?,ACTIVE=? WHERE ID=?";
		Object[] params = {user.getName(),user.getEmailId(),user.getPassword(),user.isActive(),user.getId()};
		jdbctemplate.update(sql, params);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM USERS WHERE ID=?";
		Object params = id ;
		jdbctemplate.update(sql, params);
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT ID, NAME,EMAIL_ID,PASSWORD,ACTIVE FROM USERS";
		return jdbctemplate.query(sql, (rs, rowNo) -> convert(rs));
	}

	private User convert(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		user.setEmailId(rs.getString("EMAIL_ID"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setActive(rs.getBoolean("ACTIVE"));
		return user;
	}

	@Override
	public User findOne(int id) {
		String sql = "SELECT NAME,EMAIL_ID,PASSWORD,ACTIVE FROM USERS WHERE ID = ?";
		Object[] params = { id };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));
	}
	
	public User findOne(String emailId){
		String sql = "SELECT PASSWORD FROM USERS WHERE EMAIL_ID = ?";
		Object[] params ={emailId}; 
		return jdbctemplate.queryForObject(sql, params,(rs, rowNo) -> {
		User user = new User();
		user.setPassword(rs.getString("PASSWORD"));
		return user;
		});
		
	}
	public User findUserId(String emailId) {
		String sql = "SELECT ID FROM USERS WHERE EMAIL_ID = ?";
		Object[] params = { emailId };
		return jdbctemplate.queryForObject(sql, params, (rs, rowNo) -> {
			User user=new User();
			user.setId(rs.getInt("ID"));
			return user;
		
		});

}
}
