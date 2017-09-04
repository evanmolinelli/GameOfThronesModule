package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.WeaponDAO;

public class WeaponsDAOTest {
	
	private static ApplicationContext context; 
	private static WeaponDAO weaponDAO;
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml");
		System.out.println("Before context.getBean"); 
		weaponDAO = context.getBean(WeaponDAO.class);
	}
	
	
	@Test
	@Transactional() 
	public void testFindAll() {
		weaponDAO.findAll();
		System.out.println(weaponDAO.findAll().toString()); 
	}
}

