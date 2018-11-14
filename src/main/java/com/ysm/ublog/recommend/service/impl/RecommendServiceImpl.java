package com.ysm.ublog.recommend.service.impl;


import com.ysm.ublog.mapper.RecommendMapper;
import com.ysm.ublog.recommend.pojo.Recommend;
import com.ysm.ublog.recommend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CREATED BY hua
 * @date 2018/11/14 16:27.
 * @since jdk1.8
 */
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper mapper;

    @Override
    public List<Recommend> findAllRecommend() {

        return  mapper.findAllRecommend();
    }
}
