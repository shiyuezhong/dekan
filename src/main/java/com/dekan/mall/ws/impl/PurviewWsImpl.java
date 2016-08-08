package com.dekan.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.PurviewInfoDto;
import com.dekan.mall.bean.entity.PurviewInfo;
import com.dekan.mall.dao.mybatis.intf.PurviewDao;
import com.dekan.mall.ws.intf.PurviewWs;

/**
 * @ClassName PurviewWsImpl
 * @Description TODO【菜单功能Ws接口实现】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Service("purviewWsImpl")
public class PurviewWsImpl extends BaseWsImpl<PurviewInfo, String> implements PurviewWs {
	
	@Resource(name = "purviewDao")
	private PurviewDao purviewDao;

	@Resource(name = "purviewDao")
	public void setBaseDao(PurviewDao purviewDao) {
		super.setBaseDao(purviewDao);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(PurviewInfoDto purviewInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(purviewInfoDto != null && StringUtils.isNotBlank(purviewInfoDto.getName())){
			values.put("name", purviewInfoDto.getName());
		}
		if(purviewInfoDto != null && StringUtils.isNotBlank(purviewInfoDto.getCode())){
			values.put("code", purviewInfoDto.getCode());
		}
		if(purviewInfoDto != null &&  purviewInfoDto.getParent() != null){
			values.put("parent", purviewInfoDto.getParent());
		}
		if(purviewInfoDto != null &&  purviewInfoDto.getLevel() == null){
			values.put("level", 1);
		}
		if(purviewInfoDto != null &&  purviewInfoDto.getType() == 0){
			values.put("type", 1);
		}
		if(purviewDao != null){
			//查询数量
		}
		Long count = purviewDao.getCountBy(values);
		pager.setTotalCount(count);
		if(pager.getPageNumber() >= pager.getPageCount()){
			pager.setPageNumber(pager.getPageCount());
		}
		if(count > 0){
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", "sort_no");
			values.put("order", "desc");
			//查询记录
			List<PurviewInfo> purviewInfos = purviewDao.findListBy(values);
			if(purviewInfos != null && purviewInfos.size() > 0){
				pager.setResults(purviewInfos);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(String.valueOf(purviewInfos.get(0).getId()));
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}

	@Override
	public List<PurviewInfo> findMenuRoot(int userId) {
		return purviewDao.findMenuRoot(userId);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<PurviewInfo> findMenuChild(int id, int userId) {
		HashMap values = new HashMap();
		values.put("id", id);
		values.put("userId", userId);
	    return purviewDao.findMenuChild(values);
	}
	
	@Override
	public List<PurviewInfo> findFunction(int userId) {
		return purviewDao.findFunction(userId);
	}
	
	@Override
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent) {
		return purviewDao.findMenuListByParent(parent);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void savePurviewRoleRef(HashMap values) {
		purviewDao.savePurviewRoleRef(values);
	}

}
