package com.oracle.test;

import com.oracle.dao.BookDao;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		System.out.println(dao.getAll());
	}

}
