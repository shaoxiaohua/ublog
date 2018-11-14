package com.ysm.ublog.shop.controller;

import com.ysm.ublog.config.Commons_config;
import com.ysm.ublog.myinfo.pojo.Result_pojo;
import com.ysm.ublog.shop.pojo.Get_coupon;
import com.ysm.ublog.shop.pojo.t_coupon;
import com.ysm.ublog.shop.pojo.t_outside_activity;
import com.ysm.ublog.shop.service.Shop_service;
import com.ysm.ublog.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class Shop_controller {
    @Autowired
    Shop_service shop_service;

    @RequestMapping("/show_all_shop")
    @CrossOrigin
    public Result_pojo show_all_shop(){
        try{
            List<t_outside_activity> list=shop_service.show_all_shop_ing();
            return new Result_pojo(list,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3101,"提取线下活动列表失败");
        }
    }

    @RequestMapping("/getto_mycoupon")
    @CrossOrigin
    public Result_pojo getto_mycoupon(int cid){
        int uid= RedisUtils.get_user_id();
        try{
            shop_service.add_mycoupon(uid,cid);
            return new Result_pojo(null,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3102,"领取优惠劵失败");
        }
    }

    @RequestMapping("/show_all_coupon")
    @CrossOrigin
    public Result_pojo show_all_coupon(){
        int uid= RedisUtils.get_user_id();
        try{
            List<Get_coupon> list=shop_service.show_all_coupon(uid);
            return new Result_pojo(list,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3103,"提取优惠劵数据失败");
        }
    }

    @RequestMapping("/already_have_coupon")
    @CrossOrigin
    public Result_pojo already_have_coupon(){
        int uid= RedisUtils.get_user_id();
        try{
            List<t_coupon> list=shop_service.already_have_coupon(uid);
            return new Result_pojo(list,0,"成功");
        }catch (Exception e){
            return new Result_pojo(null,3104,"提取已领取优惠劵数据失败");
        }
    }

//    @Autowired
//    private JedisPool jedisPool;
//    public Map<String,String> Test(){
////        Commons_config commons_config=new Commons_config();
////        JedisPoolConfig jedisPoolConfig = commons_config.jedisPoolConfig();
////        JedisPool jedisPool = commons_config.jedisPool(jedisPoolConfig);
//        Jedis jedis=jedisPool.getResource();
//        String id="1";
//        Map<String,String> map=jedis.hgetAll(id);
//        if(map==null || map.isEmpty()){
//            Boolean fangchuantou=jedis.sismember("fangchuantou",id);
//            if(fangchuantou){
//                //从数据库中查询数据
//                RedisUtils.hSet(id,"数据",jedis);
//                jedis.expire(id,120);
//                return map;
//            }
//        }
//        return map;
//
//    }



}
