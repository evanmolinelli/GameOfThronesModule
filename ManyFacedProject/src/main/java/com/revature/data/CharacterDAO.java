package com.revature.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Character;

public class CharacterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(Character character) {
		//opens a session, beings transaction
		sessionFactory.getCurrentSession().save(character);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(Character character) {
		sessionFactory.getCurrentSession().saveOrUpdate(character);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Character character) {
		sessionFactory.getCurrentSession().delete(character);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Character> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Character.class).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Character findOne(int id) {
		return (Character) sessionFactory.getCurrentSession().createCriteria(Character.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
//				.list().get(1);
	}

}
