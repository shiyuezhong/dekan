package com.dekan.mall.common.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
* @ClassName CommonUtils
* @Description TODO【工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class CommonUtils {
	
	public static final String MOBILE_REGX="^0?(13[0-9]|15[0-9]|18[0-9]|14[0-9])[0-9]{8}$";
	public static final String EMAIL_REGX="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	public static Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGX);
	public static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGX);
	public static final String FORMATPATTERN = "###########.00";
	public static final String BLANK_REGX = "\\t|\r|\n";
	
	public static final String WEB_APP_ROOT_KEY = "borMall.webAppRoot";// WebRoot路径KEY
	public static final String PATH_PREPARED_STATEMENT_UUID = "\\{uuid\\}";// UUID路径占位符
	public static final String PATH_PREPARED_STATEMENT_DATE = "\\{date(\\(\\w+\\))?\\}";// 日期路径占位符
	private static final Pattern PATTERN = Pattern.compile("[\\u4e00-\\u9fa5\\ufe30-\\uffa0]+$");// 中文配比
	
	/**
	* @Title getWebRootPath
	* @Description TODO【获取WebRoot路径】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getWebRootPath() {
		return System.getProperty(WEB_APP_ROOT_KEY);
	}
	
	
	  public static String replaceBlanks(String str) {
	        String dest = "";
	        if (str!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(str);
	            dest = m.replaceAll("");
	        }
	        return dest;
	    }
	
	/**
     * 字符串缩略
     * @param str 原字符串
     * @param width 宽度
     * @param ellipsis 省略符
	*/
	@SuppressWarnings("unused")
	private static String abbreviate(String str, Integer width, String ellipsis) {
		if (width != null) {
			int strWidth = 0;
			int strLength = 0;
			for (; strLength < str.length(); strLength ++) {
				strWidth = PATTERN.matcher(String.valueOf(str.charAt(strLength))).find() ? strWidth + 2 : strWidth + 1;
				if (strWidth > width) {
					break;
				}
			}
			if (strLength < str.length()) {
				if (ellipsis != null) {
					return str.substring(0, strLength) + ellipsis;
				} else {
					return str.substring(0, strLength);
				}
			} else {
				return str;
			}
		} else {
			if (ellipsis != null) {
				return str + ellipsis;
			} else {
				return str;
			}
		}
	}

	/**
	* @Title stringOf
	* @Description TODO【字符串】
	* @param str
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String stringOf(String str){
		if(org.apache.commons.lang.StringUtils.isBlank(str)){
			return "";
		}
		return str;
	}
	
	/**
	* @Title replaceBlank
	* @Description TODO【去掉回车，空格，换行】
	* @param str
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String replaceBlank(String str) {
		if (str != null) {
			Pattern p = Pattern.compile(BLANK_REGX);
			Matcher m = p.matcher(str);
			return  m.replaceAll("").replaceAll(", ", ",");
		}
		return "";
	}

	
	
	/**
	* @Title checkMobile
	* @Description TODO【验证数据号码】
	* @param mobile
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public static boolean verifyMobile(String mobile){
		if(StringUtils.isBlank(mobile)){
			return false;
		}
		return MOBILE_PATTERN.matcher(mobile).find();
	}
	
	/**
	* @Title verifyMobile
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param mobiles
	* @param split
	* @return 
	* @Return String[] 返回类型
	* @Throws 
	*/ 
	public static String[] verifyMobiles(String s,String sp){
		List<String> mobileList = new ArrayList<String>();
		if(StringUtils.isNotBlank(s) && StringUtils.isNotBlank(sp)){
			String [] mobiles = s.split(sp);
			if(mobiles != null && mobiles.length > 0){
				for(String m: mobiles){
					if(verifyMobile(m)){
						mobileList.add(m);
					}
				}
				if(mobileList != null && mobileList.size() > 0){
					return (String[]) mobileList.toArray(new String[mobileList.size()]);
				}
			}
		}
		return null;
	}
	
	/**
	* @Title checkEmail
	* @Description TODO【验证邮件地址】
	* @param email
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public static boolean verifyEmail(String email){
		if(StringUtils.isBlank(email)){
			return false;
		}
		return EMAIL_PATTERN.matcher(email).find();
	}
	
	/**
	* @Title randomCode
	* @Description TODO【生成验证码】
	* @param length
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String randomCode(int length){
		if(length <= 0){
			return null;
		}
		String code="";
		// 生成随机类
		Random random = new Random();
		for(int i=0;i<length;i++){
			code+=String.valueOf(random.nextInt(10));
		}
		return code;
	}
	
	/**
	* @Title randomPasswd
	* @Description TODO【生成密码】
	* @param length
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String randomPasswd(int length){
		String temp = "0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		int range = temp.length();
		for (int i = 0; i < length; i++) {
			buffer.append(temp.charAt(random.nextInt(range)));
		}
		return buffer.toString();
	}
	
	/**
	* @Title getDoubleByFormat
	* @Description TODO【数据格式化】
	* @param num
	* @return 
	* @Return Double 返回类型
	* @Throws 
	*/ 
	public static Double getDoubleByFormat(Double num){
		DecimalFormat df = new DecimalFormat(FORMATPATTERN);
		return Double.valueOf(df.format(num));
	}
	
	/**
	* @Title getUUID
	* @Description TODO【随机获取UUID字符串(无中划线)】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit&action=edit&lang=zh_CN&token=2035039219&type=11&appmsgid=200709091&isMul=1";
        Pattern pat = Pattern.compile("&token=(\\w){10}&");
        Matcher mat = pat.matcher(str);
        while (mat.find()) {
            System.out.println(str.replace(mat.group(), "&token=TOKEN&"));
        }
        
		
		
		
		/*String issuerIdView="%C4%FE%B2%A8%D2%F8%D0%D0";
		String valueStr = URLDecoder.decode(issuerIdView,"utf-8");
		System.out.println(valueStr);
		String valueStr3 = new String(valueStr.getBytes("utf-8"), "gbk");
		System.out.println(valueStr3);*/
		//String valueStr2 = new String(valueStr3.getBytes("utf-8"), "gbk");
		//System.out.println(valueStr2);
	/*	BigDecimal totalAmount = new BigDecimal("1.999");
		BigDecimal totalAmount1 = new BigDecimal("1.990");
		BigDecimal totalAmount2 = new BigDecimal("1.994");
		BigDecimal totalAmount3 = new BigDecimal("1.995");
		BigDecimal totalAmount5 = new BigDecimal("1.900");
		BigDecimal totalAmount6 = new BigDecimal("1.909");
		BigDecimal totalAmount7 = new BigDecimal("1.904");
		BigDecimal totalAmount8 = new BigDecimal("1.905");
		
		System.out.println(totalAmount + "-"+ NumberUtils.setPriceScale(totalAmount, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount1 + "-"+ NumberUtils.setPriceScale(totalAmount1, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount2 + "-"+ NumberUtils.setPriceScale(totalAmount2, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount3 + "-"+ NumberUtils.setPriceScale(totalAmount3, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount5 + "-"+ NumberUtils.setPriceScale(totalAmount5, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount6 + "-"+ NumberUtils.setPriceScale(totalAmount6, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount7 + "-"+ NumberUtils.setPriceScale(totalAmount7, 2, RoundType.roundHalfUp));
		System.out.println(totalAmount8 + "-"+ NumberUtils.setPriceScale(totalAmount8, 2, RoundType.roundHalfUp));
		*/
		//System.out.println(AccessTokenRequestHandler.getAccessToken());
		//Random random = new Random();
		//System.out.println(Math.random());
		//System.out.println(abbreviate("你好你好你好",1,"*"));
		/*System.out.println(System.currentTimeMillis());
		for(int i = 0; i<2 ; i ++){
			System.out.println(System.currentTimeMillis());
		}
		
		String s = "15869126351";
		String[] ms = CommonUtils.verifyMobiles(s, ",");
		if(ms != null && ms.length > 0){
			for(String m : ms ){
				System.out.println(m);
			}
		}*/
		
	/*	String successDetails = "5a1007aeafb143c1a2a5^15869126351@139.com^王旭^0.09^S^^20140415376296664^20140415195059|";
		
		String[] successDetail = successDetails.split("\\|");
		if(successDetail != null && successDetail.length > 0){
			for(String d: successDetail){
				if(StringUtils.isNotBlank(d)){
					String[] detail = d.split("\\^");
					if(detail != null && detail.length > 0){
						//String sn = detail[0];
						System.out.println(detail[0]);
						System.out.println(detail[4]);
						String status  = detail[4];
						System.out.println(detail);
						if(status.equals("S")){//成功
							System.out.println(13);
						}
					}
				}
			}
		}*/
		
		/*String sn = "2012112313581219";
		Integer tt = sn.indexOf("_");
		System.out.println("tt:"+tt);
		System.out.println("start:"+sn);
		String[] nums = sn.split("_");
	    String preIndex = nums[0];
	    Integer num = Integer.parseInt(nums[1]);
	    num ++;
		sn = preIndex + "_" +num;
		System.out.println("end:"+sn);*/
		
	/*	URL url;
		try {
			url = new URL("http://www.qq.com");
			try {
				url.openConnection().connect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		
	}
	
	
	
}
