package com.ysm.ublog.user.controller;

import com.ysm.ublog.user.pojo.T_user;
import com.ysm.ublog.user.service.UserService;
import com.ysm.ublog.utils.MessageSendUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JedisPool jedisPool;
    private Jedis jedis;
    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    //添加hibernate-validator注解，注册直接将信息存到数据库中，没有存到缓存中
    public String register(@RequestBody @Valid T_user t_user, BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(allErrors.size()>0){
            for (ObjectError error : allErrors) {
                String errormessage = error.getDefaultMessage();
                return errormessage;
            }
        }
        System.out.println(t_user);
        userService.addUser(t_user);
        return "success register";
    }


    @RequestMapping("login")
    public T_user loginbefore(String username,String password){
        System.out.println(username+"....."+password);
        userService.login(username,password);
        T_user user = userService.getUserByUsername(username);
        System.out.println(user);
        return user;
    }


    @RequestMapping("/mobilecode")
    public String mobileCode(String mobile){
        jedis = jedisPool.getResource();
        String random = MessageSendUtils.messageSendAndgetRandom(mobile);
        jedis.hset("ysmCode","usercode",random);
        jedis.expire("ysmCode",60);
        jedis.close();
        return random;
    }
    @RequestMapping("/checkcode")
    public String checkCode(String mycode){
        String code = jedis.get("ysmCode");
        if(mycode!=null&&mycode.trim().equalsIgnoreCase(code)){
            return "success by phone";
        }
        return "code error!";
    }

    @RequestMapping("error")
    public String error(){
        return "login error";
    }
}
