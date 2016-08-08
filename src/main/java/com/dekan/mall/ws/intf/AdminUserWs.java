package com.dekan.mall.ws.intf;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.AdminUserInfoDto;
import com.dekan.mall.bean.entity.AdminUserInfo;

/**
 * @ClassName AdminUserWs
 * @Description TODO【管理员用户WS层接口】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
public interface AdminUserWs extends BaseWs<AdminUserInfo, String> {
	
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
	* @Title findPagerBy
	* @Description TODO【分页查询】
	* @param adminUserInfoDto
	* @param pager
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(AdminUserInfoDto adminUserInfoDto, Pager pager);
	
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
	* @Title insert
	* @Description TODO【插入】
	* @param adminUserInfo 管理员对象
	* @Throws 
	*/ 
	public void insert(AdminUserInfo adminUserInfo,Integer groupId,Integer guserId);
	/**
	* @Title findByRole
	* @Description TODO【查找管理员】
	* @param adminUserInfo 管理员对象
	* @Throws 
	*/ 
	public AdminUserInfo findByRole(String id, String string);
}
