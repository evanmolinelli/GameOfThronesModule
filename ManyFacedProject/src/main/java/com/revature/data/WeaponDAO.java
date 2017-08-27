package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Sigil;
import com.revature.beans.Weapons;

public class WeaponDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(Weapons weapons) {
		//opens a session, beings transaction 
		sessionFactory.getCurrentSession().save(weapons); 
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Weapons weapons) {
		sessionFactory.getCurrentSession().saveOrUpdate(weapons);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Weapons weapons) {
		sessionFactory.getCurrentSession().delete(weapons);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Weapons> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Weapons.class).list(); 
	}
}
