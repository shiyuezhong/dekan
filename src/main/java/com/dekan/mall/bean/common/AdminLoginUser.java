package com.dekan.mall.bean.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dekan.mall.bean.entity.AdminUserInfo;
import com.dekan.mall.bean.entity.PurviewInfo;

/**
 * @ClassName AdminLoginUser
 * @Description TODO【管理员登陆用户】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class AdminLoginUser implements Serializable{
	private static final long serialVersionUID = 3576566708133085480L;
	
	private int id;//id
	private String name;//姓名
	private String userSn;//管理员编号
	private String userName;//登陆用户名
	private String password;//登陆密码
	private String email;//电子邮箱
	private String mobile;//电话号码
	private Set<String> authCodes; //验证码
	private int roleId; //角色ID
	protected List<PurviewInfo> userPurviews;//管理员功能权限 
	
	public AdminLoginUser(){
		
	}
	
	public AdminLoginUser(AdminUserInfo adminUser){
		if(adminUser != null){
			this.id = adminUser.getId();
			this.name = adminUser.getName();
			this.userSn = adminUser.getUserSn();
			this.userName = adminUser.getUserName();
			this.password = adminUser.getPassword();
			this.email = adminUser.getMobile();
			this.authCodes = new HashSet<String>();
			this.roleId = adminUser.getUserRoleProp().getRoleId();
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserSn() {
		return userSn;
	}
	public void setUserSn(String userSn) {
		this.userSn = userSn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Set<String> getAuthCodes() {
		return authCodes;
	}
	public void setAuthCodes(Set<String> authCodes) {
		this.authCodes = authCodes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public List<PurviewInfo> getUserPurviews() {
		return userPurviews;
	}
	public void setUserPurviews(List<PurviewInfo> userPurviews) {
		this.userPurviews = userPurviews;
	}
}
