package com.dekan.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.RoleInfoDto;
import com.dekan.mall.bean.entity.RoleInfo;
import com.dekan.mall.service.admin.intf.RoleService;
import com.dekan.mall.ws.intf.RoleWs;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO【角色Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<RoleInfo, String> implements
		RoleService {
	
	@Resource(name = "roleWsImpl")
	private RoleWs roleWs;
	
	@Resource(name = "roleWsImpl")
	public void setBaseWs(RoleWs roleWs) {
		super.setBaseWs(roleWs);
	}
	
	@Override
	public Pager findPagerBy(RoleInfoDto roleInfoDto, Pager pager) {
		return roleWs.findPagerBy(roleInfoDto, pager);
	}

	@Override
	public RoleInfo findByName(String name) {
		return roleWs.findByName(name);
	}

}
