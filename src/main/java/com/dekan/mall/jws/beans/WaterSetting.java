package com.dekan.mall.jws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 水印设置
 * @modificationHistory.  
 * @Author Shiyz
 * @Date 2016-08-04 下午2:19:53
 */
@XmlRootElement(name = "WaterSetting", namespace = "http://beans.jws.bora.com")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "WaterSetting")
public class WaterSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;		//水印类型
	private String label;		//水印标签
	private int location;		//位置
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return this.label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getLocation() {
		return this.location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
}
