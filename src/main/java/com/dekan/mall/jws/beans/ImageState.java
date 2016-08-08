package com.dekan.mall.jws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 图像规格
 * @modificationHistory.  
 * @Author Shiyz
 * @Date 2016-08-04 下午2:19:53
 */
@XmlRootElement(name = "ImageState", namespace = "http://beans.jws.bora.com")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ImageState")
public class ImageState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String preName;			//图片前辍
	private int hight;				//高
	private int width;				//宽
	private String defualt_picute;	//默认图片
	public String getPreName() {
		return this.preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public int getHight() {
		return this.hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public int getWidth() {
		return this.width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getDefualt_picute() {
		return this.defualt_picute;
	}
	public void setDefualt_picute(String defualt_picute) {
		this.defualt_picute = defualt_picute;
	}
}
