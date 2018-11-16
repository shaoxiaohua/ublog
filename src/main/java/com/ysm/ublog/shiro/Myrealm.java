package com.ysm.ublog.shiro;


import com.ysm.ublog.mapper.UserMapper;
import com.ysm.ublog.user.pojo.T_user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import java.util.List;

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
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        System.out.println(SecurityUtils.getSubject().getSession().getAttribute("user")+"........");
        String salt = user.getSalt();
        ByteSource bytes = ByteSource.Util.bytes(salt);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, bytes, getName());

        return simpleAuthenticationInfo;
        }

}
