package com.dekan.mall.common.enums;


/**
* @ClassName SystemEnums
* @Description TODO【系统相关枚举】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
*/ 
public class SystemEnums {
	
	/**
	* @ClassName OrderRemind
	* @Description TODO【订单提醒枚举】
    * @Author Shiyz
    * @Date 2016-08-04 上午10:04:07
	*/ 
	public enum OrderRemind{
		IS_SMS(0,"是否短信提醒"),
		IS_EMAIL(1,"是否邮件提醒");
		private int value;
		private String desc;

		private OrderRemind(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
		
		/**
		* @Title valueOf
		* @Description TODO【获取枚举类型】
		* @param value
		* @return 
		* @Return OrderRemind 返回类型
		* @Throws 
		*/ 
		public OrderRemind valueOf(int value){
			for(OrderRemind remind: OrderRemind.values()){
				if(remind.getValue() == value){
					return remind;
				}
			}
			return null;
		}
		
		public int getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}
	
	/**
	* @ClassName OperateStatus
	* @Description TODO【操作状态】
    * @Author Shiyz
    * @Date 2016-08-04 上午10:04:07
	*/ 
	public enum OperateStatus {
		ERROR("n","操作失败"), SUCCESS("y","操作成功");
		private OperateStatus(String status,String message){
			this.message = message;
			this.status = status;
		}
		
		private String status;
		private String message;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	/**
	* @ClassName SmsBusinessType
	* @Description TODO【短信业务类型】
    * @Author Shiyz
    * @Date 2016-08-04 上午10:04:07
	*/ 
	public enum SmsBusinessType{
		/**
		 * 注册
		 */
		SMS_REG(0,"注册",3),
		/**
		 * 注册
		 */
		SMS_LOGIN(1,"登录",3),
		/**
		 * 支付
		 */
		SMS_PAY(2,"支付",3),
		/**
		 * 物流
		 */
		SMS_LGS(3,"物流",1),
		/**
		 * 群发
		 */
		SMS_MASS(4,"群发",1);
		
		private int value;
		private String desc;
		private int priority;
		
		private SmsBusinessType(int value, String desc,int priority) {
			this.value = value;
			this.desc = desc;
			this.priority = priority;
		}
		public int getValue() {
			return value;
		}
		public String getDesc() {
			return desc;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
	}
}
