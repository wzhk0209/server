package com.spring.demo.dao;

import java.io.Serializable;

public interface BaseDao<T> extends BaseDaoTools {
	T get(Serializable id);
	
	Serializable save(T t);
	
	void saveOrUpdate(T t);
	
	void delete(T t);
	
}
