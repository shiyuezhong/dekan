package com.dekan.mall.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;

import com.dekan.mall.common.enums.BasicEnums.RoundType;

/**
* @ClassName NumberUtils
* @Description TODO【数字工具列】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class NumberUtils {
	
	/**
	* @Title setPriceScale
	* @Description TODO【设置数字取整类型】
	* @param price
	* @param priceScale
	* @param priceRoundType
	* @return 
	* @Return BigDecimal 返回类型
	* @Throws 
	*/ 
	public static BigDecimal setPriceScale(BigDecimal price,Integer priceScale,RoundType priceRoundType) {
		if (price != null) {
			if (priceRoundType == RoundType.roundHalfUp) {
				return price.setScale(priceScale, BigDecimal.ROUND_HALF_UP);
			} else if (priceRoundType == RoundType.roundUp) {
				return price.setScale(priceScale, BigDecimal.ROUND_UP);
			} else {
				return price.setScale(priceScale, BigDecimal.ROUND_DOWN);
			}
		}
		return null;
	}
	
	/**
	* @Title getCurrencyFormat
	* @Description TODO【返回数字格式】
	* @param priceScale
	* @param currencySign
	* @param currencyUnit
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getCurrencyFormat(Integer priceScale,String currencySign,String currencyUnit) {
		if (priceScale == 0) {
			return "'" + currencySign + "'#0'" + currencyUnit + "'";
		} else if (priceScale == 1) {
			return "'" + currencySign + "'#0.0'" + currencyUnit + "'";
		} else if (priceScale == 2) {
			return "'" + currencySign + "'#0.00'" + currencyUnit + "'";
		} else if (priceScale == 3) {
			return "'" + currencySign + "'#0.000'" + currencyUnit + "'";
		} else if (priceScale == 4) {
			return "'" + currencySign + "'#0.0000'" + currencyUnit + "'";
		} else {
			return "'" + currencySign + "'#0.00000'" + currencyUnit + "'";
		}
	}
	
	/**
	* @Title getCurrencyFormat
	* @Description TODO【货币格式】
	* @param priceScale
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getCurrencyFormat(Integer priceScale) {
		if (priceScale == 0) {
			return "#0";
		} else if (priceScale == 1) {
			return "#0.0";
		} else if (priceScale == 2) {
			return "#0.00";
		} else if (priceScale == 3) {
			return "#0.000";
		} else if (priceScale == 4) {
			return "#0.0000";
		} else {
			return "#0.00000";
		}
	}
	
	
	
	/**
	* @Title currencyFormat
	* @Description TODO【货币格式化】
	* @param price
	* @param priceScale
	* @param currencySign
	* @param currencyUnit
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String currencyFormat(BigDecimal price,Integer priceScale,String currencySign,String currencyUnit) {
		String currencyFormat = "";
		if(StringUtils.isBlank(currencySign) || StringUtils.isBlank(currencyUnit) ){
			currencyFormat = getCurrencyFormat(priceScale);
		}else{
			currencyFormat = getCurrencyFormat(priceScale,currencySign,currencyUnit);
		}
		NumberFormat numberFormat = new DecimalFormat(currencyFormat);
		return numberFormat.format(price);
	}
	
	
	
}
