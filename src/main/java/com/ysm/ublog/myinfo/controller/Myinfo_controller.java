package com.ysm.ublog.myinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysm.ublog.myinfo.pojo.*;
import com.ysm.ublog.myinfo.service.Myinfo_service;
import com.ysm.ublog.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/myinfo")
public class Myinfo_controller {
    @Autowired
    Myinfo_service myinfo_service;

    @RequestMapping("/find_new_friend")
    @CrossOrigin
    public Result_pojo find_new_friend(@RequestBody Find_newfriend find_newfriend){
        List<Re_find_newfriend> list=myinfo_service.findnewfriends(find_newfriend);
        try {
            Result_pojo result_pojo=new Result_pojo(list,0,"成功");
            return (result_pojo);
        } catch (Exception e) {
            return (new Result_pojo(null,3001,"根据要求查找新朋友失败"));
        }

    }

    @RequestMapping("/look_one_people")
    @CrossOrigin
    public Result_pojo look_one_people(Integer id){
        try{
            Find_newfriend find_newfriend=myinfo_service.find_onepeople_by_id(id);
            return new Result_pojo(find_newfriend,0,"成功");
        }catch (Exception e){
            return (new Result_pojo(null,3002,"查看人物信息失败"));
        }
    }

    @RequestMapping("/add_to_waittable")
    @CrossOrigin
    public Result_pojo add_waittable(wait_friend friend){
       int uid= RedisUtils.get_user_id();
        friend.setUid(uid);
        try{
            myinfo_service.add_wait_friend(friend);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return (new Result_pojo(null,3003,"添加好友请求发送失败"));
        }
    }

    @RequestMapping("/find_all_newfriend")
    @CrossOrigin
    public Result_pojo find_all_newfriend(){
        int uid= RedisUtils.get_user_id();
        try{
            List<Re_wait_friend> list =myinfo_service.find_all_newfriend(uid);
            return new Result_pojo(list,0,"成功");
        }catch (Exception e){
            return (new Result_pojo(null,3004,"查看所有未添加好友失败"));
        }
    }

    @RequestMapping("/delete_apply_newfriend")
    @CrossOrigin
    public Result_pojo delete_apply_newfriend(int fid){
        int uid= RedisUtils.get_user_id();
        try{
            myinfo_service.delete_apply_newfriend(uid,fid);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3005,"删除接收到的好友请求失败，删除不成功");
        }
    }

    @RequestMapping("/agree_newfriend")
    @CrossOrigin
    public Result_pojo agree_newfriend(int fid){
        int uid= RedisUtils.get_user_id();
        try{
            myinfo_service.agree_newfriend(uid,fid);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3006,"同意接收到的好友请求失败，添加好友列表不成功");
        }
    }

    @RequestMapping("/send_reply")
    @CrossOrigin
    public Result_pojo add_reply_to_wait_friend(@RequestBody Fid_and_reply fid_and_reply){
        int uid= RedisUtils.get_user_id();
        fid_and_reply.setUid(uid);
        try{
            myinfo_service.add_reply_to_wait_friend(fid_and_reply);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3007,"回复好友请求失败");
        }
    }

    @RequestMapping("/look_myinfo")
    @CrossOrigin
    public Result_pojo look_myinfo(){
        int uid= RedisUtils.get_user_id();
        try{
            Find_newfriend find_newfriend=myinfo_service.find_onepeople_by_id(uid);
            return new Result_pojo(find_newfriend,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3008,"查看本人信息失败");
        }
    }

    @RequestMapping("/show_my_friend")
    @CrossOrigin
    public Result_pojo show_my_friend(){
        int uid= RedisUtils.get_user_id();
        try{
            List<t_user> list=myinfo_service.show_my_friend(uid);
            return new Result_pojo(list,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3009,"查看好友信息失败");
        }
    }

    @RequestMapping("/change_myinfo")
    @CrossOrigin
    public Result_pojo change_myinfo(@RequestBody Find_newfriend myallinfo){
        int uid= RedisUtils.get_user_id();
        myallinfo.getUser().setId(uid);

        try{
            myinfo_service.change_myinfo(myallinfo);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3010,"更改本人信息失败");
        }
    }
}
