package com.dekan.mall.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
* @ClassName SpringUtil
* @Description TODO【Spring工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/  
public class SpringUtil implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtil.applicationContext = applicationContext;
	}
	
	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	* @Title getApplicationContext
	* @Description TODO【获取applicationContext】
	* @return 
	* @Return ApplicationContext 返回类型
	* @Throws 
	*/ 
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	
	/**
	* @Title getBean
	* @Description TODO【根据Bean名称获取实例】
	* @param name
	* @return
	* @throws BeansException 
	* @Return Object 返回类型
	* @Throws 
	*/ 
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

}