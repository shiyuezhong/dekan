package com.dekan.mall.common.enums;

import com.dekan.mall.common.constant.SystemConstants;

/**
 * @ClassName Intfs
 * @Description TODO【接口枚举】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public enum Intfs {
	//会员用户
	VCODE(1,"","vcode","getsVcodeHandleImpl","获取验证码",2),
	REGISTER(2,"","register","registerHandleImpl","注册",2),
	LOGIN(3,"","login","loginHandleImpl","登录",2),
	EDITUSER(4,"","edituser","editAccountHandleImpl","修改账号",2),
	LOGOUT(5,"","logout","logoutHandleImpl","注销",-1),
	FEEDBACK(6,"","feedback","addMemberFeedbackHandleImpl","意见反馈",2),
	//商品详情
	PRODUCTDETAILS(12,"","productdetails","getsProductDetailHandleImpl","商品详情",2),
	PRODUCTLIST(14,"","productlist","findProductListHandleImpl","商品列表",2),
	//商品扫描
	SCANNED(15,"","scanned","addScansHandleImpl","提交商品扫描",2),
	SCANLIST(16,"","scanlist","findScansListHandleImpl","扫描记录列表",2),
	DELSCAN(17,"","delscan","deleteScansHandleImpl","删除扫描记录",2),
	//提交合作申请
	ADDAPPLICATION(33,"","addapplication","addApplicationHandleImpl","提交合作申请",2);
	
	private Intfs(int value,String code,String action,String impl,String desc,int status){
		this.value = value;
		this.code = code;
		this.action = action;
		this.impl = impl;
		this.desc = desc;
		this.status = status;
		
	}
	
	/**
	* @Title stringOf
	* @Description TODO【依据请求方法获取接口信息】
	* @param content
	* @return 
	* @Return Intfs 返回类型
	* @Throws 
	*/ 
	public static Intfs stringOf(String content){
		for(Intfs intf: Intfs.values()){
			StringBuffer sb = new StringBuffer();
			sb.append(SystemConstants.INTF_SERVICE_MAPPING_URL);
			sb.append(intf.getAction());
			sb.append(SystemConstants.INTF_ACTION_SUFFIX);
			if(content.contains(sb.toString())){
				return intf;
			}
		}
		return null;
	}
	
	/**
	* @Title valueOf
	* @Description TODO【依据value获取接口】
	* @param value
	* @return 
	* @Return Intfs 返回类型
	* @Throws 
	*/ 
	public static Intfs valueOf(int value){
		for(Intfs intf: Intfs.values()){
			if(value == intf.getValue()){
				return intf;
			}
		}
		return null;
	}
	
	private int value;
	private String code;
	private String action;
	private String impl;
	private String desc;
	private int status;//0-测试Demo，1-开发中，2-测试中，3-已完成
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImpl() {
		return impl;
	}
	public void setImpl(String impl) {
		this.impl = impl;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


}
