package com.ysm.ublog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author hua
 * @date 2018/11/6 11:25.
 */
public class JsonUtils {
//    将对象转化为json字符串
    public static String objTojsonstr(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(object);
        return str;
    }

//    将字符串转化为对象

    public static  Object jsonstrToObj(String content,Class clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(content, clazz);
        return obj;
    }

}
