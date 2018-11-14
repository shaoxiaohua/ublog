package com.ysm.ublog.recommend.controller;

import com.ysm.ublog.recommend.pojo.Recommend;
import com.ysm.ublog.recommend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CREATED BY hua
 * @date 2018/11/14 16:30.
 * @since jdk1.8
 */
@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendService recommendService;
    @CrossOrigin
    @RequestMapping("/getallrecommend")
    public List<Recommend> getAllRecommend(){
        return recommendService.findAllRecommend();
    }
}
