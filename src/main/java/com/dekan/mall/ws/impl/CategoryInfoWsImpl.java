package com.dekan.mall.ws.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryInfoDto;
import com.dekan.mall.bean.entity.CategoryInfo;
import com.dekan.mall.dao.mybatis.intf.CategoryInfoDao;
import com.dekan.mall.ws.intf.CategoryInfoWs;

/**
 * @ClassName CategoryInfoWsImpl
 * @Description TODO【分类信息Ws接口实现】
 * @Author Shiyz
 * @Date 2016-08-07 下午5:02:58
 */
@Service("categoryInfoWsImpl")
public class CategoryInfoWsImpl extends BaseWsImpl<CategoryInfo, String> implements CategoryInfoWs {
	
	@Resource(name = "categoryInfoDao")
	private CategoryInfoDao categoryInfoDao;

	@Resource(name = "categoryInfoDao")
	public void setBaseDao(CategoryInfoDao categoryInfoDao) {
		super.setBaseDao(categoryInfoDao);
	}

	public static List<CategoryInfo> categoryInfos;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(CategoryInfoDto categoryInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(categoryInfoDto != null && StringUtils.isNotBlank(categoryInfoDto.getName())){
			values.put("name", categoryInfoDto.getName());
		}
		if(categoryInfoDto != null && StringUtils.isNotBlank(categoryInfoDto.getCode())){
			values.put("code", categoryInfoDto.getCode());
		}
		if(categoryInfoDto != null && categoryInfoDto.getParent() != null){
			values.put("parent", categoryInfoDto.getParent());
		}
		if(categoryInfoDto != null &&  categoryInfoDto.getCategoryType() != null){
			values.put("categoryType", categoryInfoDto.getCategoryType());
		}
		Long count = categoryInfoDao.getCountBy(values);
		pager.setTotalCount(count);
		if(pager.getPageNumber() >= pager.getPageCount()){
			pager.setPageNumber(pager.getPageCount());
		}
		if(count > 0){
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", "code");
			values.put("order", "asc");
			List<CategoryInfo>  categoryInfo = categoryInfoDao.findListBy(values);
			if(categoryInfo != null && categoryInfo.size() > 0){
				pager.setResults(categoryInfo);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(String.valueOf(categoryInfo.get(0).getId()));
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findNoPagerBy(CategoryInfoDto categoryInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(categoryInfoDto != null && StringUtils.isNotBlank(categoryInfoDto.getName())){
			values.put("name", categoryInfoDto.getName());
		}
		if(categoryInfoDto != null && StringUtils.isNotBlank(categoryInfoDto.getCode())){
			values.put("code", categoryInfoDto.getCode());
		}
		if(categoryInfoDto != null &&  categoryInfoDto.getCategoryType() != null){
			values.put("categoryType", categoryInfoDto.getCategoryType());
		}
		Long count = categoryInfoDao.getNopageCountBy(values);
		if(count > 0){
			values.put("orderBy", "code");
			values.put("order", "asc");
			//查询记录.type1的加到内存，2的数据量小，每次查询
			List<CategoryInfo> categoryInfo = new ArrayList<CategoryInfo>();
			if(categoryInfoDto.getCategoryType() != null && categoryInfoDto.getCategoryType().getId() == 1){
				if(categoryInfos == null){
					categoryInfos = categoryInfoDao.findNopageListBy(values);
				} 
				categoryInfo = categoryInfos;
			}else{
				categoryInfo = categoryInfoDao.findNopageListBy(values);
			}
			if(categoryInfo != null && categoryInfo.size() > 0){
				pager.setResults(categoryInfo);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(String.valueOf(categoryInfo.get(0).getId()));
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}

	@Override
	public List<CategoryInfo> findListByParent(CategoryInfo parent) {
		return categoryInfoDao.findListByParent(parent);
	}

	@Override
	public CategoryInfo findByCode(String code) {
		return categoryInfoDao.findByCode(code);
	}
 
}
