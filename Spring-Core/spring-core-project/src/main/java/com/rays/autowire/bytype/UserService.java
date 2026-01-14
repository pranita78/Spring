package com.rays.autowire.bytype;

import com.rays.autowire.bynotype.UserDAOInt;

public class UserService {
	
	private UserDAOInt userDao;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}
	
	public void testAdd() {
		userDao.add();
		
	}

}
