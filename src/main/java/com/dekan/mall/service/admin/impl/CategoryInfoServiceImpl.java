package com.dekan.mall.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryInfoDto;
import com.dekan.mall.bean.entity.CategoryInfo;
import com.dekan.mall.service.admin.intf.CategoryInfoService;
import com.dekan.mall.ws.intf.CategoryInfoWs;

/**
 * @ClassName CategoryInfoServiceImpl
 * @Description TODO【分类信息Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-07 上午10:19:30
 */
@Service("categoryInfoServiceImpl")
public class CategoryInfoServiceImpl extends BaseServiceImpl<CategoryInfo, String> implements
	CategoryInfoService {
	
	@Resource(name = "categoryInfoWsImpl")
	private CategoryInfoWs categoryInfoWs;
	
	@Resource(name = "categoryInfoWsImpl")
	public void setBaseWs(CategoryInfoWs categoryInfoWs) {
		super.setBaseWs(categoryInfoWs);
	}
 
	@Override
	public Pager findPagerBy(CategoryInfoDto categoryInfoDto, Pager pager) {
		return categoryInfoWs.findPagerBy(categoryInfoDto, pager);
	}
	
	@Override
	public Pager findNoPagerBy(CategoryInfoDto categoryInfoDto, Pager pager) {
		return categoryInfoWs.findNoPagerBy(categoryInfoDto, pager);
	}
	
	@Override
	public List<CategoryInfo> findListByParent(CategoryInfo parent) {
		return categoryInfoWs.findListByParent(parent);
	}

	@Override
	public CategoryInfo findByCode(String code) {
		return categoryInfoWs.findByCode(code);
	}

}
