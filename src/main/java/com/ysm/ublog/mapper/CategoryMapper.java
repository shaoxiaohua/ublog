package com.ysm.ublog.mapper;

import com.ysm.ublog.activity.pojo.Category;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 15:02.
 */
public interface CategoryMapper {

    List<Category> findAllCategory();

}
