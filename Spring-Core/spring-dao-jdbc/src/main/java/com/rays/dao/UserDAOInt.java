package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {
	
	public long add(UserDTO dto); 
	
	public void delete(int id);		
	
	public void update(UserDTO dto);
	
	public List search();
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login, String password);

	 
	

}
