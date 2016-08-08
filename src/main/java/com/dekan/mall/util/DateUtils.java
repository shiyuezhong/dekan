package com.dekan.mall.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * @ClassName DateUtils
 * @Description TODO【时间的工具类】
 * @Author Shiyz
 * @Date 2013-10-23 下午2:15:42
 */
public class DateUtils {
 
	/*****
	 * 获取一段时间
	 * @return
	 */
	public static List<Date> getDateList(int num,String type,Date endDate){
		List<Date> dateList = new ArrayList<Date>();
		for(int i = num-1; i >= 0; i--){
	        Calendar rightNow = Calendar.getInstance();
	        if(endDate == null){
	        	endDate = new Date();
	        }
	        rightNow.setTime(endDate);
	        if("date".equals(type)){
	        	rightNow.add(Calendar.DATE,-i);
	        }else if("month".equals(type)){
	        	rightNow.add(Calendar.MONTH,-i);
	        }else if("year".equals(type)){
	        	rightNow.add(Calendar.YEAR,-i);
	        }
	        Date dt1=rightNow.getTime();
	        dateList.add(dt1);
		}
		return dateList;
	}
	 
}
