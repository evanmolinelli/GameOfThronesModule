package com.revature.test;

import java.util.List;

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
	@Transactional
	public void testCreate() {

		Location loc = locationDAO.findAll().get(4);
		User user = userDAO.findOne(50); 
	
		House bean = new House();
		bean.setHouseName("HOUSE ALVIN");
		bean.setLordOfHouse("King ALVIN");
		bean.setNumberOfMembers(999999);
		bean.setLocation(loc);
		bean.setUser(user); 
		System.out.println(bean.toString());
		houseDAO.create(bean);

		System.out.println("Created");
		
	}
	
	@Test
	@Ignore
	@Transactional//lazy loading error ?
	public void testFindOne(){
		
		List<House> houses =  houseDAO.findAll();
		System.out.println("size" + houses.size());
		for (House h : houses)
		{
			System.out.println("returned: " + h.toString());
		}

		
	}
	
	@Test
	@Ignore
	public void testfindAll() {
		houseDAO.findAll();
		System.out.println("returned " + houseDAO.findAll());
	}

}
