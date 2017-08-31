package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;

public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(User user) {
		//opens a session, beings transaction
		sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
	}

	@Transactional
	public User findOne(int id) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}


}
