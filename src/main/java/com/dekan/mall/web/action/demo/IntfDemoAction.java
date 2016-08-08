package com.dekan.mall.web.action.demo;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.dekan.mall.common.constant.SystemConstants;
import com.dekan.mall.common.enums.Intfs;
import com.dekan.mall.web.action.core.BaseAction;


@Namespace("/demo/intf")
public class IntfDemoAction extends BaseAction {
	private static final long serialVersionUID = 1295424422145097232L;
	
	public Intfs result;
	public String requestServer;
	public String mappingUrl;
	
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		return LIST;
	}
	
	/**
	* @Title edit
	* @Description TODO【编辑接口】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(EDIT)
	public String edit(){
		if(StringUtils.isNotBlank(id)){
			result = Intfs.valueOf(Integer.parseInt(id));
			requestServer = "http://" +request.getLocalAddr() + ":" + request.getLocalPort();
			mappingUrl = SystemConstants.INTF_SERVICE_MAPPING_URL;
		}
		return INPUT;
	}
	
	
	/**
	* @Title getIntfs
	* @Description TODO【获取接口枚举】
	* @return 
	* @Return Intfs[] 返回类型
	* @Throws 
	*/ 
	public Intfs[] getIntfs(){
		return Intfs.values();
	}

	/**
	 * @return the result
	 */
	public Intfs getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Intfs result) {
		this.result = result;
	}

	/**
	 * @return the requestServer
	 */
	public String getRequestServer() {
		return requestServer;
	}

	/**
	 * @param requestServer the requestServer to set
	 */
	public void setRequestServer(String requestServer) {
		this.requestServer = requestServer;
	}

	/**
	 * @return the mappingUrl
	 */
	public String getMappingUrl() {
		return mappingUrl;
	}

	/**
	 * @param mappingUrl the mappingUrl to set
	 */
	public void setMappingUrl(String mappingUrl) {
		this.mappingUrl = mappingUrl;
	}
	
}
