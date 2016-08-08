package com.dekan.mall.bean.dto;

import java.io.Serializable;

/**
 * @ClassName CommonDto
 * @Description TODO【Dto】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class CommonDto implements Serializable {
	private static final long serialVersionUID = 3947532001492170635L;
	
	private String code;
	private String name;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
