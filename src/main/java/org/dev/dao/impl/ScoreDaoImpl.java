package org.dev.dao.impl;

import org.dev.dao.ScoreDao;
import org.dev.entity.Score;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ScoreDaoImpl extends BaseDaoImpl<Score, String> implements ScoreDao<Score, String> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(String id) {
		this.getSession().createQuery("delete score where id=?").setParameter(0, id).executeUpdate();
	}

	@Override
	public Score get(String id) {
		return (Score) this.getSession().createQuery("from score where id=?").setParameter(0, id).uniqueResult();
	}
}
