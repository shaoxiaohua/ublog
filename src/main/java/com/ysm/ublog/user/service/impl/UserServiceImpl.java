package com.ysm.ublog.user.service.impl;

import com.ysm.ublog.mapper.UserMapper;
import com.ysm.ublog.user.pojo.T_user;
import com.ysm.ublog.user.service.UserService;
import com.ysm.ublog.utils.RandomNumUtils;
import com.ysm.ublog.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void addUser(T_user t_user) {
        String salt = RandomNumUtils.randomnummber(8);
        ByteSource bytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash= new SimpleHash("MD5", t_user.getPassword(), bytes, 10);
        t_user.setPassword(simpleHash.toString());
        t_user.setSalt(salt);
        Integer userId = t_user.getId();
        Jedis jedis = jedisPool.getResource();
        //先将用户存到缓存中，然后在存到数据库中
        RedisUtils.hSet("ysmUserInfo"+userId,t_user,jedis);
        //将添加的用户保存到set集合中，防止穿透。
        jedis.sadd("ysmUserLogin",userId.toString());
        System.out.println(jedis.hgetAll("ysmUserInfo"+userId)+",,,,,"+jedis.scard("ysmUserLogin"));
        jedis.close();
        userMapper.addUser(t_user);
    }

    @Override
    public void login(String username, String password) {
        if (username!=null&&password!=null){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
        }
    }

}
