package com.ysm.ublog.user.service;

import com.ysm.ublog.user.pojo.T_user;

public interface UserService {
    void addUser(T_user t_user);
    void login(String username,String password);

    T_user getUserByUsername(String username);
}
