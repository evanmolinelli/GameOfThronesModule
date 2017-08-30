package com.revature.test;

import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.*;
import com.revature.beans.Character;
import com.revature.beans.House;
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
		
	}
	
	@Test
	@Transactional
	public void testCreate() {
		Character character = new Character("Jon", "Snow", "male", 58, "King of the North");
		HashSet<Character>chars = new HashSet<Character>();
		Location loc = locationDAO.findAll().get(2); 
		User user = new User(50,"Alvin","poop");  //get as object; 
		
		chars.add(character);
		House bean = new House();
		bean.setHouseName("Tully");
		bean.setLordOfHouse("Poop Tully");
		bean.setNumberOfMembers(232);
		bean.setCharacter(null);
		bean.setLocation(loc);
		bean.setUser(user); 
		System.out.println(bean.toString());
		houseDAO.create(bean);
//		ComponentA compA = (ComponentA) context.getBean(ComponentA.class);
//		compA.create(bean);
		System.out.println("Created");
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void testFindOne(){
		
		System.out.println("testFindOne " + houseDAO.findOne(1).toString());
		
	}

}
