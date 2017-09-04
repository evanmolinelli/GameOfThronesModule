package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Character;
import com.revature.beans.Sigil;

public class SigilDAO {

	private SessionFactory sessionFactory; 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(Sigil sigil) {
		//opens a session, beings transaction 
		sessionFactory.getCurrentSession().save(sigil); 
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Sigil sigil) {
		sessionFactory.getCurrentSession().saveOrUpdate(sigil);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Sigil sigil) {
		sessionFactory.getCurrentSession().delete(sigil);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Sigil> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Sigil.class).list(); 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Sigil findOne(int id) {
		return (Sigil) sessionFactory.getCurrentSession().createCriteria(Sigil.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}
}
