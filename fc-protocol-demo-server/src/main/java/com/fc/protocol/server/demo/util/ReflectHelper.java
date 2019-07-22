package com.fc.protocol.server.demo.util;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


/**
 * <p>Title: ReflectHelper</p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author wanghw
 * @date 2016年3月20日 
 */
public class ReflectHelper {

	/**
	 * 
	 * @param map
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToEntity(Map<String, Object> map, Class<T> cls) throws Exception {    
	     if(map!=null){ 
	        T t = cls.newInstance();  
	        BeanUtils.populate(t, map);
	        return t;  
	     }
	     return null;
    }    
	
	/**
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> EntityToMap(Object o) throws Exception{
		return PropertyUtils.describe(o);
	}
	
	/**
	 * 
	 * @param bean
	 * @param name
	 * @param value
	 * @throws Exception
	 */
	public static void setProperty(Object bean,String name,Object value) throws Exception{
		Field field = bean.getClass().getDeclaredField(name);
		if (!field.isAccessible()) {
			field.setAccessible(true);
		} 
		field.set(bean, value);
	}
}
