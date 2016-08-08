package com.dekan.mall.common.util;

import java.io.Writer;

import com.dekan.mall.common.converters.MapConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import com.thoughtworks.xstream.mapper.DefaultMapper;
/**
* @ClassName XmlUtils
* @Description TODO【输出xml和解析xml的工具类】
* @Author jonny
* @Date 2013-9-11 下午3:49:59
 */
public class XmlUtils {
	
	private static XStream jsonXstream = null; //定义
	private static XStream xmlXstream = null; //定义
	
	static{
		if(jsonXstream == null){
			jsonXstream = new XStream(new JettisonMappedXmlDriver() {
				public HierarchicalStreamWriter createWriter(Writer out) {
					return new JsonWriter(out, JsonWriter.DROP_ROOT_MODE);        
					}  
			});
			jsonXstream.setMode(XStream.NO_REFERENCES);
			jsonXstream.autodetectAnnotations(true);
		}
		if(xmlXstream == null){
			xmlXstream=new XStream();
			xmlXstream.registerConverter(new MapConverter(new DefaultMapper(XStream.class.getClassLoader())));  
			xmlXstream.autodetectAnnotations(true);
		}
		
	}

	/**
	 * java 转换成xml
	 * @Title: toXml 
	 * @Description: TODO 
	 * @param obj 对象实例
	 * @return String xml字符串
	 */
	public static String toXml(Object obj){
		return xmlXstream.toXML(obj);
	}
	
	/**
	 * java 转换成Json
	 * @Title: toJson 
	 * @Description: TODO 
	 * @param obj 对象实例
	 * @return String xml字符串
	 */
	public static String toJson(Object obj){
		return jsonXstream.toXML(obj);
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T  toObject(String jsonStr,Class<T> cls){
		 XStream xstream = new XStream(new JettisonMappedXmlDriver());  
		 xstream.alias("res", cls);  
		 xstream.autodetectAnnotations(true);
         T obj=(T)xstream.fromXML(jsonStr);
        return obj;        
    } 
	
	@SuppressWarnings("unchecked")
	public static <T> T  toObjectList(String jsonStr,Class<T> cls){
		 XStream xstream = new XStream(new JsonHierarchicalStreamDriver());  
		 xstream.alias("res", cls);  
		 xstream.autodetectAnnotations(true);
         T obj=(T)xstream.fromXML(jsonStr);
        return obj;        
    } 
    
}
