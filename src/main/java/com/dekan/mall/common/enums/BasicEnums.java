package com.dekan.mall.common.enums;

/**
 * @ClassName BasicEnums
 * @Description TODO【基本枚举】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class BasicEnums {
	
	// 小数位精确方式(四舍五入、向上取整、向下取整)
		public enum RoundType {
			roundHalfUp, roundUp, roundDown
		}
		
		// 运算符(加、减、乘、除)
		public enum Operator {
			add, subtract, multiply, divide
		}

}
