package com.rays.byconstructor;

import com.rays.autowire.UserDAOInt;

public class UserServiceByConstructor {
	
	private UserDAOInt userDao;
	
	public UserServiceByConstructor(UserDAOInt userDAO) {
		
	}
	
	public void testAdd() {
		userDao.add();
	}

}
