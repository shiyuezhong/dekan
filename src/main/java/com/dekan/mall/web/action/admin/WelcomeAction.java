package com.dekan.mall.web.action.admin;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.dekan.mall.bean.common.AdminLoginUser;
import com.dekan.mall.bean.entity.AdminUserInfo;
import com.dekan.mall.bean.entity.PurviewInfo;
import com.dekan.mall.common.constant.SystemConstants;
import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.common.enums.SystemEnums.OperateStatus;
import com.dekan.mall.common.util.CaptchaUtil;
import com.dekan.mall.common.util.IpUtils;
import com.dekan.mall.service.admin.intf.AdminUserService;
import com.dekan.mall.web.action.core.BaseAction;

/**
 * @ClassName WelcomeAction
 * @Description TODO【欢迎主界面】
 * @Author Shiyz
 * @Date 2016-08-04 下午4:04:50
 */
@Namespace("/admin/welcome")
@Results({
	@Result(name="redirect_index", type="redirect", location="index.do"),
	@Result(name = "redirect", location = "${redirectUrl}", type = "redirect")
})
public class WelcomeAction extends BaseAction {
	private static final long serialVersionUID = -7970182576005566850L;
	private String userName;//用户名
	private String password;//密码
	
	@Resource(name = "adminUserServiceImpl")
	private AdminUserService adminUserService;

	
	/**
	* @Title index
	* @Description TODO【登录页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(INDEX)
	public String index(){
		if(getLoginUser() != null){
			redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			return REDIRECT;
		}
		return INDEX;
	}
	
	/**
	* @Title login
	* @Description TODO【登录】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LOGIN)
	public String login(){
		if(StringUtils.isBlank(userName)){
			return ajax(OperateStatus.ERROR,"用户名为空!",0);
		}
		if(StringUtils.isBlank(password)){
			return ajax(OperateStatus.ERROR,"密码为空!",0);
		}
		if (!CaptchaUtil.validateCaptchaByRequest(getRequest())) {
			return ajax(OperateStatus.ERROR,"验证码错误!");
		}
		 
		AdminUserInfo loginUser = adminUserService.findByUserName(userName);
		if(loginUser == null){
			return ajax(OperateStatus.ERROR,"管理员用户不存在!",0);
		}
		// 解除会员账户锁定
		if(loginUser.getIsAccountLocked() == Bool.TRUE) {
			if (SystemConstants.IS_LOGIN_FAILURE_LOCK) {
				int loginFailureLockTime = SystemConstants.LOGIN_FAILURE_LOCK_TIME;
				if (loginFailureLockTime > 0) {
					Date lockedDate = loginUser.getLockedDate();
					Date unlockDate = DateUtils.addMinutes(lockedDate,
							loginFailureLockTime);
					if (new Date().after(unlockDate)) {
						loginUser.setLoginFailureCount(0);
						loginUser.setIsAccountLocked(Bool.FALSE);
						loginUser.setLockedDate(null);
						adminUserService.update(loginUser);
					}
				}
			} else {
				loginUser.setLoginFailureCount(0);
				loginUser.setIsAccountLocked(Bool.FALSE);
				loginUser.setLockedDate(null);
				adminUserService.update(loginUser);
			}
		}
		if(loginUser.getIsAccountEnabled() == Bool.FALSE){
			return ajax(OperateStatus.ERROR,"管理员用户被禁用，无法登陆!",0);
		}
		
		if(loginUser.getIsAccountLocked() == Bool.TRUE){
			return ajax(OperateStatus.ERROR,"管理员用户被锁定，无法登陆!",0);
		}
		
		if(!adminUserService.verifyAdminUser(userName, password)){
			if (SystemConstants.IS_LOGIN_FAILURE_LOCK) {
				//记录失败次数
				int loginFailureLockCount = SystemConstants.LOGIN_FAILURE_LOCK_COUNT;
				int loginFailureCount = loginUser.getLoginFailureCount() + 1;
				if (loginFailureCount >= loginFailureLockCount) {
					loginUser.setIsAccountLocked(Bool.TRUE);
					loginUser.setLockedDate(new Date());
				}
				loginUser.setLoginFailureCount(loginFailureCount);
				adminUserService.update(loginUser);
				setSession("fcount",loginFailureCount);
				if (SystemConstants.IS_LOGIN_FAILURE_LOCK && loginFailureLockCount - loginFailureCount <= 3) {
					return ajax(OperateStatus.ERROR,"若连续" + loginFailureLockCount + "次密码输入错误,您的管理员账户将被锁定!",loginFailureCount);
				} else {
					return ajax(OperateStatus.ERROR,"您的密码错误!",loginFailureCount);
				}
			} else {
				return ajax(OperateStatus.ERROR,"您的密码错误!",0);
			}
		}
		loginUser.setLastLoginIp(IpUtils.getIpAddr(getRequest()));
		loginUser.setLastLoginDate(new Date());
		loginUser.setLoginFailureCount(0);
		adminUserService.update(loginUser);
		AdminLoginUser adminLoginUser = new AdminLoginUser(loginUser);
		super.setLoginUser(adminLoginUser);
		//设置功能权限
		List<PurviewInfo> userPurviews = getUserPurviews();
		adminLoginUser.setUserPurviews(userPurviews);
		return ajax(OperateStatus.SUCCESS,"登录成功!");
	}
	
	/**
	* @Title main
	* @Description TODO【登陆成功后主页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("main")
	public String main(){
		if(getLoginUser() != null){
			return "main";
		}
		return "redirect_index";
	}
	
	/**
	* @Title logout
	* @Description TODO【注销】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("logout")
	public String logout(){
		if(getLoginUser() != null){
			removeSession(LOGIN_ADMIN_USER);
		}
		return "redirect_index";
	}
	
	/**
	* @Title toggle
	* @Description TODO【用户切换】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("toggle")
	public String toggle(){
		if(getLoginUser() != null){
			redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			//获取登录用户信息
			AdminLoginUser oldLoginInfo = this.getAdmin();
			System.out.println("name:"+oldLoginInfo.getName());
			System.out.println("username:"+oldLoginInfo.getUserName());
			AdminUserInfo loginUser = adminUserService.find(String.valueOf(oldLoginInfo.getId()));
			if(loginUser != null){
				AdminLoginUser newLoginInfo = new AdminLoginUser(loginUser);
				super.setLoginUser(newLoginInfo); //重新设置Session
			}
			return REDIRECT;
		}
		return "redirect_index";
	}
	/**
	* @Title header
	* @Description TODO【头部页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("header")
	public String header(){
		return SUCCESS;
	}
	
	/**
	* @Title left
	* @Description TODO【左侧页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("left")
	public String left(){
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
