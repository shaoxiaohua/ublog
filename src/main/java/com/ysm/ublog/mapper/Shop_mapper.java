package com.ysm.ublog.mapper;

import com.ysm.ublog.shop.pojo.t_coupon;
import com.ysm.ublog.shop.pojo.t_outside_activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Shop_mapper {
    List<t_outside_activity> show_all_shop_ing();

    void add_mycoupon(@Param("uid") int uid, @Param("cid") int cid);

    List<t_coupon> all_coupon();

    List<Integer> myhave_coupon_id(int uid);

    List<t_coupon> already_have_coupon(int uid);
}
