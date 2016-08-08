package com.dekan.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Bool
 * @Description TODO【是否】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@Alias("Ebool")
public enum Bool {
	FALSE(0, "否"), TRUE(1, "是");
	private int value;
	private String desc;

	private Bool(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Bool valueOf(int value){
		for(Bool bool:Bool.values()){
			if(bool.getValue()==value){
			return bool;
		}
	   }
	    return null;
	}
}
