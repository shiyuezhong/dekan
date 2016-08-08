package com.dekan.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName SystemType
 * @Description TODO【系统类型】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("EsystemType")
public enum SystemType {
	
	APP(0,"APP"),
	ADMIN(1,"admin"),
	OTHER(2,"other");
	
	private int value;
	private String desc;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private SystemType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public static SystemType valueOf(int value){
		for(SystemType sys: SystemType.values()){
			if(sys.getValue() == value){
				return sys;
			}
		}
		return null;
	}

}
