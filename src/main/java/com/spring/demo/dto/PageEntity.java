package com.spring.demo.dto;

import java.util.List;

/**
 * 
 * @author ZhaoChengtao
 *
 * @param <T>
 */
public class PageEntity<T> {
	private long count;
	private List<T> datas;
	private Object extData;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Object getExtData() {
		return extData;
	}
	public void setExtData(Object extData) {
		this.extData = extData;
	}
	
}
