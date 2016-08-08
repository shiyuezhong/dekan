package com.dekan.mall.service.admin.intf;

import com.dekan.mall.bean.common.AdminLoginUser;
import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.AdminUserInfoDto;
import com.dekan.mall.bean.entity.AdminUserInfo;

/**
 * @ClassName AdminUserService
 * @Description TODO【管理员用户Service层接口】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface AdminUserService extends BaseService<AdminUserInfo, String> {
	
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
	* @Title verifyAdminUser
	* @Description TODO【依据密码和用户名验证管理员用户】
	* @param userName
	* @param password
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean verifyAdminUser(String userName,String password);
	
	/**
	* @Title findPagerBy
	* @Description TODO【】
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(AdminUserInfoDto adminUserInfoDto, Pager pager);
	
	/**
	* @Title insert
	* @Description TODO【插入管理员】
	* @param adminUserInfo管理员信息类， groupId组id，guserId用户对应的供应商或者酒店id
	* @return 
	* @Throws 
	*/ 
	public void insert(AdminUserInfo sadmin, Integer groupId, Integer guserId);
	
	/**
	* @Title findByRole
	* @Description TODO【根据用户和角色取管理员】
	* @param adminUserInfo管理员信息类， groupId组id，guserId用户对应的供应商或者酒店id
	* @return 
	* @Throws 
	*/
	public AdminUserInfo findByRole(String id, String string);

	/**
	 * 保存
	 * @param form
	 */
	public void insertRole(AdminUserInfo form, AdminLoginUser loginUser);
	
	/**
	 * 更新
	 * 
	 * @param adminUser
	 * @param loginUser
	 */
	public void updateRole(AdminUserInfo adminUser, AdminLoginUser loginUser);

	/**
	 * 保存管理员跟菜单功能的关联关系
	 * @param id
	 * @param purviewIds
	 */
	public void savePurview(String id, String purviewIds);
}
