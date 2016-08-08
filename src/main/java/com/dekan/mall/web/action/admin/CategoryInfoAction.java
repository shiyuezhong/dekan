package com.dekan.mall.web.action.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.bean.dto.CategoryInfoDto;
import com.dekan.mall.bean.entity.CategoryInfo;
import com.dekan.mall.bean.entity.CategoryType;
import com.dekan.mall.service.admin.intf.CategoryInfoService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName CategoryAction
 * @Description TODO【分类管理Action】
 * @Author Shiyz
 * @Date 2016-08-06 下午3:45:14
 */
@Namespace("/admin/categoryinfo")
public class CategoryInfoAction extends BaseAction {
	private static final long serialVersionUID = 854350018466573138L;

	@Resource(name = "categoryInfoServiceImpl")
	private CategoryInfoService categoryInfoService;
	
	private CategoryInfoDto search;
	private CategoryInfo result;
	private CategoryInfo form;
	
	List<CategoryInfo> selectList;//下拉级联
	/**
	* @Title depart
	* @Description TODO【部门列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("depart")
	public String depart(){
		if(search == null) search = new CategoryInfoDto();
		CategoryType categoryType = new CategoryType();
		categoryType.setId(2);
		search.setCategoryType(categoryType);
		pager = categoryInfoService.findNoPagerBy(search, pager);
		return "depart";
	}
	
	/**
	* @Title departList
	* @Description TODO【查看部门列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("departList")
	public String departList(){
		if(search == null) search = new CategoryInfoDto();
		CategoryType categoryType = new CategoryType();
		categoryType.setId(2);
		search.setCategoryType(categoryType);
		pager = categoryInfoService.findPagerBy(search, pager);
		return "departList";
	}
	
	/**
	* @Title saveCategoryInfo
	* @Description TODO【异步保存】先废弃
	* @return 
	 * @throws UnsupportedEncodingException 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("updateCategoryInfo")
	public String saveInfo() throws UnsupportedEncodingException{
		 if(StringUtils.isBlank(id)){
			 return ajaxForwardError("添加失败!");
		 }
		 CategoryInfo obj = categoryInfoService.find(id);
		 if(StringUtils.isNotBlank(name)){
			 String  value= new String(name.getBytes("ISO-8859-1"), "UTF-8");
			 obj.setName(value);
		 }
		 if(StringUtils.isNotBlank(code)){
			 String  value= new String(code.getBytes("ISO-8859-1"), "UTF-8");
			 CategoryInfo objCode = categoryInfoService.findByCode(value);
			 if(objCode != null && objCode.getId() != Integer.valueOf(id)){
				 return ajaxForwardError("编码已存在!");
			 }
			 obj.setCode(value);
		 }
		 categoryInfoService.update(obj);
		 return ajaxForwardSuccess("保存成功!");
	}

	/**
	* @Title add
	* @Description TODO【添加】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@SuppressWarnings("unchecked")
	@Action(ADD)
	public String add(){
		if(search == null) search = new CategoryInfoDto();
		CategoryType categoryType = new CategoryType();
		categoryType.setId(2);
		search.setCategoryType(categoryType);
		selectList = (List<CategoryInfo>) categoryInfoService.findNoPagerBy(search, pager).getResults();
		return INPUT;
	}
 
	/**
	* @Title childCategoryInfo
	* @Description TODO【查找下级】
	* @return 
	 * @throws UnsupportedEncodingException 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("childCategoryInfo")
	public String childCategoryInfo(){
		CategoryInfo parent = new CategoryInfo();
		parent.setId(Integer.valueOf(id));
		selectList = categoryInfoService.findListByParent(parent);
		return ajax(selectList);
	}
	
	/**
	* @Title saveDepart
	* @Description TODO【保存部门】
	* @return 
	 * @throws UnsupportedEncodingException 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("saveDepart")
	public String saveDepart(){
		if(form == null) return ajaxForwardError("添加失败");
		CategoryInfo categoryInfo = categoryInfoService.findByCode(form.getCode());
		if(categoryInfo != null){
			return ajaxForwardError("该部门已存在,添加失败");
		}
		CategoryType categoryType = new CategoryType();
		categoryType.setId(2);
		form.setCategoryType(categoryType);
		categoryInfoService.insert(form);
		return ajaxForwardSuccess("添加成功!");
	}
	
	/**
	* @Title area
	* @Description TODO【地区列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("area")
	public String area(){
		if(search == null) search = new CategoryInfoDto();
		CategoryType categoryType = new CategoryType();
		categoryType.setId(1);
		search.setCategoryType(categoryType);
		pager = categoryInfoService.findNoPagerBy(search, pager);
		return "area";
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
		CategoryInfo entity = categoryInfoService.find(id);
		if(entity == null){
			return ajaxForwardError("删除失败：对象为空");
		}
		if(entity.getId() == 1){//鼎昆,到时候根据实际线上更改
			return ajaxForwardError("删除失败：系统自带部门不能删除");
		}
		//删除操作
		categoryInfoService.delete(entity);
		return ajaxForwardSuccess("删除成功!","");
	}
	
	/**
	* @Title saveCategoryInfo
	* @Description TODO【异步保存】先废弃
	* @return 
	 * @throws UnsupportedEncodingException 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("saveCategoryInfo")
	public String saveCategoryInfo() throws UnsupportedEncodingException{
		 CategoryInfo obj = new CategoryInfo();
		 CategoryInfo parent = new CategoryInfo();
		 if(StringUtils.isBlank(id) || StringUtils.isBlank(name)){
			 return ajaxForwardError("添加失败!");
		 }
		 parent.setId(Integer.valueOf(id));
		 obj.setParent(parent);
		 CategoryType categoryType = new CategoryType();
		 categoryType.setId(2);
		 String  value= new String(name.getBytes("ISO-8859-1"), "UTF-8");
		 obj.setName(value);
		 obj.setCategoryType(categoryType);
		 categoryInfoService.insert(obj);
		 return ajaxForwardSuccess("添加成功!");
	}

	public CategoryInfoDto getSearch() {
		return search;
	}

	public void setSearch(CategoryInfoDto search) {
		this.search = search;
	}

	public CategoryInfo getResult() {
		return result;
	}

	public void setResult(CategoryInfo result) {
		this.result = result;
	}

	public CategoryInfo getForm() {
		return form;
	}

	public void setForm(CategoryInfo form) {
		this.form = form;
	}

	public List<CategoryInfo> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<CategoryInfo> selectList) {
		this.selectList = selectList;
	}
}
