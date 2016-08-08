package com.dekan.mall.dao.mybatis.intf;

import java.util.HashMap;

import com.dekan.mall.bean.entity.AdminUserInfo;

/**
 * @ClassName AdminUserDao
 * @Description TODO【管理员用户Dao层接口】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */

@SuppressWarnings({"rawtypes" })
public interface AdminUserDao extends BaseDao<AdminUserInfo, String> {
	
	/**
	* @Title findByUserName
	* @Description TODO【依据用户名查询登录管理】
	* @param userName
	* @return 
	* @Return AdminUserInfo 返回类型
	* @Throws 
	*/ 
	public AdminUserInfo findByUserName(String userName);
	
	/**
	* @Title repair
	* @Description TODO【修复用户】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void repair();
	/**
	* @Title deleteAdminUserRoleRef
	* @Description TODO【删除管理员用户角色关系】
	* @param adminUserInfo 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void deleteAdminUserRoleRef(AdminUserInfo adminUserInfo);
	/**
	* @Title insertRoleRef
	* @Description TODO【插入管理员角色】
	* @param values
	* @return 
	* @Throws 
	*/ 
	public void insertRoleRef(HashMap values);
	/**
	* @Title insertRoleGroupRef
	* @Description TODO【插入管理员组角色】
	* @param values
	* @return 
	* @Throws 
	*/ 
	public void insertRoleGroupRef(HashMap values);
	/**
	* @Title findByRole
	* @Description TODO【查找用户】
	* @param values
	* @return 
	* @Throws 
	*/ 
	public AdminUserInfo findByRole(HashMap values);
}
