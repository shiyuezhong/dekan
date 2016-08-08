/**
* @FileName WsException.java
* @Package com.dekan.mall.exception
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-7 下午8:28:05
* @Version V1.0.1
*/
package com.dekan.mall.exception;

/**
 * @ClassName BaseWsException
 * @Description TODO【Ws层异常】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class BaseWsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public BaseWsException(String errMessage) {
		super(errMessage);
	}

	public BaseWsException(Throwable throwable) {
		super(throwable);
	}

	public BaseWsException(Throwable throwable, String errMessage) {
		super(errMessage, throwable);
	}

}
