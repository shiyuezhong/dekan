package com.dekan.mall.common.util;

import org.apache.commons.lang.StringUtils;

import com.dekan.mall.bean.common.Setting;
import com.dekan.mall.common.constant.SystemConstants;

/**
 * @ClassName RedirectUrlUtil
 * @Description TODO【重定向工具类】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class RedirectUrlUtil {
	
	@SuppressWarnings("unused")
	private static Setting setting;
	
	static{
		setting = (Setting) SpringUtil.getBean("setting");
	}
	
	/**
	* @Title getRequestUrl
	* @Description TODO【获取请求地址】
	* @param sn
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getRequestUrl(String sn){
		StringBuffer urlsb = new StringBuffer();
		if(StringUtils.isNotBlank(sn)){
			//urlsb.append(setting.getSystemMallUrl());
			urlsb.append(SystemConstants.SLASH_DELIMITER);
			urlsb.append(SystemConstants.REDIRECT_URL_HTM);
			urlsb.append(SystemConstants.SLASH_DELIMITER);
			urlsb.append(sn);
			urlsb.append(SystemConstants.PAYMENT_NOTIFY_SUFFIX);
		}
		System.out.println(urlsb.toString());
		return urlsb.toString();
	}
	
	
	public static String getRedirectUrl(String url){
		StringBuffer urlsb = new StringBuffer();
		if(StringUtils.isNotBlank(url)){
			String urlLower = url.toLowerCase();
			System.out.println(urlLower);
			if(urlLower.contains(SystemConstants.HTTP_LOWER)){
				urlsb.append(url.trim());
				System.out.println(urlsb.toString());
				return urlsb.toString();
			}else{
				urlsb.append(SystemConstants.HTTP_LOWER);
				urlsb.append(url.trim());
				System.out.println(urlsb.toString());
				return urlsb.toString();
			}
		}
		return urlsb.toString();
	}
	
}
