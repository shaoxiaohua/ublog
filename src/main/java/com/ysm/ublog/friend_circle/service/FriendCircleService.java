package com.ysm.ublog.friend_circle.service;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import com.ysm.ublog.friend_circle.entity.T_friend_circle_message;

import java.util.List;
import java.util.Set;

public interface FriendCircleService {
    //添加朋友圈
    void addFriendMessage(T_friend_circle_message t_friend_message);
   //添加评论
    void addComment(T_friend_circle_comment t_friend_circle_comment);
     //得到所有的朋友圈
    List<T_friend_circle_message> getAllMessage(int uid);

    List<String> getAllKey();
}
