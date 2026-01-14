package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestPerson {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	    Person p1 = (Person)context.getBean("person");
	    
	    p1.setName("Pranita");
	    p1.setAddress("Mumbai");
	    
	    System.out.println(p1.getName());
	    System.out.println(p1.getAddress());
	    
	    
	}
	

}
