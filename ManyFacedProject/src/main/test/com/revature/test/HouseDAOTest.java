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
import com.revature.data.HouseDAO;


public class HouseDAOTest {
	
	private static ApplicationContext context; 
	private static HouseDAO houseDAO;
	
	@BeforeClass
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml"); //classpath will find anything ending in beans.xml
		System.out.println("Before context.getBean");
		houseDAO = context.getBean(HouseDAO.class);
		
	}
	
	@Test
	@Transactional
	public void testCreate() {
		
		
		Character character = new Character("Jon", "Snow", "male", 58, "King of the North");
		HashSet<Character>chars = new HashSet<Character>();
		chars.add(character);
		House bean = new House();  
		bean.setHouseId(1);
		bean.setHouseName("Winterfell");
		bean.setHouseSigil("wolf");
		bean.setLordOfHouse("Ned stark");
		bean.setNumberOfMembers(10);
		bean.setCharacter(chars);
		System.out.println(bean.toString());
		houseDAO.create(bean);
//		ComponentA compA = (ComponentA) context.getBean(ComponentA.class);
//		compA.create(bean);
		System.out.println("Created");
		
	}

}
