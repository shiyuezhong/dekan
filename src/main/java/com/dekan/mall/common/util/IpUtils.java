package com.dekan.mall.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IpUtils
 * @Description TODO【 IP工具类】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class IpUtils {
	
	/**
	* @Title getIpAddr
	* @Description TODO【获取IP地址】
	* @param request
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf("0:") != -1) {
			ip = "本地";
		}
		return ip;
	}
}
