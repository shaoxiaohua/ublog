package com.ysm.ublog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RedisUtils {
    @Autowired
    static JedisPool jedisPool;

    public static void hSet(String key, Object object, Jedis jedis) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();//属性的名字
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name,aClass);
                if (propertyDescriptor != null) {

                    Method readMethod = propertyDescriptor.getReadMethod();//get方法
                    Object result = readMethod.invoke(object);
                    if (result != null) {
                        jedis.hset(key, name, result.toString());
                    }
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static int get_user_id() {
        Jedis jedis=jedisPool.getResource();
        String uidstr=jedis.get("key");
        int uid=Integer.parseInt(uidstr);
        return uid;
    }
}
