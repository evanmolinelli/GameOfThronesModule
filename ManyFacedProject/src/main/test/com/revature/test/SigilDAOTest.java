package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


import com.revature.data.SigilDAO;


public class SigilDAOTest {

	private static ApplicationContext context; 
	private static SigilDAO sigilDAO;
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml");
		System.out.println("Before context.getBean"); 
		sigilDAO = context.getBean(SigilDAO.class);
	}
	
	
	@Test
	@Transactional() 
	public void testFindAll() {
		sigilDAO.findAll();
		System.out.println(sigilDAO.findAll().toString()); 
	}
}
