package com.dekan.mall.util;
/**
* @ClassName Cat
* @Description TODO【四位数不足的前面0补齐】
* @Author Shiyz
* @Date 2013-11-13 上午11:24:38
 */

public class Cat {
	public static String leftPad(String num, final int maxLen, char filledChar) {
		  StringBuffer sb = new StringBuffer();
		  String str = String.valueOf(num);
		  for(int i = str.length(); i < maxLen; i++){
		   sb.append(filledChar);
		  }
		  return sb.append(str).toString();
		 }
}
