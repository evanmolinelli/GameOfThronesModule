package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.House;


@Repository
@Transactional

public class HouseDAO {
	
	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(House house) {
		//opens a session, beings transaction 
		System.out.println("poop");
		sessionFactory.getCurrentSession().save(house); 
		System.out.println("Created"); 
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(House house) {
		sessionFactory.getCurrentSession().saveOrUpdate(house);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(House house) {
		sessionFactory.getCurrentSession().delete(house);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<House> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(House.class).list(); 
	}

}
