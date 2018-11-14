package com.ysm.ublog.utils;

import com.ysm.ublog.activity.pojo.Category;
import com.ysm.ublog.activity.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author hua
 * @date 2018/11/9 21:31.
 * @since jdk1.8
 */
@Component
public class PutCategoryRedis {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private JedisPool jedisPool;
//    初始化此类的对象之后，将分类保存到redis中
    @PostConstruct
    public void init(){
//        获取到所有分类的列表，将其以list的形式存储在redis中
        List<Category> list = categoryService.findAllCategory();
        Jedis jedis = jedisPool.getResource();
        String key = "category";
        jedis.set(key.getBytes(), SerializeUtil.serialize(list));
    }
}
