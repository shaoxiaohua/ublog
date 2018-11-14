package com.ysm.ublog.utils;

import com.sun.javaws.jnl.PropertyDesc;
import redis.clients.jedis.Jedis;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//将对象保存到缓存中
public class RedisUtils {

    public static void hSet(String key, Object object, Jedis jedis){
        //获取对象中的属性，并将其添加到缓存中
        Field[] fields = object.getClass().getDeclaredFields();
        if(fields!=null){
            for (Field field : fields) {
                String name = field.getName();

                PropertyDescriptor propertyDescriptor = null;
                try {
                    propertyDescriptor = new PropertyDescriptor(name,object.getClass());
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                }
                if(propertyDescriptor!=null) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                            if (readMethod != null) {
                                try {
                                    Object result = readMethod.invoke(object);

                                    if (result!=null){
                                    jedis.hset(key, name, result.toString());
                                    }
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
            }
        }
    }
}
