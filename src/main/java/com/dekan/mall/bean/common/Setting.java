package com.dekan.mall.bean.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
* @ClassName Setting
* @Description TODO【系统设置】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
@Configuration
public class Setting {
	@Value("${system.admin.name}")
	private String systemName;
	@Value("${system.mall.name}")
	private String systemMallname; //系统商城
	@Value("${system.phone}")
	private String systemPhone; //联系电话
	@Value("${system.mobile}")
	private String systemMobile; //联系电话
	@Value("${image.server.path}")
	private String imageServerPath; //图片服务器路径
	 
	@Value("${system.mall.url}")
	private String systemMallUrl;//系统名
	@Value("${system.realUrl}")
	private String sysRealUrl; //项目ip
	@Value("${image.real.path}")
	private String imgRealUrl; //图片真实路径
	@Value("${image.temp.path}")
	private String imgTempUrl; //图片上传的临时路径
	 
	public String getSystemMallname() {
		return systemMallname;
	}
	public String getImageServerPath() {
		return imageServerPath;
	}
	public void setSystemMallname(String systemMallname) {
		this.systemMallname = systemMallname;
	}
	public void setImageServerPath(String imageServerPath) {
		this.imageServerPath = imageServerPath;
	}
	public String getSystemMobile() {
		return systemMobile;
	}
	public void setSystemMobile(String systemMobile) {
		this.systemMobile = systemMobile;
	}
	public String getSystemMallUrl() {
		return systemMallUrl;
	}
	public void setSystemMallUrl(String systemMallUrl) {
		this.systemMallUrl = systemMallUrl;
	}
	public String getSystemPhone() {
		return systemPhone;
	}
	public void setSystemPhone(String systemPhone) {
		this.systemPhone = systemPhone;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSysRealUrl() {
		return sysRealUrl;
	}
	public void setSysRealUrl(String smsRealUrl) {
		this.sysRealUrl = smsRealUrl;
	}
	public String getImgRealUrl() {
		return imgRealUrl;
	}
	public void setImgRealUrl(String imgRealUrl) {
		this.imgRealUrl = imgRealUrl;
	}
	public String getImgTempUrl() {
		return imgTempUrl;
	}
	public void setImgTempUrl(String imgTempUrl) {
		this.imgTempUrl = imgTempUrl;
	}
}
