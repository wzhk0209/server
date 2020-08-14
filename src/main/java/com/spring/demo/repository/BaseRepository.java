package com.spring.demo.repository;

import com.spring.demo.dao.BaseDaoTools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, id extends Serializable> extends JpaRepository<T, id>{
    BaseDaoTools baseDaoTools();
}
