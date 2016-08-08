package com.dekan.mall.web.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.bean.dto.CategoryTypeDto;
import com.dekan.mall.bean.entity.CategoryType;
import com.dekan.mall.service.admin.intf.CategoryTypeService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName CategoryAction
 * @Description TODO【分类管理Action】
 * @Author Shiyz
 * @Date 2016-08-06 下午3:45:14
 */
@Namespace("/admin/categorytype")
public class CategoryTypeAction extends BaseAction {
	private static final long serialVersionUID = 1233025422829454415L;

	@Resource(name = "categoryTypeServiceImpl")
	private CategoryTypeService categoryTypeService;
	
	private CategoryTypeDto search;
	private CategoryType result;
	private CategoryType form;
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(search == null) search = new CategoryTypeDto();
		pager = categoryTypeService.findPagerBy(search, pager);
		return LIST;
	}
	
	/**
	* @Title add
	* @Description TODO【添加】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(ADD)
	public String add(){
		return INPUT;
	}
	
	/**
	* @Title save
	* @Description TODO【保存】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(SAVE)
	public String save(){
		if(form == null) return ajaxForwardError("添加分类失败");
		CategoryType categoryType = categoryTypeService.findByName(form.getName());
		if(categoryType != null){
			return ajaxForwardError("该分类已存在,添加分类失败");
		}
		categoryTypeService.insert(form);
		return ajaxForwardSuccess("添加分类成功!");
	}
	
	/**
	* @Title edit
	* @Description TODO【编辑】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(EDIT)
	public String edit(){
		result = categoryTypeService.find(id);
		return INPUT;
	}
	
	/**
	* @Title update
	* @Description TODO【修改】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(UPDATE)
	public String update(){
		if(form == null) return ajaxForwardError("修改分类失败");
		CategoryType categoryType = categoryTypeService.find(String.valueOf(form.getId()));
		if(categoryType == null)return ajaxForwardError("修改分类失败");
		categoryType.setName(form.getName());
		categoryType.setDescription(form.getDescription());
		categoryTypeService.update(categoryType);
		return ajaxForwardSuccess("修改分类成功!");
	}
	
	/**
	* @Title delete
	* @Description TODO【删除】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DELETE)
	public String delete(){
		CategoryType entity = categoryTypeService.find(id);
		if(entity == null){
			return ajaxForwardError("删除失败：对象为空");
		}
		//删除操作
		categoryTypeService.delete(entity);
		return ajaxForwardSuccess("删除角色成功!","");
	}
	
	/**
	* @Title detail
	* @Description TODO【详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DETAIL)
	public String detail(){
		return SUCCESS;
	}

	public CategoryTypeDto getSearch() {
		return search;
	}

	public void setSearch(CategoryTypeDto search) {
		this.search = search;
	}

	public CategoryType getResult() {
		return result;
	}

	public void setResult(CategoryType result) {
		this.result = result;
	}

	public CategoryType getForm() {
		return form;
	}

	public void setForm(CategoryType form) {
		this.form = form;
	}
	 
}
