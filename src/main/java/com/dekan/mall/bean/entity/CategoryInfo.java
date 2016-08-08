package com.dekan.mall.bean.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName CategoryInfo
 * @Description TODO【分类信息】
 * @Author Shiyz
 * @Date 2016-08-07 上午1:04:33
 */
@Alias("TcategoryInfo")
public class CategoryInfo extends BaseEntity {
	private static final long serialVersionUID = -4156022182489660759L;
	private String code;//编码
	private String name;//名称
	private CategoryInfo parent; //父
	private CategoryType categoryType; //分类
	private List<CategoryInfo> subCategoryInfos = new ArrayList<CategoryInfo>();//子 
	
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
	public CategoryInfo getParent() {
		return parent;
	}
	public void setParent(CategoryInfo parent) {
		this.parent = parent;
	}
	public CategoryType getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}
	public List<CategoryInfo> getSubCategoryInfos() {
		return subCategoryInfos;
	}
	public void setSubCategoryInfos(List<CategoryInfo> subCategoryInfos) {
		this.subCategoryInfos = subCategoryInfos;
	}
}
