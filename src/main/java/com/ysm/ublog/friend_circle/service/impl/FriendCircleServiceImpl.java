package com.ysm.ublog.friend_circle.service.impl;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import com.ysm.ublog.friend_circle.entity.T_friend_circle_message;
import com.ysm.ublog.friend_circle.service.FriendCircleService;
import com.ysm.ublog.mapper.FriendCircleMapper;
import com.ysm.ublog.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class FriendCircleServiceImpl implements FriendCircleService {
    @Autowired
    private FriendCircleMapper frinendCircleMapper;
    @Autowired
    private JedisPool jedisPool;

    //将朋友圈的信息存到缓存中
    @Override
    @Transactional
    public void addFriendMessage(T_friend_circle_message t_friend_message) {
        Jedis jedis = jedisPool.getResource();
        RedisUtils.hSet("ysmmessage"+t_friend_message.getId(),t_friend_message,jedis);
        frinendCircleMapper.addFriendMessage(t_friend_message);
        System.out.println(t_friend_message.getId());
        jedis.close();
    }
   //添加评论
    @Override
    public void addComment(T_friend_circle_comment t_friend_circle_comment) {
        Jedis jedis = jedisPool.getResource();
        String nowtime = t_friend_circle_comment.getCreate_time().toString();
        Integer fcmid = t_friend_circle_comment.getFcmid();
        //key是朋友圈id，字段名是用户id+创建时间，value是创建时间
        jedis.hset("ysmComment"+fcmid,t_friend_circle_comment.getUid()+nowtime,t_friend_circle_comment.getContent());
        //有缓存代表成功存到缓存
        System.out.println(jedis.hgetAll("ysmComment" + fcmid)+"xxxxxx");
        frinendCircleMapper.addComment(t_friend_circle_comment);
        jedis.close();
    }

   //获得所有的朋友圈内容
    @Override
    public List<T_friend_circle_message> getAllMessage() {
        List<T_friend_circle_message> messages = frinendCircleMapper.getAllMessage();
        return messages;
    }

    //得到所有的朋友圈id
    @Override
    public List<String> getAllKey() {
        List<String> keys = frinendCircleMapper.getAllMessageKey();
        return keys;
    }


}
