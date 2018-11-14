package com.ysm.ublog.myinfo.service.impl;

import com.ysm.ublog.mapper.Myinfo_mapper;
import com.ysm.ublog.myinfo.pojo.*;
import com.ysm.ublog.myinfo.service.Myinfo_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Myinfo_service_impl implements Myinfo_service {
    @Autowired
    Myinfo_mapper myinfo_mapper;
    @Override
    public List<Re_find_newfriend> findnewfriends(Find_newfriend find_newfriend) {
        List<Re_find_newfriend> list=myinfo_mapper.findnewfriends(find_newfriend);

        return list;
    }

    @Override
    public Find_newfriend find_onepeople_by_id(int id) {
        t_tags tags=myinfo_mapper.find_onepeople_tags_by_id(id);
        t_user user=myinfo_mapper.find_onepeople_user_by_id(id);
//        user.setPassword("保密");
        Find_newfriend find_newfriend=new Find_newfriend();
        find_newfriend.setTags(tags);
        find_newfriend.setUser(user);
        return find_newfriend;
    }

    @Override
    public void add_wait_friend(wait_friend friend) {
        myinfo_mapper.add_wait_friend(friend);
    }

    @Override
    public List<Re_wait_friend> find_all_newfriend(int uid) {
        List<wait_friend> no_img_list=myinfo_mapper.find_all_newfriend_no_img(uid);
        List<Re_wait_friend> list=new ArrayList<>();
        for (wait_friend a_no_img_list:no_img_list) {
            String img=myinfo_mapper.find_img_by_id(a_no_img_list.getUid());
            Re_wait_friend re_wait_friend=new Re_wait_friend();
            re_wait_friend.setWait_friends(a_no_img_list);
            re_wait_friend.setImg_address(img);
            list.add(re_wait_friend);
        }
        return list;
    }

    @Override
    public void delete_apply_newfriend(int uid, int fid) {

        myinfo_mapper.delete_apply_newfriend(uid,fid);
    }

    @Override
    public void agree_newfriend(int uid, int fid) {
        myinfo_mapper.change_agree_wait_friend(uid,fid);
        myinfo_mapper.add_user_friend(uid,fid);
    }

    @Override
    public void add_reply_to_wait_friend(Fid_and_reply fid_and_reply) {
        myinfo_mapper.add_reply_to_wait_friend(fid_and_reply);

    }

    @Override
    public List<t_user> show_my_friend(int uid) {
        List<t_user> list=myinfo_mapper.show_my_friend(uid);
        return list;
    }

    @Override
    public void change_myinfo(Find_newfriend myallinfo) {
        myinfo_mapper.change_myinfo(myallinfo);
        myinfo_mapper.change_tags(myallinfo);
    }
}
