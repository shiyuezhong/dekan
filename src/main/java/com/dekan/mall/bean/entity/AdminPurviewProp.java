package com.dekan.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName AdminPurviewProp
 * @Description TODO【管理员菜单功能组配置】
 * @Author Shiyz
 * @Date 2016-08-07 上午10:04:07
 */
@Alias("TadminPurviewProp")
public class AdminPurviewProp extends BaseEntity {
	private static final long serialVersionUID = 7548449105737413006L;
	private AdminUserInfo adminUser;//管理员用户
	private PurviewInfo purviewInfo; //菜单功能 
	private int adminUserId; //管理员ID
	private int purviewId; //菜单（功能）ID
	
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
	public PurviewInfo getPurviewInfo() {
		return purviewInfo;
	}
	public void setPurviewInfo(PurviewInfo purviewInfo) {
		this.purviewInfo = purviewInfo;
	}
	public int getPurviewId() {
		return purviewId;
	}
	public void setPurviewId(int purviewId) {
		this.purviewId = purviewId;
	}
}
