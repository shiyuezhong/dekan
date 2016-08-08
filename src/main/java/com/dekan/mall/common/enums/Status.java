package com.dekan.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Status
 * @Description TODO【状态】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("Estatus")
public enum Status {
	Disabled(0, "停用"), Enabled(1, "启用");
	private int value;
	private String desc;

	private Status(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Status getStatus(int value){
		for(Status status:Status.values()){
			if(status.getValue()==value){
			return status;
		}
	   }
	    return null;
	}
}
