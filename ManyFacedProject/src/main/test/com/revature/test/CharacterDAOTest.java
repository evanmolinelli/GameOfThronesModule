package com.revature.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.data.CharacterDAO;
import com.revature.beans.Character;

public class CharacterDAOTest {
	
	private static ApplicationContext context; 
	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("classpath*:dao-beans.xml");
		System.out.println("Before context.getBean"); 
	}
	
	@Test
	public void testCreate() {
		
		CharacterDAO bean = context.getBean(CharacterDAO.class);
		Character c = new Character(); 
		
		c.setId(1);
		c.setFirstName("Arya");
		c.setLastName("Stark");
		c.setGender("Female");
		c.setAlias("Baby-Face Assassin");
		c.setHeight(120);
		
		bean.create(c);
	
		
	}
	
	public static void main(String[] args) {
		System.out.println(System.getenv("DB_URL"));
	}
	

}
