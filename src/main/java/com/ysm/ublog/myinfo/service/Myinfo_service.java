package com.ysm.ublog.myinfo.service;

import com.ysm.ublog.myinfo.pojo.*;

import java.util.List;

public interface Myinfo_service {
    public List<Re_find_newfriend> findnewfriends(Find_newfriend find_newfriend) ;

    Find_newfriend find_onepeople_by_id(int id);

    void add_wait_friend(wait_friend friend);

    List<Re_wait_friend> find_all_newfriend(int uid);

    void delete_apply_newfriend(int uid, int fid);

    void agree_newfriend(int uid, int fid);

    void add_reply_to_wait_friend(Fid_and_reply fid_and_reply);

    List<t_user> show_my_friend(int uid);

    void change_myinfo(Find_newfriend myallinfo);
}
