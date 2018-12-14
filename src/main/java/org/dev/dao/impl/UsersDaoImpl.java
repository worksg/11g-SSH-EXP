package org.dev.dao.impl;

import org.dev.dao.UsersDao;
import org.dev.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UsersDaoImpl extends BaseDaoImpl<Student, String> implements UsersDao<Student,String> {
	
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void delete(String id) {
		this.getSession().createQuery("delete student where id=?").setParameter(0, id).executeUpdate();
	}

	@Override
	public Student get(String id) {
		return (Student) this.getSession().createQuery("from student where id=?").setParameter(0, id).uniqueResult();
	}
    
}
