package com.kani.dao;

import java.util.List;

import com.kani.model.Role;

public class RoleDAOTest {

	public static void main(String[] args) {
		Role role = new Role();
		RoleDAO roleDAO = new RoleDAO();
		
		role.setId(1);
		role.setName("Hr");
		
		roleDAO.save(role);
		
		
		List<Role> list = roleDAO.findAll();
		for (Role i : list) {
			System.out.println(i.getId()+"\t"+i.getId());
		}

	}

}
