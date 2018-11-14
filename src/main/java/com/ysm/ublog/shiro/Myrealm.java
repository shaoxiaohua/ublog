package com.ysm.ublog.shiro;


import com.ysm.ublog.mapper.UserMapper;
import com.ysm.ublog.user.pojo.T_user;

import com.ysm.ublog.utils.RedisUtils;
import com.ysm.ublog.utils.ToJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class Myrealm extends AuthenticatingRealm {

    private UserMapper userMapper;


    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = ((UsernamePasswordToken) authenticationToken).getUsername();
        System.out.println(username+"xxxx");
        T_user user = userMapper.findUserByName(username);
        String password = user.getPassword();
       /* Integer uid = user.getId();
        Jedis jedis = jedisPool.getResource();
        RedisUtils.hSet("ysmLogin",user,jedis);
        System.out.println(jedis.("ysmLogin", uid.toString())+"xxxxx");*/
        String salt = user.getSalt();
        ByteSource bytes = ByteSource.Util.bytes(salt);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, bytes, getName());

        return simpleAuthenticationInfo;
        }

}
