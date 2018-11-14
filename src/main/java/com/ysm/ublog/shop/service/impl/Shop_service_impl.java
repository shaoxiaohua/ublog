package com.ysm.ublog.shop.service.impl;

import com.ysm.ublog.mapper.Shop_mapper;
import com.ysm.ublog.shop.pojo.Get_coupon;
import com.ysm.ublog.shop.pojo.t_coupon;
import com.ysm.ublog.shop.pojo.t_outside_activity;
import com.ysm.ublog.shop.service.Shop_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Shop_service_impl implements Shop_service {
    @Autowired
    Shop_mapper shop_mapper;
    @Override
    public List<t_outside_activity> show_all_shop_ing() {
        List<t_outside_activity> list=shop_mapper.show_all_shop_ing();
        return list;
    }

    @Override
    public void add_mycoupon(int uid, int cid) {
        shop_mapper.add_mycoupon(uid,cid);
    }

    @Override
    public List<Get_coupon> show_all_coupon(int uid) {
        List<Get_coupon> list=new ArrayList<>();
        List<t_coupon> coupons=shop_mapper.all_coupon();
        List<Integer> myhaves=shop_mapper.myhave_coupon_id(uid);
        for (t_coupon coupon:coupons
             ) {
            Get_coupon get_coupon=new Get_coupon();
            get_coupon.setCoupon(coupon);
            for (Integer myhaveid:myhaves
                 ) {
                if(coupon.getId()==myhaveid){
                    get_coupon.setMyhave(1);
                }
            }
            list.add(get_coupon);
        }
        return list;
    }

    @Override
    public List<t_coupon> already_have_coupon(int uid) {
        List<t_coupon> list=shop_mapper.already_have_coupon(uid);
        return list;
    }


}
