package com.dekan.mall.dao.mybatis.intf;

import com.dekan.mall.bean.entity.CategoryType;

/**
 * @ClassName CategoryTypeDao
 * @Description TODO【分类管理】
 * @Author Shiyz
 * @Date 2016-08-06 上午11:04:11
 */
public interface CategoryTypeDao extends BaseDao<CategoryType, String> {

	/**
	 * 根据name查询
	 * 
	 * @param name
	 * @return
	 */
	public CategoryType findByName(String name);
}
