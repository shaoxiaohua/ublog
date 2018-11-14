package com.ysm.ublog.mapper;

import com.ysm.ublog.recommend.pojo.Recommend;

import java.util.List;

/**
 * @author CREATED BY hua
 * @date 2018/11/14 15:14.
 */
//推荐的mapper
public interface RecommendMapper {
    List<Recommend> findAllRecommend();
}
