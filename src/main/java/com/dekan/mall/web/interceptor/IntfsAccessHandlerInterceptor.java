package com.dekan.mall.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dekan.mall.bean.common.ParamsParser;
import com.dekan.mall.bean.common.ParamsValidator;
import com.dekan.mall.bean.vo.CommonIntfVo;
import com.dekan.mall.common.constant.SystemConstants;
import com.dekan.mall.common.enums.IntfsReturn;
import com.dekan.mall.common.util.IntfsUtils;
import com.dekan.mall.common.util.OutUtils;
import com.dekan.mall.common.util.XmlUtils;

/**
 * @ClassName RequestHandlerInterceptor
 * @Description TODO【Spring请求处理拦截器】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class IntfsAccessHandlerInterceptor extends HandlerInterceptorAdapter {

	/**
	* @Title postHandle
	* @Description 
	* @param request
	* @param response
	* @param handler
	* @param modelAndView
	* @throws Exception
	* @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	*/ 
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String resultContent = "";
		String callBackType = request.getParameter("dtype");
		if(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY) != null){
			if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
				resultContent = XmlUtils.toXml(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY));
			}else{ //默认返回Json格式数据
				resultContent = XmlUtils.toJson(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY));	
			}
		}else{
			CommonIntfVo intfVo = new CommonIntfVo();
			intfVo.setActionMethod((String)request.getAttribute(SystemConstants.ACTION_METHOD));
			intfVo.setMessage(IntfsReturn.UNKNOWN_WRONG.getMessage());//未知错误
			intfVo.setCode(IntfsReturn.UNKNOWN_WRONG.getCode());
			if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
				resultContent = XmlUtils.toXml(intfVo);
			}else{ //默认返回Json格式数据
				resultContent = XmlUtils.toJson(intfVo);
			}
		}
		OutUtils.out(response, resultContent);
	}

	/**
	* @Title preHandle
	* @Description 
	* @param request
	* @param response
	* @param handler
	* @return
	* @throws Exception
	* @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	*/ 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			String requestParams = request.getParameter(SystemConstants.PARAMS);
			String actionMethod = IntfsUtils.getActionMethod(request);
			String callBackType = request.getParameter("dtype");
			//参数验证
			IntfsReturn rc = ParamsValidator.verify(requestParams,actionMethod);
			if(rc.getValue() != IntfsReturn.SUCCESS.getValue()){
				CommonIntfVo intfVo = new CommonIntfVo();
				intfVo.setActionMethod(actionMethod);
				intfVo.setCode(rc.getCode());
				intfVo.setMessage(rc.getMessage());
				if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
					OutUtils.out(response, XmlUtils.toXml(intfVo));
				}else{ //默认返回Json格式数据
					OutUtils.out(response, XmlUtils.toJson(intfVo));
				}
				return false;
			}
			//解析参数
			ParamsParser paramsParser = new ParamsParser(requestParams);
			request.setAttribute(SystemConstants.REQUEST_PARAMS_KEY, paramsParser);
			request.setAttribute(SystemConstants.ACTION_METHOD, actionMethod);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		super.afterCompletion(httpservletrequest, httpservletresponse, obj, exception);
	}
	
}
