package com.revature.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.*;
import com.revature.beans.Character;
import com.revature.beans.House;
import com.revature.data.HouseDAO;
import com.revature.data.LocationDao;


public class HouseDAOTest {
	
	private static ApplicationContext context; 
	private static HouseDAO houseDAO;
	private static LocationDao locationDAO;
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml"); //classpath will find anything ending in beans.xml
		System.out.println("Before context.getBean");
		houseDAO = context.getBean(HouseDAO.class);
		locationDAO = context.getBean(LocationDao.class);
		
	}
	
	@Test
	@Transactional
	public void testCreate() {
		Character character = new Character("Jon", "Snow", "male", 58, "King of the North");
		HashSet<Character>chars = new HashSet<Character>();
		Location loc = locationDAO.findAll().get(0);
		chars.add(character);
		House bean = new House();  
		bean.setHouseId(2);
		bean.setHouseName("Dorn");
		bean.setHouseSigil("Snake");
		bean.setLordOfHouse("Oberyn Martell");
		bean.setNumberOfMembers(400);
		bean.setCharacter(null);
		bean.setLocation(loc);
		System.out.println(bean.toString());
		houseDAO.create(bean);
//		ComponentA compA = (ComponentA) context.getBean(ComponentA.class);
//		compA.create(bean);
		System.out.println("Created");
		
	}

}
