package com.kani.dao;

import java.util.List;

public interface DAO<T> {
	
	void save(T t);
	void update(T t);
	void delete(int id);
	
	List<T> findAll();
	T findOne(int id);
	
	

}