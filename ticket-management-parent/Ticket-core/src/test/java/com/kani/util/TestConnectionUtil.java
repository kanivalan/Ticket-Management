package com.kani.util;

public class TestConnectionUtil {

	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getDataSource());
		System.out.println(ConnectionUtil.getJdbcTemplate());
	}

}
