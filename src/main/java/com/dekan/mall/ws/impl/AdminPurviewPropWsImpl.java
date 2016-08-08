package com.dekan.mall.ws.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dekan.mall.bean.entity.AdminPurviewProp;
import com.dekan.mall.dao.mybatis.intf.AdminPurviewPropDao;
import com.dekan.mall.ws.intf.AdminPurviewPropWs;

/**
 * @ClassName AdminPurviewPropWsImpl
 * @Description TODO【管理员菜单功能关联关系】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
@Service("adminPurviewPropWsImpl")
public class AdminPurviewPropWsImpl extends BaseWsImpl<AdminPurviewProp, String> implements AdminPurviewPropWs {
	@Resource(name = "adminPurviewPropDao")
	private AdminPurviewPropDao adminPurviewPropDao;
	
	@Resource(name = "adminPurviewPropDao")
	public void setBaseDao(AdminPurviewPropDao adminPurviewPropDao) {
		super.setBaseDao(adminPurviewPropDao);
	}

	@Override
	public List<AdminPurviewProp> findListByUserId(String adminUserId) {
		return adminPurviewPropDao.findListByUserId(adminUserId);
	}
	
}
