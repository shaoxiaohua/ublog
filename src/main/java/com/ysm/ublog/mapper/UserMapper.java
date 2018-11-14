package com.ysm.ublog.mapper;

import com.ysm.ublog.user.pojo.T_user;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void addUser(@Param("t_user") T_user t_user);
    T_user findUserByName(String username);
}
