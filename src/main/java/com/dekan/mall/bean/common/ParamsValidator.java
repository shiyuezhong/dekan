package com.dekan.mall.bean.common;

import org.apache.commons.lang.StringUtils;

import com.dekan.mall.common.enums.IntfsReturn;
import com.dekan.mall.common.util.JsonValidatorUtil;

/**
 * @ClassName ParamsValidator
 * @Description TODO【请求参数验证】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class ParamsValidator {
	
	/**
	* @Title verify
	* @Description TODO【数据校验】
	* @param params
	* @return 
	* @Return IntfsReturn 返回类型
	* @Throws 
	*/ 
	public static IntfsReturn verify(String params,String actionMethod){
		if(StringUtils.isBlank(actionMethod)){
			return IntfsReturn.INTERFACE_NOT_EXIST;
		}
		//字符串是否为空
		if(StringUtils.isBlank(params)){
			return IntfsReturn.PARAM_BLANK;
		}
		
		//是否为json格式字符串
		JsonValidatorUtil json = new JsonValidatorUtil();
		if(!json.validate(params)){
			return IntfsReturn.PARAM_WRONG;
		}
		return IntfsReturn.SUCCESS;
	}

}
