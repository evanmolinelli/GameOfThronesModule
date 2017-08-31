package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.*;
import com.revature.data.HouseDAO;
import com.revature.data.LocationDAO;
import com.revature.data.UserDAO;


public class HouseDAOTest {
	
	private static ApplicationContext context; 
	private static HouseDAO houseDAO;
	private static LocationDAO locationDAO;
	private static UserDAO userDAO; 
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml"); //classpath will find anything ending in beans.xml
		System.out.println("Before context.getBean");
		houseDAO = context.getBean(HouseDAO.class);
		locationDAO = context.getBean(LocationDAO.class);
		userDAO = context.getBean(UserDAO.class); 
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testCreate() {

		Location loc = locationDAO.findAll().get(4);
		User user = userDAO.findOne(50); 
	
		House bean = new House();
		bean.setHouseName("Poop");
		bean.setLordOfHouse("King Poop");
		bean.setNumberOfMembers(1);
		bean.setLocation(loc);
		bean.setUser(user); 
		System.out.println(bean.toString());
		houseDAO.create(bean);

		System.out.println("Created");
		
	}
	
	@Test
	@Transactional
	@Ignore //lazy loading error ?
	public void testFindOne(){
		
		houseDAO.findOne(200);
		System.out.println("returned: " + houseDAO.findOne(200).toString());
		
	}

}
