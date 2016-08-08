package com.dekan.mall.web.action.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dekan.mall.bean.common.AdminLoginUser;
import com.dekan.mall.bean.common.Setting;
import com.dekan.mall.bean.entity.PurviewInfo;
import com.dekan.mall.common.enums.Bool;
import com.dekan.mall.common.enums.SystemEnums.OperateStatus;
import com.dekan.mall.common.util.CookieUtils;
import com.dekan.mall.common.util.JsonUtil;
import com.dekan.mall.service.admin.intf.PurviewService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName BaseAction
 * @Description TODO【Action基类】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Controller
@Scope("prototype")
@ResultPath("/WEB-INF/views/template/")
public abstract class BaseAction extends CommonAction{
	private static final long serialVersionUID = 7983779596892866514L;

	@Resource
	private Setting setting;
	
	@Resource(name = "purviewServiceImpl")
	private PurviewService purviewService;
	
	public BaseAction() {
		actionExecTime = 0L;
		request = getRequest();
		response = getResponse();
	}
	
	private String realPath;
	private long actionExecTime;
	public HttpServletRequest request;
	public HttpServletResponse response;
	protected String logInfo;// 日志记录信息
	private String jsonText;
	//图片路径
	protected  String imagePath;
	protected List<PurviewInfo> mainPurviews; //主菜单
	
	protected  String imgRealUrl;//图片真实路径
	protected  String imgTempUrl;//图片临时上传路径
	
	//获取用户拥有权限列表
	public List<PurviewInfo> getUserPurviews() {
		AdminLoginUser loginUser = this.getAdmin();
		if(loginUser == null){
			return null;
		}
		return purviewService.findFunction(loginUser.getId());
	}
	
	//获取主菜单列表
	public List<PurviewInfo> getMainPurviews() {
		AdminLoginUser loginUser = this.getAdmin();
		if(loginUser == null){
			return null;
		}
		List<PurviewInfo> list = purviewService.findMenuRoot(loginUser.getId());
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		for(PurviewInfo purviewInfo:list){
			List<PurviewInfo> childs = purviewService.findMenuChild(purviewInfo.getId(),loginUser.getId());
			purviewInfo.setSubPurviews(childs);
		}
		return list;
	}
	
	//获取系统名称
	public String getSystemName(){
		return setting.getSystemName();
	}
	
	public Bool[] getBools(){
		return Bool.values();
	}
	
	//获取系统地址
	public String getSystemMallUrl(){
		return setting.getSystemMallUrl();
	}
	
	// 判断是否为添加
	public Boolean getIsAddAction() {
		if (id == null) {
			return true;
		} else {
			return false;
		}
	}

	public String getImagePath() {
		return setting.getImageServerPath();
	}

		
	//判断是否为ajax请求
	public static boolean isAjax(HttpServletRequest request) {
		if (request != null
				&& "XMLHttpRequest".equalsIgnoreCase(request
						.getHeader("X-Requested-With")))
			return true;
		return false;
	}
	
