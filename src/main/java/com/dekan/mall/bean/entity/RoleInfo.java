package com.dekan.mall.bean.entity;

import org.apache.ibatis.type.Alias;

import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.common.enums.Status;

/**
 * @ClassName RoleInfo
 * @Description TODO【用户角色表】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("TroleInfo")
public class RoleInfo extends BaseEntity {
	private static final long serialVersionUID = 1002023294716915045L;
	
	private String code;//角色编码
	private String name;//名称
	private Bool isSystem;//是否内置角色
	private Status status;//状态
	private Bool isDelete;//是否删除
	private String description;//描述
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bool getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(Bool isSystem) {
		this.isSystem = isSystem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Bool getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Bool isDelete) {
		this.isDelete = isDelete;
	}
}
