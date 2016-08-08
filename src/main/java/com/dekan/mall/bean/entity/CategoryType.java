package com.dekan.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName CategoryType
 * @Description TODO【分类管理】
 * @Author Shiyz
 * @Date 2016-08-06 上午11:04:33
 */
@Alias("TcategoryType")
public class CategoryType extends BaseEntity {
	private static final long serialVersionUID = 3861255359986953556L;
	private String name;//名称
	private String description;//描述
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
}