	public void workbookToInputStream(HSSFWorkbook workbook,String fileName) throws IOException{
		this.downloadFileName = fileName; //设置fileName
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos); 
        baos.flush(); 
        byte[] aa = baos.toByteArray();
        this.inputStream = new ByteArrayInputStream(aa, 0, aa.length);
        baos.close();
	}
	// 获取Request
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	// 获取Response
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	// 获取ServletContext
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	// 获取Attribute
	public Object getAttribute(String name) {
		return ServletActionContext.getRequest().getAttribute(name);
	}

	// 设置Attribute
	public void setAttribute(String name, Object value) {
		ServletActionContext.getRequest().setAttribute(name, value);
	}

	// 获取Parameter
	public String getParameter(String name) {
		return ServletActionContext.getRequest().getParameter(name);
	}

	// 获取Parameter数组
	public String[] getParameterValues(String name) {
		return ServletActionContext.getRequest().getParameterValues(name);
	}

	// 获取Session
	public Object getSession(String name) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		return session.get(name);
	}
	
	// 设置Session
	public void setSession(String name, Object value) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put(name, value);
	}

	// 移除Session
	public void removeSession(String name) {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.remove(name);
	}
	
	// 获取Cookie
	public String getCookie(String name) {
		return CookieUtils.getCookie(ServletActionContext.getRequest(), name);
	}
	
	// 设置Cookie
	public void setCookie(String name, String value) {
 		CookieUtils.addCookie(ServletActionContext.getRequest(), ServletActionContext.getResponse(), name, value, ServletActionContext.getRequest().getContextPath() + "/");
	}
	
	// 设置Cookie
	public void setCookie(String name, String value, Integer maxAge) {
 		CookieUtils.addCookie(ServletActionContext.getRequest(), ServletActionContext.getResponse(), name, value, ServletActionContext.getRequest().getContextPath() + "/", maxAge, null, null);
	}

	// 移除Cookie
	public void removeCookie(String name) {
		CookieUtils.removeCookie(ServletActionContext.getRequest(), ServletActionContext.getResponse(), name, ServletActionContext.getRequest().getContextPath() + "/");
	}

	// 获取真实路径
	public String getRealPath(String path) {
		return ServletActionContext.getServletContext().getRealPath(path);
	}
	
	// 获取ContextPath
	public String getContextPath() {
		return ServletActionContext.getRequest().getContextPath();
	}

	// AJAX输出
	protected String ajax(String content, String contentType) {
		try {
			HttpServletResponse response = initResponse(contentType);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	// 根据文本内容输出AJAX
	protected String ajax(String text) {
		return ajax(text, HEADER_TEXT_CONTENT_TYPE);
	}
	
	// 根据操作状态输出AJAX
	protected String ajax(OperateStatus status) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS_PARAMETER_NAME, status.getStatus());
		jsonMap.put(MESSAGE_PARAMETER_NAME, status.getMessage());
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	// 根据操作状态、消息内容输出AJAX
	protected String ajax(OperateStatus status, String message) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS_PARAMETER_NAME, status.getStatus());
		jsonMap.put(MESSAGE_PARAMETER_NAME, message);
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	// 根据操作状态、消息内容输出AJAX
	protected String ajax(OperateStatus status, String message,int count) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS_PARAMETER_NAME, status.getStatus());
		jsonMap.put(MESSAGE_PARAMETER_NAME, message);
		jsonMap.put(PASSWORD_WRONG_PARAMETER_NAME, String.valueOf(count));
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	
	// 根据操作状态、消息内容输出AJAX
	protected String ajax(OperateStatus status, String message,String value) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS_PARAMETER_NAME, status.getStatus());
		jsonMap.put(MESSAGE_PARAMETER_NAME, message);
		jsonMap.put(VALUE_PARAMETER_NAME,value);
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	// 根据Object输出AJAX
	protected String ajax(Object object) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
			JsonUtil.toJson(response, object);
		return NONE;
	}
	
	// 根据操作状态、消息内容输出AJAX
	protected String ajax(Map<String, String> jsonMap) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	// 根据boolean状态输出AJAX
	protected String ajax(boolean booleanStatus) {
		HttpServletResponse response = initResponse(HEADER_JSON_CONTENT_TYPE);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS_PARAMETER_NAME, booleanStatus);
		JsonUtil.toJson(response, jsonMap);
		return NONE;
	}
	
	private HttpServletResponse initResponse(String contentType) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType(contentType + ";charset=" + HEADER_ENCODING);
		if (HEADER_NO_CACHE) {
			response.setDateHeader("Expires", 1L);
			response.addHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		}
		return response;
	}
	
	public String getOperationDone() {
		if (isAjax(request) || request.getParameter("ajax") != null)
			return "ajaxDone";
		else
			return "alert";
	}
	
	//返回
	private String ajaxForward(int statusCode) {
		this.statusCode = statusCode;
		return OPERATION_DONE;
	}
	
	//成功
	protected String ajaxForwardSuccess(String message) {
		this.message = message;
		return ajaxForward(200);
	}
	
	//成功
	protected String ajaxForwardSuccess(String message,String callbackType) {
		this.message = message;
		this.callbackType = callbackType;
		return ajaxForward(200);
	}
	
	//失败
	protected String ajaxForwardError(String message) {
		this.message = message;
		return ajaxForward(300);
	}
	
	//失败
	protected String ajaxForwardError(String message,String callbackType) {
		this.message = message;
		this.callbackType = callbackType;
		return ajaxForward(300);
	}
	
	public String getLogInfo() {
		return logInfo;
	}
	
	public String getSystemIp() {
		return setting.getSysRealUrl();
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
	
	public AdminLoginUser getAdmin(){
		return (AdminLoginUser) getLoginUser();
	}

	public String getContextPath(HttpServletRequest request) {
		return request != null ? request.getContextPath() : "";
	}

	public String getRealPath() {
		if (realPath == null)
			realPath = ServletActionContext.getServletContext()
					.getRealPath("/");
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public long getActionExecTime() {
		return System.currentTimeMillis() - actionExecTime;
	}

	public void setActionExecTime(long actionExecTime) {
		this.actionExecTime = actionExecTime;
	}
	
	public void setLoginUser(Object value) {
		setSession(LOGIN_ADMIN_USER, value);
	}

	public Object getLoginUser() {
		return getSession(LOGIN_ADMIN_USER);
	}
    public String getJsonText()
    {
        return jsonText;
    }

    public void setJsonText(String jsonText)
    {
        this.jsonText = jsonText;
    }
	public String getImgRealUrl() {
		return setting.getImgRealUrl();
	}
	public String getImgTempUrl() {
		return setting.getImgTempUrl();
	}
}
