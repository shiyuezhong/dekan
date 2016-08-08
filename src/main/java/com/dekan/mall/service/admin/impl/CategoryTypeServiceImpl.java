package com.dekan.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryTypeDto;
import com.dekan.mall.bean.entity.CategoryType;
import com.dekan.mall.service.admin.intf.CategoryTypeService;
import com.dekan.mall.ws.intf.CategoryTypeWs;

/**
 * @ClassName CategoryTypeServiceImpl
 * @Description TODO【分类管理Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-06 上午11:04:07
 */
@Service("categoryTypeServiceImpl")
public class CategoryTypeServiceImpl extends
		BaseServiceImpl<CategoryType, String> implements CategoryTypeService {

	@Resource(name = "categoryTypeWsImpl")
	private CategoryTypeWs categoryTypeWs;

	@Resource(name = "categoryTypeWsImpl")
	public void setBaseWs(CategoryTypeWs categoryTypeWs) {
		super.setBaseWs(categoryTypeWs);
	}

	@Override
	public Pager findPagerBy(CategoryTypeDto categoryTypeDto, Pager pager) {
		return categoryTypeWs.findPagerBy(categoryTypeDto, pager);
	}
	
	@Override
	public CategoryType findByName(String name) {
		return categoryTypeWs.findByName(name);
	}

}
