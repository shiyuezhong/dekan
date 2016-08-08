package com.dekan.mall.web.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @ClassName DateTypeConverter
* @Description TODO【struts日期转换器】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class DateTypeConverter extends StrutsTypeConverter {
	private static final Logger logger = LoggerFactory.getLogger(DateTypeConverter.class);
	private static final DateFormat S_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat M_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat MONTH_FORMAT = new SimpleDateFormat("yyyy-MM");
	private static final DateFormat MONTHS_FORMAT = new SimpleDateFormat("yyyyMM");
	private static final DateFormat SECOND_FORMAT = new SimpleDateFormat("HH:mm:ss");
	private static final DateFormat MINUTE_FORMAT = new SimpleDateFormat("HH:mm");
	private static final DateFormat BIRTH_FORMAT = new SimpleDateFormat("MM-dd");

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		try {
			if (StringUtils.isBlank(values[0]))
				return null;
			if (toClass.equals(Date.class)) {
				switch (values[0].length()) {
				case 19:
					return S_TIME_FORMAT.parseObject(values[0]);
				case 16:
					return M_TIME_FORMAT.parseObject(values[0]);
				case 10:
					return DATE_FORMAT.parseObject(values[0]);
				case 6:
					return MONTHS_FORMAT.parseObject(values[0]);
				case 7:
					return MONTH_FORMAT.parseObject(values[0]);
				case 8:
					return SECOND_FORMAT.parseObject(values[0]);
				case 5:
					if(values[0].contains("-")){
						return BIRTH_FORMAT.parseObject(values[0]);
					}else{
						return MINUTE_FORMAT.parseObject(values[0]);
					}
				default:
					return null;
				}

			}
		} catch (ParseException e) {
			logger.error("converter Date error with in method convertFromString(Map context, String[] values, Class toClass)",e);
		}
		return null;
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		try {
			if (o instanceof Date) {
				return S_TIME_FORMAT.format((Date) o);
			}
		} catch (RuntimeException e) {
			logger.error("converter String error with in method convertToString(Map context, Object o)",e);
		}
		return null;
	}
}
