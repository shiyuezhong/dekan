package com.dekan.mall.ws.intf;

import java.util.List;

import com.dekan.mall.bean.entity.AdminPurviewProp;


/**
 * @ClassName AdminPurviewPropWs
 * @Description TODO【管理员菜单功能关联关系】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
public interface AdminPurviewPropWs extends BaseWs<AdminPurviewProp, String> {

	List<AdminPurviewProp> findListByUserId(String adminUserId);
	 
}
