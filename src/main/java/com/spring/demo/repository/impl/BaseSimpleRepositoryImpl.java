package com.spring.demo.repository.impl;


import com.spring.demo.dao.BaseDaoTools;
import com.spring.demo.dao.impl.BaseDaoToolsImpl;
import com.spring.demo.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseSimpleRepositoryImpl<T, id extends Serializable> extends SimpleJpaRepository<T, id> implements BaseRepository<T, id> {

    protected EntityManager entityManager;
    
    private BaseDaoTools baseDaoTools = null;
    
    public BaseSimpleRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
            EntityManager entityManager) {
        super(entityInformation, entityManager);
        // TODO Auto-generated constructor stub
        
        this.entityManager = entityManager;
        this.baseDaoTools = new BaseDaoToolsImpl(entityManager);
        
    }

    public BaseSimpleRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public BaseDaoTools baseDaoTools() {
        // TODO Auto-generated method stub
        return this.baseDaoTools;
    }
}
