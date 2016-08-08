package com.dekan.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryTypeDto;
import com.dekan.mall.bean.entity.CategoryType;
import com.dekan.mall.dao.mybatis.intf.CategoryTypeDao;
import com.dekan.mall.ws.intf.CategoryTypeWs;

/**
 * @ClassName CategoryTypeWsImpl
 * @Description TODO【分类管理】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
@Service("categoryTypeWsImpl")
public class CategoryTypeWsImpl extends BaseWsImpl<CategoryType, String> implements CategoryTypeWs {
	@Resource(name = "categoryTypeDao")
	private CategoryTypeDao categoryTypeDao;
	
	@Resource(name = "categoryTypeDao")
	public void setBaseDao(CategoryTypeDao categoryTypeDao) {
		super.setBaseDao(categoryTypeDao);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(CategoryTypeDto categoryTypeDto, Pager pager) {
		HashMap values = new HashMap();
		if(categoryTypeDto != null && categoryTypeDto.getName() != null && StringUtils.isNotBlank(categoryTypeDto.getName())){
			values.put("name", categoryTypeDto.getName());
		}
		if(categoryTypeDao != null){
			//查询数量
		}
		Long count = categoryTypeDao.getCountBy(values);
		pager.setTotalCount(count);
		if(pager.getPageNumber() >= pager.getPageCount()){
			pager.setPageNumber(pager.getPageCount());
		}
		if(count > 0){
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", pager.getOrderBy());
			values.put("order", pager.getOrder());
			//查询记录
			List<CategoryType> admins = categoryTypeDao.findListBy(values);
			if(admins != null && admins.size() > 0){
				pager.setResults(admins);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(String.valueOf(admins.get(0).getId()));
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}


	@Override
	public CategoryType findByName(String name) {
		return categoryTypeDao.findByName(name);
	}

}
