package org.dev.dao.impl;

import org.dev.dao.CourseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.dev.entity.Course;

@Transactional
@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course, String> implements CourseDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(String cno) {
		this.getSession().createQuery("delete Course where cno=?0").setParameter(0, cno).executeUpdate();
	}

	@Override
	public Course get(String cno) {
		return (Course) this.getSession().createQuery("from Course where cno=?0").setParameter(0, cno).uniqueResult();
	}
}
