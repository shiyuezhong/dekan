package com.dekan.mall.ws.intf;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryTypeDto;
import com.dekan.mall.bean.entity.CategoryType;

/**
 * @ClassName CategoryTypeWs
 * @Description TODO【分类管理】
 * @Author Shiyz
 * @Date 2016-08-06 下午2:12:11
 */
public interface CategoryTypeWs extends BaseWs<CategoryType, String> {

	/**
	 * 分页查询
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
