/**
* @FileName WebException.java
* @Package com.dekan.mall.exception
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-20 上午8:05:07
* @Version V1.0.1
*/
package com.dekan.mall.exception;

/**
 * @ClassName WebException
 * @Description TODO【web层错误】
 * @Author Shiyz
 * @Date 2016-08-04 上午8:05:07
 */
public class WebException extends RuntimeException {
	private static final long serialVersionUID = 7840150489970898896L;
	
	public WebException(String errMessage) {
		super(createErrMessage(errMessage));
	}

	public WebException(Throwable throwable) {
		super(throwable);
	}

	public WebException(Throwable throwable, String errMessage) {
		super(createErrMessage(errMessage), throwable);
	}

	private static String createErrMessage(String errMessage) {
		StringBuffer errMessageBuffer = new StringBuffer("");
		errMessageBuffer.append("操作失败：");
		errMessageBuffer.append(errMessage);
		errMessageBuffer.append("请稍后再试或与管理员联系！");
		return errMessageBuffer.toString();
	}

}
