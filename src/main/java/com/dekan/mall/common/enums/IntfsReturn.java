package com.dekan.mall.common.enums;

/**
 * @ClassName ResultCode
 * @Description TODO【返回结果枚举】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public enum IntfsReturn {
	//成功
	SUCCESS(0,"操作成功"),
	//通用错误
	QUERY_LIST_FAILURE(1,"查询列表失败"),
	QUERY_LIST_BLANK(2,"查询列表为空"),
	QUERY_DETAIL_FAILURE(3,"查询记录失败"),
	QUERY_DETAIL_BLANK(4,"查询记录为空"),
	DELETE_DETAIL_FAILURE(5,"删除失败"),
	ADD_DETAIL_FAILURE(6,"添加失败"),
	UPDATE_DETAIL_FAILURE(7,"修改失败"),
	//系统错误
	UNKNOWN_WRONG(999,"未知错误"),
	SYSTEM_EXCEPTION(900,"系统异常"),
	//校验错误提示
	AUTH_FAILURE(100,"参数签名校验失败"),
	PASSWORD_WRONG(101,"密码错误"),
	PARAM_WRONG(102,"参数错误或格式不正确"),
	PARAM_BLANK(103,"参数为空"),
	MOBILE_FORMAT_WRONG(104,"手机号码格式错误或为空"),
	EMAIL_FORMAT_WRONG(105,"电子邮箱格式错误或为空"),
	
	//接口应用错误提示
	ADDRESS_NOT_EXIST(200,"联系地址不存在:"),
	VCODE_WRONG(201,"验证码错误"),
	VCODE_INVALID(202,"验证码已过有效期限"),
	SMS_SEND_FAILURE(203,"验证码发送失败"),
	MOBILE_REGISTERED(204,"手机号码已注册"),
	MOBILE_NOT_REGISTERED(205,"手机号码未注册"),
	MEMBER_NOT_EXIST(206,"会员账户不存在"),
	AREA_NOT_EXIST(207,"区域编号不存在"),
	CONTACT_PARAM_BLANK(208,"联系人为空"),
	ADDRESS_PARAM_BLANK(209,"联系地址为空"),
	PRODUCT_NOT_EXIST(210,"商品不存在"),
	ORDER_NOT_EXIST(211,"订单不存在"),
	EVALUATE_ORDER_is_EXIST(212,"订单已评价"),
	EVALUATE_ORDER_IS_NOT_EXIST(213,"订单暂未评价"),
	ORDER_NUMBER_FAILURE(214,"订购数量参数错误"),
	DELIVERY_MODE_FAILURE(215,"配送方式参数错误"),
	INVOICE_TYPE_FAILURE(216,"发票类型参数错误"),
	PAYMENT_TYPE_FAILURE(216,"支付类型参数错误"),
	MEMBER_ORDER_FAILURE(217,"订单不是该用户的订单记录"),
	MOBILE_ORDER_FAILURE(106,"手机号码异常，不能下单"),
	QUERY_DETAIL_PULLOFF(218,"商品已下架"),
	//接口错误
	INTERFACE_NOT_EXIST(10,"接口不存在"),
	ADD_ADDRESS_FAILURE(11,"添加地址失败"),
	EDIT_ADDRESS_FAILURE(12,"修改地址失败"),
	DELETE_ADDRESS_FAILURE(13,"删除地址失败"),
	DEFAULT_ADDRESS_FAILURE(14,"获取默认地址失败"),
	GETS_VCODE_FAILURE(15,"获取验证码失败"),
	REGISTER_FAILURE(16,"注册失败"),
	LOGIN_FAILURE(17,"登录失败"),
	EDIT_ACCOUNT_FAILURE(18,"修改账户失败"),
	FEEDBACK_FAILURE(19,"意见反馈失败"),
	ADD_FAVORITES_FAILURE(20,"加入收藏失败"),
	DELETE_FAVORITES_FAILURE(21,"删除收藏记录失败"),
	ADD_SCAN_FAILURE(22,"提交扫描记录失败"),
	DELETE_SCAN_FAILURE(23,"删除扫描记录失败"),
	EVALUATE_ORDER_FAILURE(24,"订单评价失败"),
	RECEIPT_ORDER_FAILURE(25,"确认收货失败"),
	REFER_ORDER_FAILURE(26,"提交订单失败"),
	AFTERMARKET_ORDER_FAILURE(27,"申请售后失败"),
	NULL_ORDER_FAILURE(28,"已抢完，下次早下手哦！"),
	ADD_SHARE_FAILURE(29,"提交分享记录失败");
		
	private  IntfsReturn(Integer code,String message){
		this.code = code;
		this.message = message;
	}
	
	/**
	* @Title valueOf
	* @Description TODO【获取ResultCode】
	* @param code
	* @return 
	* @Return ResultCode 返回类型
	* @Throws 
	*/ 
	public static IntfsReturn valueOf(int value){
		for(IntfsReturn resultCode: IntfsReturn.values()){
			if(value == resultCode.getValue()){
				return resultCode;
			}
		}
		return null;
	}
	private int value;
	private Integer code;
	private String message;
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
