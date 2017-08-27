package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Character;
import com.revature.beans.Location;

public class LocationDAO {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	
	@Transactional
	public Location findLocation(int id) {
		return (Location) sessionFactory.getCurrentSession()
				.createCriteria(Location.class); 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Location> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Location.class).list(); 
	}
}
