package com.dekan.mall.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

public class DateUtils {
	//private static final Integer MORNING_HOUR_POINT = 12;
	private static final long ND = 1000*24*60*60;//一天的毫秒数
	private static final long NH = 1000*60*60;//一小时的毫秒数
	private static final long NM = 1000*60;//一分钟的毫秒数
	//private static final long NS = 1000;//一秒钟的毫秒数
	private static final DateFormat S_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat S_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String dtLong                  = "yyyyMMddHHmmss";

	
	public static Date addMinute(Date date, int minute){
		Calendar calendar = GregorianCalendar.getInstance();
		if(date != null){
			calendar.setTime(date);
		}
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+minute);
		return calendar.getTime();
	}
	
	/** 
	* @Title: getCurrMonthFistDate 
	* @Description: 获取当前日期所在月份的第一天日期TODO
	* @param @param date
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws 
	*/
	public static Date getCurrMonthFistDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);    
		cal.set(Calendar.DATE,1);//设为当前月的1 号       
		return cal.getTime();
	}
	
	/** 
	* @Title: getCurrMonthLastDate 
	* @Description: 获取当前日期所在月份的最后一天的日期TODO
	* @param @param date
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws 
	*/
	public static Date getCurrMonthLastDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set( Calendar.DATE, 1 );  
		cal.roll(Calendar.DATE, - 1 );  
		return cal.getTime();
	}
	
	
	/** 
	* @Title: getCurrDatePreDate 
	* @Description: TODO
	* @param @param date
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws 
	*/
	public static Date getCurrDatePreDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,  - 1 );  
		return cal.getTime();
	}
	
	/** 
	* @Title: getHoursDiff 
	* @Description: TODO
	* @param @param startTime
	* @param @param endTime
	* @param @return    设定文件 
	* @return float    返回类型 
	* @throws 
	*/
	public static float getHoursDiff(Date startTime,Date endTime){
		float result = 0.0f;
		if(startTime!=null&&endTime!=null){
			if(startTime.getTime()<= endTime.getTime()){
				result = (endTime.getTime()-startTime.getTime())/NH;
			}
		}
		return result;
	}
	
	/** 
	* @Title: getDatesDiff 
	* @Description: TODO
	* @param @param startTime
	* @param @param endTime
	* @param @return    设定文件 
	* @return float    返回类型 
	* @throws 
	*/
	public static int getDatesDiff(Date startTime,Date endTime){
		int result = -1;
		Calendar startCalendar = Calendar.getInstance();   
		startCalendar.setTime(startTime);   
		startCalendar.set(Calendar.HOUR_OF_DAY, 0);   
		startCalendar.set(Calendar.MINUTE, 0);   
		startCalendar.set(Calendar.SECOND, 0);   
		startCalendar.set(Calendar.MILLISECOND, 0);   
  
        Calendar endCalendar = Calendar.getInstance();   
        endCalendar.setTime(endTime);   
        endCalendar.set(Calendar.HOUR_OF_DAY, 0);   
        endCalendar.set(Calendar.MINUTE, 0);   
        endCalendar.set(Calendar.SECOND, 0);   
        endCalendar.set(Calendar.MILLISECOND, 0);   
		result = (int) ((endCalendar.getTime().getTime()-startCalendar.getTime().getTime())/ND);
		return result;
	}
	
	/** 
	* @Title: getMinutesDiff 
	* @Description: TODO
	* @param @param startTime
	* @param @param endTime
	* @param @return    设定文件 
	* @return long    返回类型 
	* @throws 
	*/
	public static long getMinutesDiff(Date startTime,Date endTime){
		long result = 0l;
		if(startTime!=null&&endTime!=null){
			if(startTime.getTime()<= endTime.getTime()){
				result = (endTime.getTime()-startTime.getTime())/NM;
			}
		}
		return result;
	}
	
	public static String formatString(Date date, String pattern){
		if(date == null || StringUtils.isBlank(pattern))
			return null;
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static long getNowDateTime(Date date){
		return date.getTime();
	}
	
	/**
	* @Title getStartDate
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param date
	* @return 
	* @Return Date 返回类型
	* @Throws 
	*/ 
	public static Date getStartDate(Date date){
		if(date != null){
			String dateStr = formatString(date,"yyyy-MM-dd");
			if(StringUtils.isNotBlank(dateStr)){
				dateStr += " 00:00:01";
				try {
					return S_TIME_FORMAT.parse(dateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return date;
	}
	
	public static Date getEndDate(Date date){
		if(date != null){
			String dateStr = formatString(date,"yyyy-MM-dd");
			if(StringUtils.isNotBlank(dateStr)){
				dateStr += " 23:59:59";
				try {
					return S_TIME_FORMAT.parse(dateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return date;
	}
	
	
	/**
	* @Title getStartDate
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param date
	* @return 
	* @Return Date 返回类型
	* @Throws 
	*/ 
	public static Date getStartDate(String dateStr){
			if(StringUtils.isNotBlank(dateStr)){
				try {
					return S_DATE_FORMAT.parse(dateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		return null;
	}
	
	public static Date getEndDate(String dateStr){
			if(StringUtils.isNotBlank(dateStr)){
				try {
					return S_DATE_FORMAT.parse(dateStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		return null;
	}
	
	
	/**
	* @Title getSn
	* @Description TODO【获取系统当前时间】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public  static String getSn(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtLong);
		return df.format(date);
	}
	
	/**
	* @Title isSameDay
	* @Description TODO【判断两日前是否为同一天】
	* @param day1
	* @param day2
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public static boolean isSameDay(Date day1, Date day2) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String ds1 = sdf.format(day1);
	    String ds2 = sdf.format(day2);
	    if (ds1.equals(ds2)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	
}

