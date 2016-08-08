package com.dekan.mall.common.util;

import javax.servlet.http.HttpServletRequest;

import com.dekan.mall.common.constant.SystemConstants;
import com.dekan.mall.common.enums.Intfs;

/**
 * @ClassName ParamsUtils
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class IntfsUtils {
	
	/**
	* @Title getActionMethod
	* @Description TODO【获取请求方法名称】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getActionMethod(HttpServletRequest request){
		String requestUrl = request.getRequestURI();
		Intfs intf = Intfs.stringOf(requestUrl);
		if(intf != null){
			return intf.getAction();
		}
		return SystemConstants.BLANK_STRING;
	}
	
	/**
	* @Title getActionDesc
	* @Description TODO【获取接口描述】
	* @param request
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getActionDesc(HttpServletRequest request){
		String requestUrl = request.getRequestURI();
		Intfs intf = Intfs.stringOf(requestUrl);
		if(intf != null){
			return intf.getDesc();
		}
		return SystemConstants.BLANK_STRING;
	} 
	
	/**
	* @Title getIntfsImpl
	* @Description TODO【获取请求方法接口实现】
	* @param request
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getIntfsImpl(HttpServletRequest request){
		String requestUrl = request.getRequestURI();
		Intfs intf = Intfs.stringOf(requestUrl);
		return intf.getImpl();
	}
	
}
