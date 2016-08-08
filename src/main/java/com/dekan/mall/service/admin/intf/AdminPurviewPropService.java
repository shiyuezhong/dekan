package com.dekan.mall.service.admin.intf;

import java.util.Map;

import com.dekan.mall.bean.entity.AdminPurviewProp;

/**
 * @ClassName AdminPurviewPropService
 * @Description TODO【管理员菜单功能关联关系Service层接口】
 * @Author Shiyz
 * @Date 2016-08-06 上午12:04:07
 */
public interface AdminPurviewPropService extends BaseService<AdminPurviewProp, String> {

	Map<String, Integer> findPurviewIdByUserId(String adminUserId);
	 
}
