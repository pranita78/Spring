package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
 public class UserDAOJDBCImp implements UserDAOInt{
	
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource = null;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	public long add(UserDTO dto) {
     String sql = "insert into st_user values(?, ?, ?, ?, ?)";
     int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}



	public void delete(int id) {
		String sql = "delete from st_user where id = ?";
		
		int i = jdbcTemplate.update(sql, id);
		
		System.out.println("record deleted:" + i);
		
	}

	public void update(UserDTO dto) {
			String sql =  "update st_user set first_name=?, last_name=?, login=?, password=? where id=?";

			int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
					dto.getId());

			System.out.println("record updated successfully: " + i);

	}
	
	public List search() {
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		List list = jdbcTemplate.query(sql.toString(), new UserMapper());

		return list;
	}
	
	public UserDTO findByLogin(String login) {
		try {
			String sql = "select * from st_user where login = ?";

			Object[] params = { login };
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public UserDTO authenticate(String login, String password) {
		try {
	
			 String sql = "select id, first_name, last_name, login, password "
	                   + "from st_user where login = ? and password = ?";


			Object[] params = { login, password };
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	 
	}

}

	 


	 