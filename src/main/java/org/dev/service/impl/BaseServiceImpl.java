package org.dev.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.dev.dao.BaseDao;
import org.dev.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	protected BaseDao<T,ID> baseDao;
	private Class<T> entityClass;
	
	public BaseServiceImpl() {
		Class clazz = getClass();
		Type type = clazz.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)type;
			entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		System.out.println("entityClass: "+entityClass);
	}
	
	public void setBaseDao(BaseDao<T,ID> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void delete(ID id) {
		baseDao.delete(id);
	}	

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public T get(ID id) {
		return baseDao.get(id);
	}

	@Override
	public List<T> getAll(Class<T> entity) {
		return baseDao.getAll(entity);
	}

	@Override
	public List<T> findByHql(String hql, Object... values) {
		return baseDao.findByHql(hql, values);
	}
}
