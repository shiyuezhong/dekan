package com.dekan.mall.ws.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.entity.AdminRoleProp;
import com.dekan.mall.dao.mybatis.intf.AdminRolePropDao;
import com.dekan.mall.ws.intf.AdminRolePropWs;

/**
 * @ClassName AdminRolePropWsImpl
 * @Description TODO【管理员角色关联关系】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
@Service("adminRolePropWsImpl")
public class AdminRolePropWsImpl extends BaseWsImpl<AdminRoleProp, String> implements AdminRolePropWs {
	@Resource(name = "adminRolePropDao")
	private AdminRolePropDao adminRolePropDao;
	
	@Resource(name = "adminRolePropDao")
	public void setBaseDao(AdminRolePropDao adminRolePropDao) {
		super.setBaseDao(adminRolePropDao);
	}
	
}
