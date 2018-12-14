package org.dev.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dev.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		this.getSession().save(t);
	}

	@Override
	public void update(T t) {
		this.getSession().update(t);
	}

	@Override
	public List<T> getAll(Class<T> entity) {
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entity);
		Root<T> root = query.from(entity);
		query.select(root);
		Query<T> res = this.getSession().createQuery(query);
		return res.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql, Object... values) {
		Query<T>  query = this.getSession().createQuery(hql);
		
		/*获取查询结果的集合*/
		List<T> list = query.list();
		
		if (list != null && list.size() > 0){
			/*如果集合中有值的话，返回集合*/
			return list;
		}
		/*如果没有值的话返回空*/
		return null;
	}
	
}
