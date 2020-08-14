package com.spring.demo.repository;

import com.spring.demo.repository.impl.BaseSimpleRepositoryImpl;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;

public class BaseRepositoryFactory extends JpaRepositoryFactory {

    public BaseRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        // TODO Auto-generated method stub
//        return super.getRepositoryBaseClass(metadata);
        return BaseSimpleRepositoryImpl.class;
    }
}
