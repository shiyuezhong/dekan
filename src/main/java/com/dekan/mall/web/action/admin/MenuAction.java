package com.dekan.mall.web.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.bean.dto.PurviewInfoDto;
import com.dekan.mall.bean.entity.PurviewInfo;
import com.dekan.mall.service.admin.intf.PurviewService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName MenuAction
 * @Description TODO【菜单功能Action】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
@Namespace("/admin/menu")
public class MenuAction extends BaseAction {
	private static final long serialVersionUID = -2873576947766308309L;

	@Resource(name = "purviewServiceImpl")
	private PurviewService purviewService;
	
	private PurviewInfoDto search;
	private PurviewInfo result;
	private PurviewInfo form;
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(search == null) search = new PurviewInfoDto();
		pager = purviewService.findPagerBy(search, pager);
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
		return ajaxForwardSuccess("添加成功!");
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
		result = purviewService.find(id);
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
		if(form == null) return ajaxForwardError("修改菜单失败");
		PurviewInfo purviewInfo = purviewService.find(String.valueOf(form.getId()));
		if(purviewInfo == null)return ajaxForwardError("修改菜单失败");
		purviewInfo.setCode(form.getCode());
		purviewInfo.setName(form.getName());
		purviewService.update(purviewInfo);
		return ajaxForwardSuccess("修改菜单成功!");
	}
	

	/**
	* @Title showSub
	* @Description TODO【查看子菜单】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("subList")
	public String showSub(){
		if(search == null) search = new PurviewInfoDto();
		PurviewInfo parent = new PurviewInfo();
		parent.setId(Integer.valueOf(id));
		search.setParent(parent);
		search.setLevel(2);
		pager = purviewService.findPagerBy(search, pager);
		return "subList";
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
		return ajaxForwardSuccess("删除成功!","");
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

	public PurviewInfoDto getSearch() {
		return search;
	}

	public void setSearch(PurviewInfoDto search) {
		this.search = search;
	}

	public PurviewInfo getResult() {
		return result;
	}

	public void setResult(PurviewInfo result) {
		this.result = result;
	}

	public PurviewInfo getForm() {
		return form;
	}

	public void setForm(PurviewInfo form) {
		this.form = form;
	}

}
