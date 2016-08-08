package com.dekan.mall.common.constant;

/**
 * @ClassName SystemConstants
 * @Description TODO【系统配置参数】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class SystemConstants {
	
	public static final String INTF_SERVICE_MAPPING_URL = "/services/intfs/"; //接口服务请求URL
	public static final String INTF_ACTION_SUFFIX = ".ac"; //接口请求后缀
	public static final String DEFAULT_REDIRECT_URL = "/admin/welcome/main.do"; //默认重定向请求地址
	public static final String PAYMENT_NOTIFY_SUFFIX = ".htm"; //支付通知后缀
	public static final String PAYMENT_NOTIFY_AC = "payment/notify"; //支付通知字符串
	public static final String PAY_NOTIFY_HTM = "pay_notify"; //支付通知字符串
	public static final String SETTLE_NOTIFY_HTM = "settle_alipay_pay_notify"; //结算支付通知字符串
	public static final String REDIRECT_URL_HTM = "r_u"; //重定向url通知字符串
	public static final String HTTP_LOWER = "http://"; //HTTP下写
	public static final String HTTP_UPPER = "HTTP://"; //HTTP大写
	public static final String SLASH_DELIMITER = "/"; //斜杠分割符
	public static final String UNDER_LINE_DELIMITER = "_"; //下划线分割符
	public static final String CTRL_DELIMITER = "^"; //下划线分割符
	public static final boolean IS_LOGIN_FAILURE_LOCK = true; //登录失败是否进行锁定
	public static final int ORDER_CANCEL_LIMIT_M_TIME =  30; //取消订单限制30分钟
	public static final int ORDER_CANCEL_LIMIT_H_TIME =  24; //取消订单限制24小时
	public static final int ORDER_RECEIPTED_LIMIT_TIME = 10; //订单收货限制时间10天
	public static final int LOGIN_FAILURE_LOCK_TIME = 10; //锁定10分钟
	public static final int LOGIN_FAILURE_LOCK_COUNT = 5;//登录最大次数
	public static final String CREATE_DATE_FIELD = "create_date"; //创建时间字段名
	public static final String MODIFY_DATE_FIELD = "modify_date";//修改时间字段名
	public static final String ID_FIELD = "id";//ID字段名
	public static final String SN_FIELD = "sn"; //SN字段名
	public static final String CODE_FIELD = "code";//CODE字段名
	public static final String AUTO_OPERATOR = "sys_auto"; //自动处理操作员
	public static final String BLANK_STRING = ""; //空格字符
	public static final String HEADER_ENCODING = "UTF-8"; //请求头部编码
	public static final boolean HEADER_NO_CACHE = true; //请求头部是否缓存
	public static final String HEADER_TEXT_CONTENT_TYPE = "text/plain"; //请求头部字符串格式
	public static final String HEADER_JSON_CONTENT_TYPE = "text/plain"; //请求头部字符串格式
	public static final String REQUEST_PARAMS_KEY = "request_params_key"; //请求参数KEY
	public static final String RESULT_PARAMS_KEY = "result_params_key";//返回参数KEY
	public static final String ACTION_METHOD = "action_method"; //请求方法key
	public static final String PAY_REQUEST_PARAMS_KEY = "pay_request_params_key"; //支付字符包请求参数KEY
	public static final String PAY_RESULT_PARAMS_KEY = "pay_result_params_key";//支付返回请求参数KEY
	public static final String PAYMENT_PRODUCT_RESULT__PARAMS_KEY = "payment_product_result__params_key";//支付产品返回请求参数KEY
	public static final String PARAMS = "para"; //请求参数
	public static final String VERIFY_PARAMS = "\"para\":";  //验证字符串
	public static final String VERIFY_AUTHS = "\"auth\":";   //验证字符串
	public static final String XML_TOP_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";   //xml top
	public static final String WRAP_CHARACTER = "\r\n";   //xml top
	
	public static final String COLON = ":"; //冒号
}

