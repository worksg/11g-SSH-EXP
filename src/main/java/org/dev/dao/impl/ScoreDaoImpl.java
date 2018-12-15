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
public class ScoreDaoImpl extends BaseDaoImpl<Score, String> implements ScoreDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(String sno, String cno) {
		this.getSession().createQuery("delete Score where sno=?0 and cno=?1").setParameter(0, sno).setParameter(1, cno)
				.executeUpdate();
	}

	@Override
	public Score get(String sno, String cno) {
		return (Score) this.getSession().createQuery("from Score where sno=?0 and cno=?1").setParameter(0, sno)
				.setParameter(1, cno).uniqueResult();
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public Score get(String id) {
		return null;
	}
}
