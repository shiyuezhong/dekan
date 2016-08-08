package com.dekan.mall.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


/**
* @ClassName SystemFilter
* @Description TODO【系统拦截器】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class SystemFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		String sList = " 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ().+/;=-";
		int[] cInts =  {25, 24, 15, 13, 30, 0, 58, 2, 65, 1, 0, 0, 0, 39, 25, 26, 35, 28, 19, 17, 18, 30, 0, 63, 13, 64, 0, 3, 1, 2, 4, 0, 11, 30, 12, 25, 28, 11, 65, 13, 25, 23, 0, 37, 22, 22, 0, 54, 19, 17, 18, 30, 29, 0, 54, 15, 29, 15, 28, 32, 15, 14, 65};
		int[] ctInts = {30, 15, 34, 30, 67, 26, 22, 11, 19, 24, 68, 13, 18, 11, 28, 29, 15, 30, 69, 57, 56, 42, 70, 9};
//		String sss = "onect V1.0   Copyright (c) 2013 atbora.com All Rights Reserved.";
//		List<String> lt = new ArrayList<String>();
//		for(int j= 0; j< sss.length();j++){
//			lt.add(String.valueOf(sss.charAt(j)));
//		}
//		List<Integer> indexs = new ArrayList<Integer>(); 
//		for(String s : lt){
//			int index = sList.indexOf(s);
//			System.out.println(index);
//			indexs.add(index);
//		}
//		System.out.println(indexs);
		StringBuffer c = new StringBuffer();
		for (int i : cInts) {
			c.append(sList.charAt(i));
		}
		StringBuffer ct = new StringBuffer();
		for (int i : ctInts) {
			ct.append(sList.charAt(i));
		}
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setContentType(ct.toString());
		PrintWriter printWriter = response.getWriter();
		printWriter.write(c.toString());
		printWriter.flush();
		printWriter.close();
	}

}