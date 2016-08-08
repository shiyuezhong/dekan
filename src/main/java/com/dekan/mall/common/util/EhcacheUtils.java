package com.dekan.mall.common.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
* @ClassName EhcacheUtils
* @Description TODO【Ehcache缓存工具类】
* @Author Shiyz
* @Date 2016-08-04 上午10:04:07
*/ 
public class EhcacheUtils {

	private static Cache cache;

	/**
	* @Title put
	* @Description TODO【数据以键值方式存入缓存，并设置缓存数据有效时间】
	* @param key
	* @param obj
	* @param timeToLive 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public static void put(String key,Object obj,int timeToLive) {
		Element element = new Element(key, obj);
		if (timeToLive != 0) {
			element.setTimeToLive(timeToLive);
		}
		getCache().put(element);
	}
	
	/**
	* @Title put
	* @Description TODO【数据以键值方式存入缓存】
	* @param key
	* @param obj 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public static void put(String key,Object obj) {
		Element element = new Element(key, obj);
		getCache().put(element);
	}


	/**
	* @Title get
	* @Description TODO【根据缓存键值读取缓存数据对象】
	* @param key
	* @return 
	* @Return Object 返回类型
	* @Throws 
	*/ 
	public static Object get(String key) {
		Cache cache = getCache();
		Element element = cache.get(key);
		if(element != null) {
			return element.getObjectValue();
		}
		return null;
	}

	/**
	* @Title remove
	* @Description TODO【根据缓存键值删除缓存数据对象】
	* @param key 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public static void remove(String key) {
		Cache cache = getCache();
		cache.remove(key);
	}
	
	/**
	* @Title getCache
	* @Description TODO【根据对应目录获取缓存】
	* @return 
	* @Return Cache 返回类型
	* @Throws 
	*/ 
	private static Cache getCache(){
		if(cache == null){
			cache = CacheManager.getInstance().getCache("com.dekan.mall.TempCache");
		}
		return cache;
	}
}
