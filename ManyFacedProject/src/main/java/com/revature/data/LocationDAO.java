package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Location;
import com.revature.beans.User;

public class LocationDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Location> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Location.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Location findOne(int id) {
		return (Location) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

}
