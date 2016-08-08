package com.dekan.mall.bean.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LogisticsVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class LogisticsVo implements Serializable {

	private static final long serialVersionUID = -4447995488131227010L;
	@XStreamAlias("tip")
	private String content;
	@XStreamAlias("time")
	private String operatieTime;
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the operatieTime
	 */
	public String getOperatieTime() {
		return operatieTime;
	}
	/**
	 * @param operatieTime the operatieTime to set
	 */
	public void setOperatieTime(String operatieTime) {
		this.operatieTime = operatieTime;
	}

}
