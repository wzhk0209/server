package com.spring.demo.dao.impl;

import com.spring.demo.dao.BaseDaoTools;
import com.spring.demo.dto.PageEntity;
import com.spring.demo.utils.BaseUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author taotao
 *
 */

@Repository("baseDaoTools")
public class BaseDaoToolsImpl implements BaseDaoTools {
    
    @Resource
    private EntityManager entityManager;
    
    
    public BaseDaoToolsImpl(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }
    public BaseDaoToolsImpl() {
        super();
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findBySQL(String sql, Class<T> clazz, Object... params) {
        // TODO Auto-generated method stub
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, clazz, params);
        return sqlQuery.getResultList();
    }
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findBySQLPage(String sql, Class<T> clazz, int pageNum, int pageSize, Object... params) {
        // TODO Auto-generated method stub
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, clazz, pageNum, pageSize, params);
        return sqlQuery.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T findOneBySql(String sql, Class<T> clazz, Object... params){
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, clazz, params);
        return (T) sqlQuery.getResultStream().findFirst().orElse(null);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T findValueBySql(String sql, Object... params){
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, params);
        return (T) sqlQuery.getResultStream().findFirst().orElse(null);
    }
    
    @Override
    public <T> PageEntity<T> findPageBySql(String sql, Class<T> clazz, int pageNum, int pageSize, Object... params){
        PageEntity<T> page = new PageEntity<T>();
        Number count = countBySql(sql, params);
        List<T> datas = findBySQLPage(sql, clazz, pageNum, pageSize, params);
        page.setCount(count.longValue());
        page.setDatas(datas);
        return page;
        
    }

    @Override
    public Integer executeUpdate(String sql, Object... params) {
        // TODO Auto-generated method stub
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, params);
        return sqlQuery.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByHql(String queryString, Object... params){
        Query query = BaseUtils.getQuery(entityManager, queryString, params);
        return (List<T>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T findOneByHql(String queryString, Object... params){
        Query query = BaseUtils.getQuery(entityManager, queryString, params);
        return (T) query.getResultStream().findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> findMapBySql(String sql, Object... params) {
        // TODO Auto-generated method stub
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, params);
        sqlQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return sqlQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> findOneMapBySql(String sql, Object... params) {
        // TODO Auto-generated method stub
        Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, params);
        sqlQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return (Map<String, Object>) sqlQuery.getResultStream().findFirst().orElse(null);
    }

    @Override
    public PageEntity<Map<String, Object>> findMapPageBySql(String sql, int pageNum, int pageSize,
            Object... params) {
        // TODO Auto-generated method stub
        PageEntity<Map<String, Object>> page = new PageEntity<Map<String, Object>>();
        Number count = countBySql(sql, params);
        List<Map<String, Object>> datas = findMapBySqlPage(sql, pageNum, pageSize, params);
        page.setCount(count.longValue());
        page.setDatas(datas);
        return page;
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<Map<String, Object>> findMapBySqlPage(String sql, int pageNum,
            int pageSize, Object... params) {
        // TODO Auto-generated method stub
	    Query sqlQuery = BaseUtils.getSqlQuery(entityManager, sql, pageNum, pageSize, params);
	    sqlQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return sqlQuery.getResultList();
    }
	
	@SuppressWarnings("unchecked")
    @Override
	public <T> List<T> findByHqlPage(String hql, int pageNum, int pageSize, Object... params) {
	    // TODO Auto-generated method stub
	    Query query = BaseUtils.getQuery(entityManager, hql, params);
	    query.setFirstResult(--pageNum * pageSize);
	    query.setMaxResults(pageSize);
	    return (List<T>) query.getResultList();
	}

    @Override
	public Integer executeHqlUpdate(String hql, Object... params) {
		// TODO Auto-generated method stub
		Query query = BaseUtils.getQuery(entityManager, hql, params);
		
		return query.executeUpdate();
	}
    @Override
    public <T> T getEntity(Class<T> clazz, Serializable id) {
        // TODO Auto-generated method stub
        return (T) entityManager.unwrap(Session.class).get(clazz, id);
    }
    @Override
    public Serializable saveEntity(Object obj) {
        // TODO Auto-generated method stub
        return entityManager.unwrap(Session.class).save(obj);
    }
    @Override
    public void deleteEntity(Object obj) {
        // TODO Auto-generated method stub
        entityManager.unwrap(Session.class).delete(obj);
    }
    @Override
    public void saveOrUpdateEntity(Object obj) {
        // TODO Auto-generated method stub
        entityManager.unwrap(Session.class).saveOrUpdate(obj);
    }
    @Override
    public void updateEntity(Object obj) {
        // TODO Auto-generated method stub
        entityManager.unwrap(Session.class).update(obj);
    }
    @Override
    public <T> PageEntity<T> findPageByHql(String hql, int pageNum, int pageSize, Object... params) {
        // TODO Auto-generated method stub
        PageEntity<T> page = new PageEntity<T>();
        int count = countByHql(hql, params);
        List<T> list = findByHqlPage(hql, pageNum, pageSize, params);
        page.setCount(count);
        page.setDatas(list);
        return page;
    }
    @Override
    public int countBySql(String sql, Object... params) {
        // TODO Auto-generated method stub
        Number count = findValueBySql("select count(*) from ("+sql+" )tab", params);
        return count.intValue();
    }
    @Override
    public int countByHql(String hql, Object... params) {
        // TODO Auto-generated method stub
    	
        String queryString = "select count(*) " + hql.substring( StringUtils.indexOfIgnoreCase(hql, "FROM"));
        
        if(StringUtils.containsIgnoreCase(hql, "ORDER BY")){
        	
            queryString = queryString.substring(0, StringUtils.indexOfIgnoreCase(queryString, "ORDER BY"));
        }
        
        Number count = findOneByHql(queryString, params);
        
        return count.intValue();
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	@Override
	public <T> T merge(T t) {
		// TODO Auto-generated method stub
		return  (T) entityManager.merge(t);
	}
    
}
