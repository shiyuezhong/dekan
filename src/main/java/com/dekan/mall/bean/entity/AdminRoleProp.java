package com.dekan.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName AdminRoleProp
 * @Description TODO【管理员角色组配置】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("TadminRoleProp")
public class AdminRoleProp extends BaseEntity {
	private static final long serialVersionUID = 1292235093857052581L;
	
	private AdminUserInfo adminUser;//管理员用户
	private RoleInfo roleInfo; //角色 
	private int adminUserId; //管理员ID
	private int roleId; //角色ID
	
	public AdminUserInfo getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(AdminUserInfo adminUser) {
		this.adminUser = adminUser;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public void onInsert() {
		super.onInsert();
	}
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	@Override
	public void onDelete() {
		super.onDelete();
	}
}
