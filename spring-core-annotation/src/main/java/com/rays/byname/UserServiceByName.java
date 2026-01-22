package com.rays.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rays.autowire.UserDAOInt;

@Service
public class UserServiceByName {
	
	@Autowired
	 
	
	private UserDAOInt userDao;
	
  public void testAdd() {
	  userDao.add();
  }

}
