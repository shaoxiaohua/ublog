package com.ysm.ublog.utils;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateTimeUtils {

    public static Date getNowTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowtime = simpleDateFormat.format(date);
        Date parse = null;
        try {
             parse = simpleDateFormat.parse(nowtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

}
