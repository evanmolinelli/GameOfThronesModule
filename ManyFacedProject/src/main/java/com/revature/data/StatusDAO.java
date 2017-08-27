package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Status;

public class StatusDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Status findSigil(int id) {
		return (Status) sessionFactory.getCurrentSession()
				.createCriteria(Status.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Status> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Status.class).list();

	}
	
}
