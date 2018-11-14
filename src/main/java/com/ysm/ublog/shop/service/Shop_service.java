package com.ysm.ublog.shop.service;

import com.ysm.ublog.shop.pojo.Get_coupon;
import com.ysm.ublog.shop.pojo.t_coupon;
import com.ysm.ublog.shop.pojo.t_outside_activity;

import java.util.List;

public interface Shop_service {
    List<t_outside_activity> show_all_shop_ing();

    void add_mycoupon(int uid, int cid);

    List<Get_coupon> show_all_coupon(int uid);

    List<t_coupon> already_have_coupon(int uid);
}
