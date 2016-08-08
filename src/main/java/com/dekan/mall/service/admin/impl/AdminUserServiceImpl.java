package com.dekan.mall.service.admin.impl;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dekan.mall.bean.common.AdminLoginUser;
import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.AdminUserInfoDto;
import com.dekan.mall.bean.entity.AdminPurviewProp;
import com.dekan.mall.bean.entity.AdminRoleProp;
import com.dekan.mall.bean.entity.AdminUserInfo;
import com.dekan.mall.service.admin.intf.AdminUserService;
import com.dekan.mall.ws.intf.AdminPurviewPropWs;
import com.dekan.mall.ws.intf.AdminRolePropWs;
import com.dekan.mall.ws.intf.AdminUserWs;

/**
 * @ClassName AdminUserServiceImpl
 * @Description TODO【用户管理Service层接口实现】
 * @Author Shiyz
 * @Date 2013-10-18 下午5:02:58
 */
@Service("adminUserServiceImpl")
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUserInfo, String> implements AdminUserService {
	
	@Resource(name = "adminUserWsImpl")
	private AdminUserWs adminUserWs;
	
	@Resource(name = "adminRolePropWsImpl")
	private AdminRolePropWs adminRolePropWs;
	
	@Resource(name = "adminPurviewPropWsImpl")
	private AdminPurviewPropWs adminPurviewPropWs;
	
	@Resource(name = "adminUserWsImpl")
	public void setBaseWs(AdminUserWs adminUserWs) {
		super.setBaseWs(adminUserWs);
	}
	
	@Override
	public AdminUserInfo findByUserName(String userName) {
		return adminUserWs.findByUserName(userName);
	}

	@Override
	public boolean verifyAdminUser(String userName, String password) {
		AdminUserInfo adminUserInfo = adminUserWs.findByUserName(userName);
		if(adminUserInfo != null && adminUserInfo.getPassword().equals(DigestUtils.md5Hex(password))){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Pager findPagerBy(AdminUserInfoDto memberInfoDto, Pager pager) {
		return adminUserWs.findPagerBy(memberInfoDto, pager);
	}

	@Override
	public void insert(AdminUserInfo adminUserInfo,Integer groupId, Integer guserId){
		adminUserWs.insert(adminUserInfo,groupId,guserId);
	}

	@Override
	public AdminUserInfo findByRole(String id, String string) {
		return adminUserWs.findByRole(id,string);
	}

	@Override
	@Transactional
	public void insertRole(AdminUserInfo form, AdminLoginUser loginUser) {
		adminUserWs.insert(form);
		//插入角色关联关系  
		AdminRoleProp adminRoleProp = new AdminRoleProp();
		if(loginUser.getRoleId() == 1){//鼎昆角色
			adminRoleProp = form.getUserRoleProp();
			adminRoleProp.setAdminUserId(form.getId());
			adminRolePropWs.insert(adminRoleProp);
		}else{//不是鼎昆的插入当前用户的角色
			adminRoleProp.setRoleId(loginUser.getRoleId());
			adminRoleProp.setAdminUserId(form.getId());
			adminRolePropWs.insert(adminRoleProp);
		}
	}

	@Override
	@Transactional
	public void updateRole(AdminUserInfo adminUser, AdminLoginUser loginUser) {
		adminUserWs.update(adminUser);
		//更新角色关联关系 ,不是鼎昆的不需要更新
		AdminRoleProp adminRoleProp = new AdminRoleProp();
		if(loginUser.getRoleId() == 1){//鼎昆角色
			adminRoleProp = adminUser.getUserRoleProp();
			adminRoleProp.setAdminUserId(adminUser.getId());
			adminRolePropWs.delete(adminRoleProp);
			adminRolePropWs.insert(adminRoleProp);
		}
	}

	@Override
	@Transactional
	public void savePurview(String userId, String purviewIds) {
		if(StringUtils.isNotBlank(purviewIds)){
			//1.先删除管理关系
			String adminUserId = userId;
			adminPurviewPropWs.delete(adminUserId);
			//2.保存关系
			if(purviewIds.indexOf(",") > 0){
				String []purviewId = purviewIds.split(",");
				for(String id : purviewId){
					AdminPurviewProp adminPurviewProp = new AdminPurviewProp();
					adminPurviewProp.setAdminUserId(Integer.valueOf(userId.trim()));
					adminPurviewProp.setPurviewId(Integer.valueOf(id.trim()));
					adminPurviewPropWs.insert(adminPurviewProp);
				}
			}else{
				AdminPurviewProp adminPurviewProp = new AdminPurviewProp();
				adminPurviewProp.setAdminUserId(Integer.valueOf(userId.trim()));
				adminPurviewProp.setPurviewId(Integer.valueOf(purviewIds.trim()));
				adminPurviewPropWs.insert(adminPurviewProp);
			}
		}
	}
}
