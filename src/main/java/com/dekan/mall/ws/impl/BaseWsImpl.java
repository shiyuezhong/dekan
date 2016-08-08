package com.dekan.mall.ws.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


import com.dekan.mall.bean.entity.BaseEntity;
import com.dekan.mall.dao.mybatis.intf.BaseDao;
import com.dekan.mall.ws.intf.BaseWs;

/**
 * @ClassName BaseWsImpl
 * @Description TODO【Base WS层接口实现】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
public class BaseWsImpl<T,PK extends Serializable> implements BaseWs<T, PK> {
	
	private BaseDao<T,PK> baseDao;
	
	public BaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public T find(PK id) {
		return baseDao.find(id);
	}

	@Override
	public void insert(T entity) {
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_INSERT_METHOD_NAME);
				method.invoke(entity);
				baseDao.insert(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			baseDao.insert(entity);
		}
	}

	@Override
	public void update(T entity) {
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_UPDATE_METHOD_NAME);
				method.invoke(entity);
				baseDao.update(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			baseDao.update(entity);
		}
	}

	@Override
	public void delete(T entity) {
		if (entity instanceof BaseEntity) {
			try {
				Method method = entity.getClass().getMethod(BaseEntity.ON_DELETE_METHOD_NAME);
				method.invoke(entity);
				baseDao.delete(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			baseDao.delete(entity);
		}
	}
	
	@Override
	public void delete(PK id) {
		baseDao.delete(id);
	}

	@Override
	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	@Override
	public List<T> findAllList() {
		return baseDao.findAllList();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findListBy(HashMap values) {
		return baseDao.findListBy(values);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getCountBy(HashMap values) {
		return baseDao.getCountBy(values);
	}

	@Override
	public T save(T entity) {
		return null;
	}

}
