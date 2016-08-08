package com.dekan.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.RoleInfoDto;
import com.dekan.mall.bean.entity.RoleInfo;
import com.dekan.mall.dao.mybatis.intf.RoleDao;
import com.dekan.mall.ws.intf.RoleWs;

/**
 * @ClassName RoleWsImpl
 * @Description TODO【角色】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Service("roleWsImpl")
public class RoleWsImpl extends BaseWsImpl<RoleInfo, String> implements RoleWs {
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	
	@Resource(name = "roleDao")
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(RoleInfoDto roleInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(roleInfoDto != null && roleInfoDto.getName() != null && StringUtils.isNotBlank(roleInfoDto.getName())){
			values.put("name", roleInfoDto.getName());
		}
		if(roleInfoDto != null && roleInfoDto.getCode() != null && StringUtils.isNotBlank(roleInfoDto.getCode())){
			values.put("code", roleInfoDto.getCode());
		}
		if(roleDao != null){
			//查询数量
		}
		Long count = roleDao.getCountBy(values);
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
			List<RoleInfo> admins = roleDao.findListBy(values);
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


	/**
	 * @Title findSystemList
	 * @Description 
	 * @return
	 * @see com.dekan.mall.ws.intf.RoleWs#findSystemList()
	 */
	@Override
	public List<RoleInfo> findSystemList() {
		return roleDao.findSystemList();
	}

	@Override
	public RoleInfo findByName(String name) {
		return roleDao.findByName(name);
	}

}
