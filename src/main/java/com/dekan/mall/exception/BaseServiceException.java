package com.dekan.mall.exception;

/**
* @ClassName BaseServiceException
* @Description TODO【Service层异常】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class BaseServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BaseServiceException(String errMessage) {
		super(errMessage);
	}

	public BaseServiceException(Throwable throwable) {
		super(throwable);
	}

	public BaseServiceException(Throwable throwable, String errMessage) {
		super(errMessage, throwable);
	}

}
