package com.dekan.mall.common.util;

import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
* @ClassName TemplateUtils
* @Description TODO【模板处理工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class TemplateUtils {
	private static final String DEFAULT_TEMPLATE_KEY = "_default_template_key";
	private static Configuration configuration;

	public static String process(String content, Map<String, Object> data) throws Exception{
		if(StringUtils.isNotBlank(content) && data != null && data.size() > 0){
			StringTemplateLoader loader = new StringTemplateLoader();
			loader.putTemplate(DEFAULT_TEMPLATE_KEY, content);
			getConfiguration().setTemplateLoader(loader);
			Template template = getConfiguration().getTemplate(DEFAULT_TEMPLATE_KEY);
			StringWriter writer = new StringWriter();
			template.process(data, writer);
			return writer.toString();
		}
		return null;
	}
	
	public static String process(String content, Map<String, Object> data,String template_key) throws Exception{
		if(StringUtils.isNotBlank(content) && data != null && data.size() > 0){
			StringTemplateLoader loader = new StringTemplateLoader();
			loader.putTemplate(template_key, content);
			getConfiguration().setTemplateLoader(loader);
			Template template = getConfiguration().getTemplate(template_key);
			StringWriter writer = new StringWriter();
			template.process(data, writer);
			return writer.toString();
		}
		return null;
	}
	
	public static Configuration getConfiguration() throws TemplateException{
		if(configuration == null){
			configuration = new Configuration();
			configuration.setSetting("classic_compatible", "true");
			configuration.setSetting("default_encoding", "utf-8");
			configuration.setSetting("template_update_delay", "6000");
			configuration.setSetting("url_escaping_charset", "utf-8");
			configuration.setSetting("locale", "zh_CN");
			configuration.setSetting("datetime_format", "yyyy-MM-dd HH:mm:ss");
			configuration.setSetting("date_format", "yyyy-MM-dd");
			configuration.setSetting("time_format", "HH:mm:ss");
			configuration.setSetting("number_format", "#.##");
			configuration.setSetting("boolean_format", "true,false");
		}
		return configuration;
	}
}
