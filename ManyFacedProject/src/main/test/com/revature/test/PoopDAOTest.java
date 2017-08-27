package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.House;
import com.revature.data.HouseDAO;


public class PoopDAOTest {
	
	private static ApplicationContext context; 
	
	
	@BeforeClass
	
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:dao-beans.xml"); //classpath will find anything ending in beans.xml
		System.out.println("Before context.getBean");
		
		
	}
	@Test
	@Transactional
	public void testCreate() {
		
		HouseDAO bean = context.getBean(HouseDAO.class);
		
		
		House b = new House(); 
		System.out.println(bean.toString()); 
		b.setHouseName("Winterfell");
		b.setHouseSigil("Wolf");
		b.setLordOfHouse("Ned stark ");
		b.setNumberOfMembers(10);
		
		bean.create(b);
		

		System.out.println("Created");
		
	}

}
