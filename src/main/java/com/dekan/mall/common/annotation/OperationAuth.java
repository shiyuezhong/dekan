package com.dekan.mall.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName OperationAuth
 * @Description TODO【操作权限】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Target(ElementType.METHOD)       
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited   
public @interface OperationAuth {

	 /**
	* @Title code
	* @Description TODO【权限码】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String code() default "";  	
}
