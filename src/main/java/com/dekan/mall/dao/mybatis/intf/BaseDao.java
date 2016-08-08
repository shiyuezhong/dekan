/**
* @FileName BaseDao.java
* @Package com.rujia.dao.mybatis
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-9-11 上午10:07:50
* @Version V1.0.1
*/
package com.dekan.mall.dao.mybatis.intf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


/**
 * @ClassName BaseDao
 * @Description TODO【Dao层基类】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@SuppressWarnings("rawtypes")
public  interface BaseDao<T,PK extends Serializable>{
	
	/**
	* @Title find
	* @Description TODO【查询实体对象】
	* @param id
	* @return 
	* @Return T 返回类型
	* @Throws 
	*/ 
	public T find(PK id);
	
	/**
	* @Title insert
	* @Description TODO【插入实体对象】
	* @param entity
	* @return 
	* @Return Integer 返回类型
	* @Throws 
	*/ 
	public void insert(T entity);
	
	/**
	* @Title update
	* @Description TODO【更新实体对象】
	* @param entity 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void update(T entity);
	
	/**
	* @Title delete
	* @Description TODO【删除实体对象】
	* @param entity 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void delete(T entity);
	
	/**
	* @Title delete
	* @Description TODO【删除实体对象】
	* @param entity 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void delete(PK id);
	
	/**
	* @Title getTotalCount
	* @Description TODO【查询实体对象数量总数】
	* @return 
	* @Return Long 返回类型
	* @Throws 
	*/ 
	public Long getTotalCount();
	
	/**
	* @Title findAllList
	* @Description TODO【查询实体对象集合】
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	public List<T> findAllList();
	/**
	* @Title findListBy
	* @Description TODO【依据参数查询实体对象集合】
	* @param values
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	public List<T> findListBy(HashMap values);
	
	/**
	* @Title getCountBy
	* @Description TODO【依据参数查询实体对象总数】
	* @param values
	* @return 
	* @Return Long 返回类型
	* @Throws 
	*/ 
	public Long getCountBy(HashMap values);
	
	
	
	
}
