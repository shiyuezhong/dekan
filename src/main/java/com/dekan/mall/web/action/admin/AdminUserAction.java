package com.dekan.mall.web.action.admin;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dekan.mall.bean.common.AdminLoginUser;
import com.dekan.mall.bean.dto.AdminUserInfoDto;
import com.dekan.mall.bean.entity.AdminUserInfo;
import com.dekan.mall.bean.entity.RoleInfo;
import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.service.admin.intf.AdminPurviewPropService;
import com.dekan.mall.service.admin.intf.AdminUserService;
import com.dekan.mall.service.admin.intf.RoleService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName AdminUserAction
 * @Description TODO【管理员用户Action】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
@Namespace("/admin/user")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do")
})
public class AdminUserAction extends BaseAction {
	private static final long serialVersionUID = -1887714219428189911L;
	
	@Resource(name = "adminUserServiceImpl")
	private AdminUserService adminUserService;
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	@Resource(name = "adminPurviewPropServiceImpl")
	private AdminPurviewPropService adminPurviewPropService;
	
	private AdminUserInfoDto search;
	private AdminUserInfo result;
	private AdminUserInfo form;
	private String password;
	private String newPassword;
	private List<RoleInfo> roleList;
	
	private String purviewIds;//权限功能id，用于前端传值保存
	private Map<String,Integer> purviewIdMap;//权限功能id，用于前端赋值
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		if(search == null) search = new AdminUserInfoDto();
		AdminLoginUser loginUser = this.getAdmin();
		if(loginUser.getRoleId() != 1){//鼎昆角色查询全部
			search.setRoleId(loginUser.getRoleId());
		}
		pager = adminUserService.findPagerBy(search, pager);
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
		AdminLoginUser loginUser = this.getAdmin();
		if(loginUser.getRoleId() == 1){//鼎昆角色需要显示角色下拉框
		   roleList = roleService.findAllList();
		}
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
		if(form == null) return ajaxForwardError("添加管理员失败");
		AdminLoginUser loginUser = this.getAdmin();
		if(StringUtils.isNotBlank(form.getPassword())){
			form.setPassword(DigestUtils.md5Hex(form.getPassword()));
		}else{
			form.setPassword(DigestUtils.md5Hex("168168"));
		}
		form.setIsSystem(Bool.FALSE);
		adminUserService.insertRole(form,loginUser);
		return ajaxForwardSuccess("添加管理员成功!");
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
		result = adminUserService.find(id);
		AdminLoginUser loginUser = this.getAdmin();
		if(loginUser.getRoleId() == 1){//鼎昆角色需要显示角色下拉框
		   roleList = roleService.findAllList();
		}
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
		if(form == null) return ajaxForwardError("修改管理员失败");
		AdminLoginUser loginUser = this.getAdmin();
		AdminUserInfo adminUser = adminUserService.find(String.valueOf(form.getId()));
		if(adminUser == null)return ajaxForwardError("修改管理员失败");
		adminUser.setEmail(form.getEmail());
		adminUser.setUserName(form.getUserName());
		adminUser.setMobile(form.getMobile());
		adminUser.setName(form.getName());
		if(form.getAccountEnabled() != null){
			Bool boolEnabled = Bool.valueOf(Integer.parseInt(form.getAccountEnabled()));
			adminUser.setIsAccountEnabled(boolEnabled);
		}
		adminUser.setUserRoleProp(form.getUserRoleProp());
		adminUserService.updateRole(adminUser,loginUser);
		return ajaxForwardSuccess("修改管理员成功!");
	}
	
	/**
	* @Title addpurview
	* @Description TODO【分配菜单权限】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("addpurview")
	public String addpurview(){
		purviewIdMap = adminPurviewPropService.findPurviewIdByUserId(id);
		return "addpurview";
	}
	
	/**
	* @Title savepurview
	* @Description TODO【保存分配菜单权限】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("savepurview")
	public String savepurview(){
		adminUserService.savePurview(id,purviewIds);
		return ajaxForwardSuccess("分配菜单权限成功!");
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
		AdminUserInfo entity = adminUserService.find(id);
		if(entity == null){
			return ajaxForwardError("删除失败：对象为空");
		}
		if(entity.getIsSystem() == Bool.TRUE){
			return ajaxForwardError("删除失败：系统自带账号不能删除");
		}
		AdminLoginUser loginUser = this.getAdmin();
		if(entity.getId() == loginUser.getId()){
			return ajaxForwardError("删除失败：不能删除自己");
		}
		//删除操作
		adminUserService.delete(entity);
		
		//还需要删除管理关系（角色管理，菜单功能管理，分类关联）
		
		return ajaxForwardSuccess("删除管理员成功!","");
	}
	
	/**
	* @Title findByUserName
	* @Description TODO【查找账号是否存在】
	* @return 
	* @Return String 返回类型 
	* @Throws 
	*/ 
	@Action("findByUn")
	public String findByUserName(){
		AdminUserInfo au = adminUserService.find(id);
		if(au == null){
			AdminUserInfo adminUser = adminUserService.findByUserName(form.getUserName().trim());
			if(adminUser != null){
				return ajax("false");
			}else{
				return ajax("true");
			}
		}else{
			if(au.getUserName().trim().equals(form.getUserName().trim())){
				return ajax("true");
			}else{
				AdminUserInfo adminUser = adminUserService.findByUserName(form.getUserName().trim());
				if(adminUser != null){
					return ajax("false");
				}else{
					return ajax("true");
				}
			}
		}
	}
	
	/**
	* @Title changepwd
	* @Description TODO【修改密码】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("changepwd")
	public String changepwd(){
		return SUCCESS;
	}
	
	
	/** 
	* @Title: password 
	* @Description: TODO(修改密码保存) 
	* @author wangxu@erayt.com 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @see 
	*/
	@Action("password")
	public String password(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajaxForwardError("密码修改失败!");
		}
		if(!adminUser.getPassword().equals(DigestUtils.md5Hex(password))){
			return ajaxForwardError("当前密码错误!","");
		}
		if(StringUtils.isBlank(newPassword)){
			return ajaxForwardError("新密码为空!");
		}
		adminUser.setPassword(DigestUtils.md5Hex(newPassword));
		adminUserService.update(adminUser);
		return ajaxForwardSuccess("密码修改成功!");
	}
	
	/** 
	* @Title: reSetPassword 
	* @Description: TODO(重置密码) 
	* @author wangxu@erayt.com 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	* @see 
	*/
	@Action("resetpwd")
	public String reSetPassword(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajaxForwardError("账户不存在!");
		}
		adminUser.setPassword(DigestUtils.md5Hex("666888"));
		adminUserService.update(adminUser);
		return ajaxForwardSuccess("重置密码成功!","");
	}

	public AdminUserInfoDto getSearch() {
		return search;
	}

	public void setSearch(AdminUserInfoDto search) {
		this.search = search;
	}

	public AdminUserInfo getResult() {
		return result;
	}

	public void setResult(AdminUserInfo result) {
		this.result = result;
	}

	public AdminUserInfo getForm() {
		return form;
	}

	public void setForm(AdminUserInfo form) {
		this.form = form;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	public String getPurviewIds() {
		return purviewIds;
	}

	public void setPurviewIds(String purviewIds) {
		this.purviewIds = purviewIds;
	}

	public Map<String, Integer> getPurviewIdMap() {
		return purviewIdMap;
	}

	public void setPurviewIdMap(Map<String, Integer> purviewIdMap) {
		this.purviewIdMap = purviewIdMap;
	}

}
