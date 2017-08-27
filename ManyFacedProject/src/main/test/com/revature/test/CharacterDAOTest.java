package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.CharacterDAO;
import com.revature.data.HouseDAO;
import com.revature.data.StatusDao;
import com.revature.beans.Character;
import com.revature.beans.House;
import com.revature.beans.Status;

public class CharacterDAOTest {
	
	private static ApplicationContext context; 
	private static CharacterDAO characterDAO; 
	private static StatusDao statusDAO;
	private static HouseDAO houseDAO; 
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml");
		System.out.println("Before context.getBean"); 
		characterDAO= context.getBean(CharacterDAO.class); 
		statusDAO = context.getBean(StatusDao.class);
		houseDAO = context.getBean(HouseDAO.class);
	}
	
	@Test
	@Transactional
	
	public void testCreate() {
		
		Status status = statusDAO.findAll().get(0); 
		House house = houseDAO.findAll().get(0); 
		
		Character bean = new Character(); 
		bean.setId(1);
		bean.setFirstName("Arya");
		bean.setLastName("Stark");
		bean.setGender("Female");
		bean.setHeight(120);
		bean.setAlias("Baby-Face Assassin");
		bean.setStatus(status); 
		bean.setHouse(house);
		System.out.println(bean.toString());
		
		characterDAO.create(bean);
	
		System.out.println("Created");
		
	}
}
