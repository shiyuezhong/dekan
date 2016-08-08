package com.dekan.mall.dao.mybatis.intf;

import java.util.List;

import com.dekan.mall.bean.entity.RoleInfo;

/**
 * @ClassName RoleDao
 * @Description TODO【角色】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface RoleDao extends BaseDao<RoleInfo, String> {

	/**
	 * 查询系统内置角色列表
	 * 
	 * @return
	 */
	public List<RoleInfo> findSystemList();

	/**
	 * 根据name查询
	 * 
	 * @param name
	 * @return
	 */
	public RoleInfo findByName(String name);

}
