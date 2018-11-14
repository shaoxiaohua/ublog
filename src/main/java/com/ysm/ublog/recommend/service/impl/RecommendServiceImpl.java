package com.ysm.ublog.recommend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<Recommend> findAllRecommend(int pagenum,int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<Recommend> allRecommend = mapper.findAllRecommend();
        PageInfo<Recommend> recommendPageInfo = new PageInfo<>(allRecommend);

        return null;
    }
}
