package com.ysm.ublog.utils;

import com.ysm.ublog.mapper.FriendCircleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import java.util.*;
@Component
public class GetKeyToRedisUtils {
    @Autowired
    private JedisPool jedisPool;
    private FriendCircleMapper friendCircleMapper;
    //存储评论
    List<String> list = new ArrayList<>();
    HashMap<String,List<String>> map;
   /* @PostConstruct//加上这个注解以后代表构造方法执行以后执行*/
    //将id放到缓存中，防止缓存穿透
    public void init(){
       // Jedis jedis = jedisPool.getResource();


}


}
