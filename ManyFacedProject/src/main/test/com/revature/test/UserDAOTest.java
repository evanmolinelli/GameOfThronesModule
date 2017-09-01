package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;
import com.revature.data.UserDAO;

public class UserDAOTest {
	
	private static ApplicationContext context; 
	private static UserDAO userDAO;
	
	@BeforeClass 
	public static void initialize() {
		context =new ClassPathXmlApplicationContext("classpath*:dao-beans.xml");
		System.out.println("Before context.getBean"); 
		userDAO = context.getBean(UserDAO.class); 
	}
	
	@Test
	@Ignore
	public void testCreate() {
		
		User bean = new User(); 
		bean.setId(1);
		bean.setUsername("Evan");
		bean.setPassword("poop");
		
		System.out.println("User created");
		
		userDAO.create(bean); 
		
		System.out.println("Username created"); 
	}

	@Test 
	@Ignore
	public void testFindAll() {
		userDAO.findAll(); 
		System.out.println("returned: " + userDAO.findAll()); 
	}
	
	@Test 
	@Ignore
	public void testFindOne() {
		userDAO.findOne(50);
		System.out.println("returned" + (User) userDAO.findOne(50)); 
	}
	
	@Test 
	public void testUsername() {
		userDAO.getUsername("Evan"); 
		System.out.println(userDAO.getUsername("Evan"));
		System.out.println("returned " +  userDAO.getUsername("Evan").getUsername()); 
		System.out.println("password" + userDAO.getUsername("Evan").getPassword());
		
	}
	
}
