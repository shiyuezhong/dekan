package com.dekan.mall.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;

public class ParamExceptionMappingInterceptor extends
		ExceptionMappingInterceptor {

	private static final long serialVersionUID = -6527523502782222330L;

	protected String findResultFromExceptions(
			List<ExceptionMappingConfig> exceptionMappings, Throwable t) {
		System.out.println("ParamExceptionMappingInterceptor: " + t + ":" + t.getMessage());

		if (t instanceof RuntimeException) {
			t.printStackTrace();
		}
		
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("statusCode", 300);
		req.setAttribute("message", t);

		return super.findResultFromExceptions(exceptionMappings, t);
	}
}
