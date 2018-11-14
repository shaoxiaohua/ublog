package com.ysm.ublog.activity.service.impl;

import com.ysm.ublog.activity.pojo.Category;
import com.ysm.ublog.activity.service.CategoryService;
import com.ysm.ublog.mapper.CategoryMapper;
import com.ysm.ublog.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 14:59.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private JedisPool jedisPool;
    @Override
    public List<Category> findAllCategory(){
        return categoryMapper.findAllCategory();
    }

    @Override
    public List<Category> findAllCategoryFromRedis() {
        Jedis jedis = jedisPool.getResource();
        String key = "category";
        List<Category> list = SerializeUtil.unserializeForList(jedis.get(key.getBytes()));
        return list;
    }

}
