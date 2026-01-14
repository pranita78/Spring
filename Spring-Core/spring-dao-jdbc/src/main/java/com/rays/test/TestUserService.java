package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")

public class TestUserService {
	
	@Autowired
	public UserServiceInt service = null;
	
	public static void main(String[] args)throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
		TestUserService test = (TestUserService) context.getBean("testUserService");
	
//	 	test.testAdd();
//		test.testDelete();
//		test.tesUpdate();
//		test.testSearch();
//        test.testfindByLogin();		
        test.testAuthenticate();
	}

 
 


	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(11);
		dto.setFirstName("kavya");
		dto.setLastName("gayakwad");
		dto.setLogin("kavya@gmail.com");
		dto.setPassword("pass123");
		long pk = service.add(dto);
		
		System.out.println("Data Added sucessfully");
		
	}
	
	private void testDelete() {
		service.delete(2);
	}	
	
		private void tesUpdate() {
			UserDTO dto = new UserDTO();
			dto.setId(1);
			dto.setFirstName("Ram");
			dto.setLastName("Sharma");
			dto.setLogin("ram@gmail.com");
			dto.setPassword("ram123");
			service.update(dto);
			 
			}
		private void testSearch() {
			List list = service.search();
			 
			 Iterator<UserDTO> it = list.iterator();
			 while (it.hasNext());
			 
			 UserDTO dto = it.next();
			 
			 System.out.println(dto.getId());
             System.out.println(dto.getLastName());
             System.out.println(dto.getLastName());
             System.out.println(dto.getLogin());
             System.out.println(dto.getPassword());
		}
		
		 

		private void testfindByLogin() {
			UserDTO dto = service.findByLogin("admin");
			if (dto != null) {
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFirstName());
				System.out.print("\t" + dto.getLastName());
				System.out.print("\t" + dto.getLogin());
				System.out.println("\t" + dto.getPassword());
			} else {
				System.out.println("User not exist..!!!");
		}
			
		}
			private void testAuthenticate() {
				UserDTO dto = service.authenticate("admin", "pass1234sfsf");
				if (dto != null) {
					System.out.print(dto.getId());
					System.out.print("\t" + dto.getFirstName());
					System.out.print("\t" + dto.getLastName());
					System.out.print("\t" + dto.getLogin());
					System.out.println("\t" + dto.getPassword());
				} else {
					System.out.println("invalid login id or password");
				}
				
			}


				
	}

	
