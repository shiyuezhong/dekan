package com.dekan.mall.service.admin.intf;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryTypeDto;
import com.dekan.mall.bean.entity.CategoryType;

/**
 * @ClassName  CategoryTypeService
 * @Description TODO【分类管理】
 * @Author Shiyz
 * @Date 2016-08-06 上午11:11:23
 */
public interface CategoryTypeService extends BaseService<CategoryType, String> {
	/**
	 * 分页
	 * 
	 * @param roleInfoDto
	 * @param pager
	 * @return
	 */
	public Pager findPagerBy(CategoryTypeDto categoryTypeDto, Pager pager);
	
	/**
	 * 根据name查询
	 * 
	 * @param name
	 * @return
	 */
	public CategoryType findByName(String name);
}
