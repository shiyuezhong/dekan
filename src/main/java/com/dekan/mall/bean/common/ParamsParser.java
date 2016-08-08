package com.dekan.mall.bean.common;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;

import com.dekan.mall.common.constant.SystemConstants;
import com.dekan.mall.common.util.JsonUtil;

/**
 * @ClassName RequestParamsParser
 * @Description TODO【请求参数解析器】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class ParamsParser {
	private  HashMap<String, Object> requestParser = new HashMap<String, Object>();
	
	/**
	* @Title 
	* @Description 
	* @param requestParams
	*/ 
	public ParamsParser(String requestParams){
		if(StringUtils.isNotBlank(requestParams)){
			requestParser = JsonUtil.toObject(requestParams, new TypeReference<HashMap<String, Object>>() {});	
		}
	}
	
	/**
	* @Title getString
	* @Description TODO【获取参数值】
	* @param property
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String getString(String property){
		return getString(property,SystemConstants.BLANK_STRING); 
	}
	
	
	/**
	* @Title getParam
	* @Description TODO【获取参数值】
	* @param property
	* @param defaultValue
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String getString(String property,String defaultValue){
		System.out.println("ttt="+requestParser.get(property) );
		if(requestParser.get(property) != null){
			if (StringUtils.isNotBlank(String.valueOf(requestParser.get(property)))) {
				String results = String.valueOf(requestParser.get(property));
				if(results.equals("null")){
					return defaultValue; 
				}
				return results.trim();
			}
		}
		return defaultValue; 
	}
	
	/**
	* @Title getInt
	* @Description TODO【获取参数值】
	* @param property
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int getInt(String property){
		return getInt(property,-1); 
	}
	
	/**
	* @Title getInt
	* @Description TODO【获取参数值】
	* @param property
	* @param defaultValue
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int getInt(String property,int defaultValue){
		if(requestParser.get(property) != null){
			if (StringUtils.isNotBlank(String.valueOf(requestParser.get(property)))) {
				try {
					if (StringUtils.isNotBlank(String.valueOf(requestParser.get(property)))) {
						return  Double.valueOf(String.valueOf(requestParser.get(property))).intValue();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return defaultValue; 
	}
	
	/**
	* @Title getParam
	* @Description TODO【获取参数】
	* @param property
	* @return 
	* @Return Map<String,Object> 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("unchecked")
	public  HashMap<String, Object> getParam(String property){
		if (requestParser.get(property)!=null) {
			return (HashMap<String, Object>) requestParser.get(property);
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getArrayList(String property) {
		return getArrayList(property, null);
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getArrayList(String property, List<HashMap<String, Object>> defaultValue) {
		List<HashMap<String, Object>> result = defaultValue;
		try {
			if (StringUtils.isNotBlank(String.valueOf(requestParser.get(property)))) {
				result = (List<HashMap<String, Object>>) requestParser.get(property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * @return the requestParser
	 */
	public HashMap<String, Object> getRequestParser() {
		return requestParser;
	}

	/**
	 * @param requestParser the requestParser to set
	 */
	public void setRequestParser(HashMap<String, Object> requestParser) {
		this.requestParser = requestParser;
	}
	
}
