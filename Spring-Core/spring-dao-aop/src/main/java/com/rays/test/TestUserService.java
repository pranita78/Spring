package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {
	
	public static ApplicationContext context = null;
	
	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");
    
		//test.testAdd();
		//test.testUpdate();
		//test.testFindByPk();
		//test.testDelete();
		//test.testFindByLogin();
		test.authenticate();
	//	test.testSearch();
		
	}
	private void testAdd() {UserDTO dto = new UserDTO();
	dto.setId(1);
	dto.setFirstName("ABC");
	dto.setLastName("ABC");
	dto.setLogin("ABC@gmail.com");
	dto.setPassword("pass1234");
	long pk = service.add(dto);
	System.out.println("PK->" + pk);// TODO Auto-generated method stub
		
	}
	
	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Diya");
		dto.setLastName("sharma");
		dto.setLogin("diya@gmail.com");
		dto.setPassword("pass1234");
		service.update(dto);
		System.out.println("Record updated");
		
	}

    private void testFindByPk() {
	UserDTO dto = service.findByPK(1);
	System.out.print(dto.getId());
	System.out.print("\t" + dto.getFirstName());
	System.out.print("\t" + dto.getLastName());
	System.out.print("\t" + dto.getLogin());
	System.out.println("\t" + dto.getPassword());
 }

       private void testDelete() {
    			service.delete(11);
	 
       }

   	private void testFindByLogin() {
   		UserDTO dto = new UserDTO();
		dto = service.findByLogin("navya@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");}
     }

private void authenticate() {
	UserDTO dto = service.authenticate("kavya@gmail.com", "Pass@123");
	System.out.println(dto.getId());
	System.out.println(dto.getFirstName());
	System.out.println(dto.getLastName());
	System.out.println(dto.getLogin());
	System.out.println(dto.getPassword());
}
private void testSearch() {
	UserDTO dto = new UserDTO();
	dto.setFirstName("a");
	int pageNo = 1;
	int pageSize = 5;
	List<UserDTO> list = service.search(dto, pageNo, pageSize);
    }
}
