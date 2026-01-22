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
public class TestUserService  {
	
	@Autowired
	public UserServiceInt service = null;
	private Object test;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		TestUserService test = (TestUserService) context.getBean(("testUserService"));
		
	//	test.testAdd();
	//	test.testUpdate();
	//   test.testFindPK();
	//	test.testDelete();
	//	test.testFindPK();
	//	test.testFindByLogin();
	//	test.testSearch();
		test.testAuthenticate();
 
	}

	private void testAdd() {
		 UserDTO dto = new UserDTO();
		 dto.setFirstName("Merra");
		 dto.setLastName("jain");
		 dto.setLogin("merra@gmail.com");
		 dto.setPassword("Pass123");
		 long pk = service.add(dto);
		 System.out.println("PK----> " + pk);
	}
	
	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("shree");
		dto.setLastName("Yadav");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		service.update(dto);	
	}

	private void testFindPK() {
		UserDTO dto = service.findByPk(2);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
		
	}

	private void testDelete() {
	 service.delete(5);
		
	}
	 
	private void testFindByLogin() {
		UserDTO dto = new UserDTO();
		dto = service.findByLogin("shyam@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");
}
		
	}
		private void testSearch() {
			
			UserDTO dto = new UserDTO();
			dto.setFirstName("a");
			int pageNo = 1;
			int pageSize = 5;
			List<UserDTO> list = service.search(dto, pageNo, pageSize);

			Iterator<UserDTO> it = list.iterator();
			while (it.hasNext()) {
				dto = it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getFirstName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getLogin());
				System.out.println(dto.getPassword());
		}
		}

		private void testAuthenticate() {
			UserDTO dto = service.authenticate("pari@gmail.com", "Pass@123");
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
	}
}