package com.ysm.ublog.mapper;

import com.ysm.ublog.myinfo.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Myinfo_mapper {
    List<Re_find_newfriend> findnewfriends(@Param("find_newfriend") Find_newfriend find_newfriend);

    t_tags find_onepeople_tags_by_id(int id);
    t_user find_onepeople_user_by_id(int id);

    void add_wait_friend(@Param("wait_friend") wait_friend friend);

    List<wait_friend> find_all_newfriend_no_img(int uid);

    String find_img_by_id(int uid);

    void delete_apply_newfriend(@Param("uid") int uid, @Param("fid") int fid);

    void change_agree_wait_friend(@Param("uid") int uid, @Param("fid") int fid);

    void add_user_friend(@Param("uid") int uid, @Param("fid") int fid);

    void add_reply_to_wait_friend(@Param("fid_and_reply") Fid_and_reply fid_and_reply);

    List<t_user> show_my_friend(int uid);

    void change_myinfo(@Param("myallinfo") Find_newfriend myallinfo);

    void change_tags(@Param("myallinfo")Find_newfriend myallinfo);
}
