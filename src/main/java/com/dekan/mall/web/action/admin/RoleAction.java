package com.dekan.mall.web.action.admin;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.bean.dto.RoleInfoDto;
import com.dekan.mall.bean.entity.RoleInfo;
import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.common.enums.Status;
import com.dekan.mall.service.admin.intf.RoleService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName RoleAction
 * @Description TODO【角色Action】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Namespace("/admin/role")
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 6265014023884155453L;
	
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	private RoleInfoDto search;
	private RoleInfo result;
	private RoleInfo form;
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(search == null) search = new RoleInfoDto();
		pager = roleService.findPagerBy(search, pager);
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
		if(form == null) return ajaxForwardError("添加角色失败");
		RoleInfo roleInfo = roleService.findByName(form.getName());
		if(roleInfo != null){
			return ajaxForwardError("该角色已存在,添加角色失败");
		}
		form.setIsDelete(Bool.FALSE);
		form.setStatus(Status.Enabled);
		form.setIsSystem(Bool.FALSE);
		roleService.insert(form);
		return ajaxForwardSuccess("添加角色成功!");
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
		result = roleService.find(id);
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
		if(form == null) return ajaxForwardError("修改角色失败");
		RoleInfo roleInfo = roleService.find(String.valueOf(form.getId()));
		if(roleInfo == null)return ajaxForwardError("修改角色失败");
		roleInfo.setCode(form.getCode());
		roleInfo.setName(form.getName());
		roleInfo.setDescription(form.getDescription());
		roleService.update(roleInfo);
		return ajaxForwardSuccess("修改角色成功!");
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
		RoleInfo entity = roleService.find(id);
		if(entity == null){
			return ajaxForwardError("删除失败：对象为空");
		}
		if(entity.getIsSystem() == Bool.TRUE){
			return ajaxForwardError("删除失败：系统自带角色不能删除");
		}
		//删除操作
		roleService.delete(entity);
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

	public RoleInfoDto getSearch() {
		return search;
	}

	public void setSearch(RoleInfoDto search) {
		this.search = search;
	}

	public RoleInfo getResult() {
		return result;
	}

	public void setResult(RoleInfo result) {
		this.result = result;
	}

	public RoleInfo getForm() {
		return form;
	}

	public void setForm(RoleInfo form) {
		this.form = form;
	}

}
