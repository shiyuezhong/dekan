package com.dekan.mall.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dekan.mall.common.annotation.OperationAuth;
import com.dekan.mall.web.action.core.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

/**
 * @ClassName AdminAccessAuthorityInterceptor
 * @Description TODO【后台访问权限拦截器】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class AdminAccessAuthorityInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = -3544852040585875665L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminAccessAuthorityInterceptor.class);
	private static final String[] LOGIN_IGNORED_URLS = {
			"/admin/welcome/index.do","/admin/welcome/main.do","/admin/welcome/login.do",
			"/admin/welcome/logout.do","/admin/device/impDone.do"};
	private static final String[] LOGIN_IGNORED_URIS = {"/common/","/wechat/"};

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestUri = request.getRequestURI();
		if (!isLogin(requestUri)) { // 不需要登录
			return invocation.invoke();
		}
		Object object = invocation.getAction();
		if (object instanceof BaseAction) {
			BaseAction baseAction = (BaseAction) object;
			if (baseAction.getLoginUser() == null) {
				return redirectTimeout(request);
			}
			String actionName = invocation.getProxy().getActionName();
			String actionClass = invocation.getAction().getClass().getName();
			Method method = invocation.getAction().getClass()
					.getMethod(invocation.getProxy().getMethod());
			if (method == null) {
				LOGGER.error("no this method[name=" + actionName + "] on "
						+ actionClass);
				return BaseAction.ERROR;
			}
			OperationAuth auth = method.getAnnotation(OperationAuth.class);
			// 未注解权限码不过滤用户权限
			if (auth == null) {
				return invocation.invoke();
			}
		}
		return invocation.invoke();
	}

	/**
	 * @Title isLogin
	 * @Description TODO【确定地址是否要登录】
	 * @param url
	 * @return
	 * @Return boolean 返回类型
	 * @Throws
	 */
	public boolean isLogin(String url) {
		for (String ignoredUrl : LOGIN_IGNORED_URIS) {
			if (StringUtils.isNotBlank(ignoredUrl)) {
				if (url.contains(ignoredUrl)) {
					return false;
				}
			}
		}
		for (String ignoredUrl : LOGIN_IGNORED_URLS) {
			if (StringUtils.isNotBlank(ignoredUrl)) {
				if (url.contains(ignoredUrl)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @Title redirectTimeout
	 * @Description TODO【重定向到超时页面】
	 * @return
	 * @Return String 返回类型
	 * @Throws
	 */
	public String redirectTimeout(HttpServletRequest request) {
		String redirectUrl = request.getServletPath();
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			redirectUrl += "?" + queryString;
		}
		OgnlValueStack ognlValueStack = (OgnlValueStack) request
				.getAttribute("struts.valueStack");
		ognlValueStack.set("redirectUrl", redirectUrl);
		return "timeout";
	}

}
