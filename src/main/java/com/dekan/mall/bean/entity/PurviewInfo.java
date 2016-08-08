package com.dekan.mall.bean.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName PurviewInfo
 * @Description TODO【权限资源表】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("TpurviewInfo")
public class PurviewInfo extends BaseEntity {
	private static final long serialVersionUID = 9041754780918216604L;
	
	private String code;//编码
	private String name;//名称
	private int type;//是否为菜单
	private String linkurl;//请求地址
	private PurviewInfo parent; //父权限
	private Integer sortNo; //排序
	private Integer level; //级别
	private List<PurviewInfo> subPurviews = new ArrayList<PurviewInfo>();//子菜单
	
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
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public PurviewInfo getParent() {
		return parent;
	}
	public void setParent(PurviewInfo parent) {
		this.parent = parent;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<PurviewInfo> getSubPurviews() {
		return subPurviews;
	}
	public void setSubPurviews(List<PurviewInfo> subPurviews) {
		this.subPurviews = subPurviews;
	}
	 
}
