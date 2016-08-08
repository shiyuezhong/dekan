/**
* @FileName IntfsResDataHandle.java
* @Package com.dekan.mall.service.protocol.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 下午3:16:24
* @Version V1.0.1
*/
package com.dekan.mall.service.protocol.intf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

/**
 * @ClassName IntfsResDataHandle
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface IntfsResDataHandle {
	
	/**
	* @Title process
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param request
	* @param response
	* @param modelMap
	* @return 
	* @Return ModelMap 返回类型
	* @Throws 
	*/ 
	public ModelMap process(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) ;
}
