package com.dekan.mall.common.util;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

import com.dekan.mall.bean.common.CaptchaEngine;
import com.octo.captcha.service.CaptchaService;

/**
* @ClassName CaptchaUtil
* @Description TODO【验证码验证工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class CaptchaUtil {
	
	private static final String CAPTCHA_SERVICE_BEAN_NAME = "captchaService";// CaptchaService Bean名称
	
	/**
	* @Title validateCaptchaByRequest
	* @Description TODO【根据HttpServletRequest校验验证码】
	* @param request
	* @param parameterName
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public static boolean validateCaptchaByRequest(HttpServletRequest request, String parameterName) {
		String captchaID = request.getSession().getId();
		String challengeResponse = StringUtils.upperCase(request.getParameter(parameterName));
		
		if (StringUtils.isEmpty(captchaID) || StringUtils.isEmpty(challengeResponse)) {
			return false;
		}
		
		CaptchaService captchaService = (CaptchaService) SpringUtil.getBean(CAPTCHA_SERVICE_BEAN_NAME);
		try {
			if (captchaService.validateResponseForID(captchaID, challengeResponse)) {
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
	
	/**
	* @Title validateCaptchaByRequest
	* @Description TODO【根据HttpServletRequest校验验证码,使用默认参数名称】
	* @param request
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public static boolean validateCaptchaByRequest(HttpServletRequest request) {
		return validateCaptchaByRequest(request, CaptchaEngine.CAPTCHA_PARAMETER_NAME);
	}

}