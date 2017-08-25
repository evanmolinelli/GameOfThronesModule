package com.revature.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD:ManyFacedProject/src/main/test/com/revature/test/HouseDAOTest.java
import com.revature.beans.*;
import com.revature.beans.Character;
=======
import com.revature.beans.House;
>>>>>>> 93c5e93306cdc126129c6f570a2c4da8e2bd2392:ManyFacedProject/src/main/test/com/revature/test/PoopDAOTest.java
import com.revature.data.HouseDAO;


public class PoopDAOTest {
	
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
		
<<<<<<< HEAD:ManyFacedProject/src/main/test/com/revature/test/HouseDAOTest.java
		
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
=======
		HouseDAO bean = context.getBean(HouseDAO.class);
		
		
		House b = new House(); 
		System.out.println(bean.toString()); 
		b.setHouseId(1);
		b.setHouseName("Winterfell");
		b.setHouseSigil("wolf");
		b.setLordOfHouse("Ned stark ");
		b.setNumberOfMembers(10);
		
		bean.create(b);
		

>>>>>>> 93c5e93306cdc126129c6f570a2c4da8e2bd2392:ManyFacedProject/src/main/test/com/revature/test/PoopDAOTest.java
		System.out.println("Created");
		
	}

}
