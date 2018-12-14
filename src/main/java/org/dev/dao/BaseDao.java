package org.dev.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {
	void save(final T t) ;
	void delete(final ID id);
	void update(final T t) ;
	T get(final ID id);
	List<T> getAll(Class<T> entity);
	List<T> findByHql(final String hql, final Object... values);
}
