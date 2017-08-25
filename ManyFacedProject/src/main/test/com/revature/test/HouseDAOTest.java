package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.ComponentA;
import com.revature.beans.House;


public class HouseDAOTest {
	
	private static ApplicationContext context; 
	
	
	@BeforeClass
	
	public static void initialize() {
		context = 
				new ClassPathXmlApplicationContext("classpath*:beans.xml"); //classpath will find anything ending in beans.xml
		System.out.println("Before context.getBean");
		
		
	}
	@Test
	@Transactional
	public void testCreate() {
		
		House bean = new House(); 
		System.out.println(bean.toString()); 
		bean.setHouseId(1);
		bean.setHouseName("Winterfell");
		bean.setHouseSigil("wolf");
		bean.setLordOfHouse("Ned stark ");
		bean.setNumberOfMembers(10);
		
		ComponentA compA = (ComponentA) context.getBean(ComponentA.class);
		compA.create(bean);
		System.out.println("Created");
		
	}

}
