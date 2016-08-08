package com.dekan.mall.ws.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.AdminUserInfoDto;
import com.dekan.mall.bean.entity.AdminUserInfo;
import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.dao.mybatis.intf.AdminUserDao;
import com.dekan.mall.ws.intf.AdminUserWs;

/**
 * @ClassName AdminUserWsImpl
 * @Description TODO【用户管理Ws层接口实现】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Service("adminUserWsImpl")
public class AdminUserWsImpl extends BaseWsImpl<AdminUserInfo, String> implements AdminUserWs {
	
	@Resource(name = "adminUserDao")
	private AdminUserDao adminUserDao;
	
	@Resource(name = "adminUserDao")
	public void setBaseDao(AdminUserDao adminUserDao) {
		super.setBaseDao(adminUserDao);
	}

	@Override
	public AdminUserInfo findByUserName(String userName) {
		return adminUserDao.findByUserName(userName);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(AdminUserInfoDto adminUserInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(adminUserInfoDto != null && adminUserInfoDto.getName() != null && StringUtils.isNotBlank(adminUserInfoDto.getName())){
			values.put("name", adminUserInfoDto.getName());
		}
		if(adminUserInfoDto != null && adminUserInfoDto.getRoleId() != 0){
			values.put("roleId", adminUserInfoDto.getRoleId());
		}
		if(adminUserDao != null){
			//查询数量
		}
		Long count = adminUserDao.getCountBy(values);
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
			List<AdminUserInfo> admins = adminUserDao.findListBy(values);
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
	public void repair() {
		adminUserDao.repair();
	}

	@Override
	public void deleteAdminUserRoleRef(AdminUserInfo adminUserInfo) {
		adminUserDao.deleteAdminUserRoleRef(adminUserInfo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public void insert(AdminUserInfo adminUserInfo,Integer groupId,Integer guserId){
		HashMap values = new HashMap();
		values.put("paramName","");
		adminUserInfo.setUserSn("operator");
		adminUserInfo.setName("系统操作员");
		adminUserInfo.setPassword(DigestUtils.md5Hex(adminUserInfo.getPassword()));
		if(adminUserInfo.getIsAccountEnabled() != null){
		   Bool boolEnabled =  adminUserInfo.getIsAccountEnabled();
		   adminUserInfo.setIsAccountEnabled(boolEnabled);
		}
		super.insert(adminUserInfo);
		values.put("roleId",groupId);
		values.put("userId",adminUserInfo.getId());
		adminUserDao.insertRoleRef(values);
		values.put("groupId",groupId);
		values.put("paramValue",guserId);
		adminUserDao.insertRoleGroupRef(values);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public AdminUserInfo findByRole(String id, String string) {
		HashMap values = new HashMap();
		values.put("paramValue", id);
		values.put("paramName", string);
		return adminUserDao.findByRole(values);
	}
}
