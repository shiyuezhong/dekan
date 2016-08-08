package com.dekan.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.entity.AdminRoleProp;
import com.dekan.mall.service.admin.intf.AdminRolePropService;
import com.dekan.mall.ws.intf.AdminRolePropWs;

/**
 * @ClassName AdminRolePropServiceImpl
 * @Description TODO【管理员角色Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-06 上午10:04:07
 */
@Service("adminRolePropServiceImpl")
public class AdminRolePropServiceImpl extends
		BaseServiceImpl<AdminRoleProp, String> implements AdminRolePropService {

	@Resource(name = "adminRolePropWsImpl")
	private AdminRolePropWs adminRolePropWs;

	@Resource(name = "adminRolePropWsImpl")
	public void setBaseWs(AdminRolePropWs adminRolePropWs) {
		super.setBaseWs(adminRolePropWs);
	}

}
