package com.spring.demo.utils;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseUtils {
    

    protected static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    protected static Pattern queryPattern = Pattern.compile("\\?(?!\\d)");
    protected static Pattern paramPattern = Pattern.compile(":\\w+");

	@SuppressWarnings("unchecked")
    private static void setQueryParameters(Query q, Object[] params) {
	    // TODO Auto-generated method stub
		
	    org.hibernate.query.Query<Object> query = q.unwrap(org.hibernate.query.Query.class);
	    
	    Pattern p = Pattern.compile(":\\w+");
        Matcher matcher = p.matcher(query.getQueryString());
        
        Set<String> keys = new HashSet<>();
        
        while (matcher.find()){
        	
        	String key = matcher.group().substring(1);
        	
        	if(keys.contains(key)) {
        		continue;
        	}
        	
        	q.setParameter(key, params[keys.size()]);
            keys.add(key);
        }
        
        if(CollectionUtils.isEmpty(keys) && null != params){
        	
            for(int i = 0; i< params.length; i++){
            	
                q.setParameter(i, params[i]);
            }
        }
        
	}

	public static Query getQuery(EntityManager entityManager,
			String queryString, Object[] params) {
		// TODO Auto-generated method stub
	    
	    queryString = parseQueryStr(queryString);
	    
		Query query = entityManager.createQuery(queryString);
		setQueryParameters(query, params);
		return query;
	}

    public static <T> Query getSqlQuery(EntityManager entityManager,
	        String sql, Object[] params) {
	    // TODO Auto-generated method stub
        
        sql = parseQueryStr(sql);
        
	    Query query = entityManager.createNativeQuery(sql);
	    setQueryParameters(query, params);
	    return query;
	}
    /**
     * 兼容hibernate 5.3以前版本
     * @param queryString
     * @return
     */
    private static String parseQueryStr(String queryString) {
        // TODO Auto-generated method stub
        Matcher matcher = queryPattern.matcher(queryString);
        int i = 0;
        while(matcher.find()) {
            queryString = matcher.replaceFirst(String.format("?%d", i++));
            matcher.reset(queryString);
        }
        return queryString;
    }
	
    public static <T> Query getSqlQuery(EntityManager entityManager,
	        String sql, Class<T> clazz, Object[] params) {
	    // TODO Auto-generated method stub
	    Query query = getSqlQuery(entityManager, sql, params);
	    query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz));
	    return query;
	}
	
	public static <T> Query getSqlQuery(EntityManager entityManager,
	        String sql, Class<T> clazz, int pageNum, int pageSize, Object[] params) {
	    // TODO Auto-generated method stub
	    Query sqlQuery = getSqlQuery(entityManager, sql, pageNum, pageSize, params);
	    sqlQuery.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz));
	    return sqlQuery;
	}
	
	public static Query getSqlQuery(EntityManager entityManager,
	        String sql, int pageNum, int pageSize, Object[] params) {
	    // TODO Auto-generated method stub
	    Query sqlQuery = getSqlQuery(entityManager, sql, params);
	    sqlQuery.setFirstResult((pageNum - 1) * pageSize);
	    sqlQuery.setMaxResults(pageSize);
	    return sqlQuery;
	}

	public static String randomUUID() {
	    // TODO Auto-generated method stub
	    return UUID.randomUUID().toString().replaceAll("-", "");
	}

    
    public static Timestamp currentTimestamp() {
        // TODO Auto-generated method stub
        return new Timestamp(System.currentTimeMillis());
    }
    

}
