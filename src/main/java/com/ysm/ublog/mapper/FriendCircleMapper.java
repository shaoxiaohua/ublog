package com.ysm.ublog.mapper;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import com.ysm.ublog.friend_circle.entity.T_friend_circle_message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface FriendCircleMapper {

    List<T_friend_circle_message> getAllMessage();

    void addFriendMessage(@Param("t_friend_message") T_friend_circle_message t_friend_message);

    void addComment(@Param("t_friend_comment") T_friend_circle_comment t_friend_circle_comment);

    List<String> getAllMessageKey();
}
