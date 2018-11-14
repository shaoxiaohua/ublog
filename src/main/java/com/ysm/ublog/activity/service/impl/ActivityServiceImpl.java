package com.ysm.ublog.activity.service.impl;

import com.ysm.ublog.activity.service.ActivityService;
import com.ysm.ublog.mapper.ActivityMapper;
import com.ysm.ublog.vo.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 16:49.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper mapper;

    @Override
    public List<ActivityVo> getAllActivities(int id) {
        return mapper.findAllActivity(id);
    }
}
