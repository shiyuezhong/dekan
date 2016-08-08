package com.dekan.mall.util;
/**
 * @author shiyz
 * @Time 2013-04-11 10:15:42
 * @describe Service层工具类
 */
public class ServiceUtils {
	/**
	 * @describe 根据某个id去得到图片存在服务器上的路径
	 * @param str 图片对应的对象的id或者需求id，
	 * @param result 返回的结果
	 * @return  图片的路径
	 */
	public static String getImgPath(String imageObjId){
		 if(imageObjId.length() > 2){
			 String  result = imageObjId.substring(0, 2);
			 for(int i = 2 ; i < imageObjId.length();){
				 if(i+2 <= imageObjId.length()) 
					 result = result + "/"+imageObjId.substring(i, i+2);
				 else
					result = result + "/"+imageObjId.substring(i, imageObjId.length());
				 i = i+2;
			 }
			 return result +"/";
		 }
		 return imageObjId+"/";
	}
	
	public static void main(String[] args) {
		System.out.println(getImgPath("1019900"));
	}
}
