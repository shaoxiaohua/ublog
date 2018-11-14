package com.ysm.ublog.recommend.service;

import com.ysm.ublog.recommend.pojo.Recommend;

import java.util.List;

/**
 * @author CREATED BY hua
 * @date 2018/11/14 16:25.
 */
public interface RecommendService {
    List<Recommend> findAllRecommend();
}
