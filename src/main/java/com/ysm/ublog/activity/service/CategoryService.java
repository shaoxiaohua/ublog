package com.ysm.ublog.activity.service;

import com.ysm.ublog.activity.pojo.Category;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 14:58.
 */
public interface CategoryService {
    /**
     * 查询所有的分类
     * @return
     */
     List<Category> findAllCategory();
     List<Category> findAllCategoryFromRedis();
}
