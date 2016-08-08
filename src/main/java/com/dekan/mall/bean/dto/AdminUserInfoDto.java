package com.dekan.mall.bean.dto;

import java.io.Serializable;

import com.dekan.mall.bean.entity.AdminUserInfo;

/**
 * @ClassName AdminUserInfoDto
 * @Description TODO【后台管理员详情Dto】
 * @Author Shiyz
 * @Date 2016-08-06 下午13:41:31
 */
public class AdminUserInfoDto extends AdminUserInfo implements Serializable{
	private static final long serialVersionUID = -3847705967680402627L;
	private int roleId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
