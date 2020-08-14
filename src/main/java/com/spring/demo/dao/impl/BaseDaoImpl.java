package com.spring.demo.dao.impl;


import com.spring.demo.dao.BaseDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDaoImpl<T> extends BaseDaoToolsImpl implements BaseDao<T> {
    
    protected Class<T> clazz;
    
	@SuppressWarnings("unchecked")
    public BaseDaoImpl() {
	    // TODO Auto-generated constructor stub
	    super();
	    ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
        this.clazz=(Class<T>)type.getActualTypeArguments()[0];
    }

    @Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
        return getEntity(clazz, id);
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
	    saveOrUpdateEntity(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
	    deleteEntity(t);
	}

    @Override
    public Serializable save(T t) {
        // TODO Auto-generated method stub
        return saveEntity(t);
    }
	
}
