package com.spring.demo.dao;


import com.spring.demo.dto.PageEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基于hibernate的基本数据库查询方法
 * @author ZhaoChengtao
 *
 */
public interface BaseDaoTools {

    /**
     * sql查询list
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    <T> List<T> findBySQL(String sql, Class<T> clazz, Object... params);

    /**
     * sql分页查询list
     * @param sql
     * @param clazz
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    <T> List<T> findBySQLPage(String sql, Class<T> clazz, int pageNum, int pageSize, Object... params);
    
    /**
     * sql查询单条记录
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    <T> T findOneBySql(String sql, Class<T> clazz, Object... params);

    /**
     * sql查询单个值
     * @param sql
     * @param params
     * @return
     */
    <T> T findValueBySql(String sql, Object... params);
    
    /**
     * 查询某条sql的记录总数，不需要写count函数
     * @param sql
     * @param params
     * @return
     */
    int countBySql(String sql, Object... params);
    
    /**
     * sql查询list和记录数，返回page对象
     * @param sql
     * @param clazz
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    <T> PageEntity<T> findPageBySql(String sql, Class<T> clazz, int pageNum, int pageSize, Object... params);
    
    /**
     * sql查询list
     * @param sql
     * @param params
     * @return
     */
    List<Map<String, Object>> findMapBySql(String sql, Object... params);
    
    /**
     * sql分页查询
     * @param sql
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    List<Map<String, Object>> findMapBySqlPage(String sql, int pageNum, int pageSize, Object... params);
    
    /**
     * sql查询单条记录
     * @param sql
     * @param params
     * @return
     */
    Map<String, Object> findOneMapBySql(String sql, Object... params);
    
    /**
     * sql查询list和记录数
     * @param sql
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    PageEntity<Map<String, Object>> findMapPageBySql(String sql, int pageNum, int pageSize, Object... params);
    
    /**
     * hql查询list
     * @param queryString
     * @param params
     * @return
     */
    <T> List<T> findByHql(String queryString, Object... params);
    
    /**
     * hql分页查询
     * @param hql
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    <T> List<T> findByHqlPage(String hql, int pageNum, int pageSize, Object... params);
    
    /**
     * hql查询单条记录
     * @param queryString
     * @param params
     * @return
     */
    <T> T findOneByHql(String queryString, Object... params);
    
    /**
     * 获取某条hql查询语句的总条数（目前支持大部分hql）
     * @param hql
     * @param params
     * @return
     */
    int countByHql(String hql, Object... params);
    
    /**
     * hql查询list和记录数，返回page对象（目前支持大部分hql）
     * @param hql
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    <T> PageEntity<T> findPageByHql(String hql, int pageNum, int pageSize, Object... params);
    
    /**
     * sql更新
     * @param sql
     * @param params
     * @return
     */
    Integer executeUpdate(String sql, Object... params);
    
    /**
     * hql更新
     * @param hql
     * @param params
     * @return
     */
    Integer executeHqlUpdate(String hql, Object... params);
    
    /**
     * 查询对象
     * @param clazz
     * @param id
     * @return
     */
    <T> T getEntity(Class<T> clazz, Serializable id);
    
    /**
     * 保存对象
     * @param obj
     * @return
     */
    Serializable saveEntity(Object obj);
    
    /**
     * 删除对象
     * @param obj
     */
    void deleteEntity(Object obj);
    
    /**
     * 保存或更新对象
     * @param obj
     */
    void saveOrUpdateEntity(Object obj);
    
    /**
     * 更新对象
     * @param obj
     */
    void updateEntity(Object obj);

    /**
     * @param t
     * @return
     */
	<T> T merge(T t);
    
}
