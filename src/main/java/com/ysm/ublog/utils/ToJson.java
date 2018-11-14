package com.ysm.ublog.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ToJson {
    public static String toJson(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        String comment=null;
        try {
            comment = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return comment;
    }
}
