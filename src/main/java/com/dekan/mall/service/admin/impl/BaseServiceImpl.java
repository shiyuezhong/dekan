package com.dekan.mall.service.admin.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.dekan.mall.service.admin.intf.BaseService;
import com.dekan.mall.ws.intf.BaseWs;

/**
 * @ClassName BaseServiceImpl
 * @Description TODO【Base Service层接口实现】
 * @Author Shiyz
 * @Date 2013-10-18 下午4:55:30
 */
public class BaseServiceImpl<T,PK extends Serializable> implements BaseService<T, PK> {
	
	private BaseWs<T,PK> baseWs;
	
	public BaseWs<T, PK> getBaseWs() {
		return baseWs;
	}

	public void setBaseWs(BaseWs<T, PK> baseWs) {
		this.baseWs = baseWs;
	}
	
	@Override
	public T find(PK id) {
		return baseWs.find(id);
	}

	@Override
	public void insert(T entity) {
		baseWs.insert(entity);
	}

	@Override
	public void update(T entity) {
		baseWs.update(entity);
	}

	@Override
	public void delete(T entity) {
		baseWs.delete(entity);
	}

	@Override
	public void delete(PK id) {
		baseWs.delete(id);
	}
	
	@Override
	public Long getTotalCount() {
		return baseWs.getTotalCount();
	}

	@Override
	public List<T> findAllList() {
		return baseWs.findAllList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findListBy(HashMap values) {
		return baseWs.findListBy(values);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getCountBy(HashMap values) {
		return baseWs.getCountBy(values);
	}

	@Override
	public T save(T entity) {
		return baseWs.save(entity);
	}

}
