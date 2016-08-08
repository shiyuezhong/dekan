package com.dekan.mall.common.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符串转换编码
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class StringEncode {

	/**
	 * 将ISO-8859-1编码字符串转换UTF-8编码
	 * @param param
	 * @return
	 */
	public static String toUTF8(String param) {
		if (param == null) {
			return null;
		} else {
			try {
				param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
//				byte[] bs = param.getBytes();
//				param = new String(bs, "UTF-8"); å¦     否
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return param;
			}
		}
		return param;
	}
	
//	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println(toUTF8("å¦"));
//	}
}
