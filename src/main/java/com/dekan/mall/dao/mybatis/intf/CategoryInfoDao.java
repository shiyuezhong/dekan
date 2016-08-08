package com.dekan.mall.dao.mybatis.intf;

import java.util.HashMap;
import java.util.List;

import com.dekan.mall.bean.entity.CategoryInfo;

/**
 * @ClassName CategoryInfoDao
 * @Description TODO【分类信息】
 * @Author Shiyz
 * @Date 2016-08-07 上午1:04:11
 */
public interface CategoryInfoDao extends BaseDao<CategoryInfo, String> {
	
	/**
	* @Title findListByParent
	* @Description TODO【获取子节点】
	* @param entity
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<CategoryInfo> findListByParent(CategoryInfo parent);

	/**
	 * 根据code查找
	 * 
	 * @param code
	 * @return
	 */
	public CategoryInfo findByCode(String code);

	/**
	* @Title findNopageListBy
	* @Description TODO【不分页】
	* @param values
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public List<CategoryInfo> findNopageListBy(HashMap values);

	/**
	* @Title getNopageCountBy
	* @Description TODO【不分页】
	* @param values
	* @return 
	* @Return List<T> 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public Long getNopageCountBy(HashMap values);}
