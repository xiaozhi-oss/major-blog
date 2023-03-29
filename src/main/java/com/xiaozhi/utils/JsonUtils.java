package com.xiaozhi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/14 21:57
 */
public class JsonUtils {

    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm");
    }

    public static String getJson(Object object,String dateFormat) {
        ObjectMapper mapper = new ObjectMapper();
        // 设置不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,false);
        // 自定义时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(simpleDateFormat);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
