package com.dekan.mall.dao.mybatis.intf;

import java.util.List;

import com.dekan.mall.bean.entity.AdminPurviewProp;

/**
 * @ClassName AdminPurviewPropDao
 * @Description TODO【管理员菜单功能关联关系配置】
 * @Author Shiyz
 * @Date 2016-08-06 上午10:04:07
 */
public interface AdminPurviewPropDao extends BaseDao<AdminPurviewProp, String> {

	List<AdminPurviewProp> findListByUserId(String adminUserId);

}
