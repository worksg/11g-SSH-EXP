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
public class UsersDaoImpl extends BaseDaoImpl<Student, String> implements UsersDao {
	
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void delete(String sno) {
		this.getSession().createQuery("delete student where sno=?0").setParameter(0, sno).executeUpdate();
	}

	@Override
	public Student get(String sno) {
		return (Student) this.getSession().createQuery("from student where sno=?0").setParameter(0, sno).uniqueResult();
	}
    
}
