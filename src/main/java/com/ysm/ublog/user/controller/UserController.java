package com.ysm.ublog.user.controller;

import com.ysm.ublog.user.pojo.T_user;
import com.ysm.ublog.user.service.UserService;
import com.ysm.ublog.utils.FastDfsUtils;
import com.ysm.ublog.utils.MessageSendUtils;
import com.ysm.ublog.utils.RedisUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
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
    public String register(@RequestBody @Valid T_user t_user, BindingResult bindingResult) throws IOException, MyException {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(allErrors.size()>0){
            for (ObjectError error : allErrors) {
                String errormessage = error.getDefaultMessage();
                return errormessage;
            }
        }
        String originalFilename = t_user.getUser_img().getOriginalFilename();
        String ext_name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileaddress = FastDfsUtils.fileUpload(t_user.getUser_img().getBytes(), ext_name);

        System.out.println(t_user);
        userService.addUser(t_user);
        return "success register";
    }


    @RequestMapping("login")
    public T_user loginbefore(String username,String password){
        System.out.println(username+"....."+password);
        userService.login(username,password);
        T_user user = userService.getUserByUsername(username);
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


    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        T_user user = (T_user) request.getSession().getAttribute("user");
        System.out.println(user+"...........");
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        return "logout success";
    }
}
