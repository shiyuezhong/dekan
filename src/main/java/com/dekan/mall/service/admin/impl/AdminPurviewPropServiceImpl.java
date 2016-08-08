package com.dekan.mall.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.entity.AdminPurviewProp;
import com.dekan.mall.service.admin.intf.AdminPurviewPropService;
import com.dekan.mall.ws.intf.AdminPurviewPropWs;

/**
 * @ClassName AdminPurviewPropServiceImpl
 * @Description TODO【管理员菜单功能关联关系Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-06 上午12:04:01
 */
@Service("adminPurviewPropServiceImpl")
public class AdminPurviewPropServiceImpl extends
		BaseServiceImpl<AdminPurviewProp, String> implements AdminPurviewPropService {

	@Resource(name = "adminPurviewPropWsImpl")
	private AdminPurviewPropWs adminPurviewPropWs;

	@Resource(name = "adminPurviewPropWsImpl")
	public void setBaseWs(AdminPurviewPropWs adminPurviewPropWs) {
		super.setBaseWs(adminPurviewPropWs);
	}

	@Override
	public Map<String, Integer> findPurviewIdByUserId(String adminUserId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<AdminPurviewProp> list = adminPurviewPropWs.findListByUserId(adminUserId);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		for(AdminPurviewProp purviewProp : list){
			map.put(String.valueOf(purviewProp.getPurviewId()), purviewProp.getPurviewId());
		}
		return map;
	}

}
