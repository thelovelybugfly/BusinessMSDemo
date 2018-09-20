package com.project.busniess.tool;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class EhUtil {
	
	private static Cache dc;
	/**
	 * 获取一个缓存对象，并进行初始化配置
	 */
	static{
		//创建缓存管理器，缓存的容器对象，管理缓存的生命周期
		CacheManager manager = CacheManager.create();
		//创建一个缓存配置
		CacheConfiguration config = new CacheConfiguration();
		config.setName("demo");
		//内存中运行存在的最大元素个数
		config.setMaxElementsInMemory(10000);
		//设置缓存中的元素是否永久存在
	   	config.setEternal(false);
	   	//设置对象最大闲置时间（秒）
	   	config.setTimeToIdleSeconds(600);
	   	//设置元素从创建到消亡的最大时间间隔
		config.setTimeToLiveSeconds(1600);
		//硬盘最大缓存元素个数
	    config.setMaxElementsOnDisk(10000000);
	    //元素移除策略LRU：最近最少使用；
	    config.setMemoryStoreEvictionPolicy("LRU");
	    //缓存，一个缓存可以包含多个元素
	    dc = new Cache(config);
		manager.addCache(dc);
	}
	
	public EhUtil(){
		
	}
	
	/**
	 * 通过键查找缓存中的元素
	 * @param key
	 * @return
	 */
	public Object find(String key){
		//需要缓存的元素，维护一个键值对Map<String,Object>
		Element e = dc.get(key);
		if(null == e)
			return null;
		else{
			Object o = e.getObjectValue();
			return o;
		}
	}
	/**
	 * 将值以键的形式存到缓存中
	 * @param key
	 * @param obj
	 */
	public void put(String key, Object obj){
		Element e = new Element(key,obj);
		dc.put(e);
	}
}
