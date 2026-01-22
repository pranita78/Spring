package com.rays.bysetter;

import com.rays.autowire.UserDAOInt;

public class UserServiceBySetter {
	
	private UserDAOInt userDao;
	
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
		
	}
	
	public void testAdd() {
		userDao.add();
	}

}
