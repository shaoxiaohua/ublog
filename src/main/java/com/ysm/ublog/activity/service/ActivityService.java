package com.ysm.ublog.activity.service;

import com.ysm.ublog.activity.pojo.Activity;
import com.ysm.ublog.vo.ActivityVo;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 16:48.
 */
public interface ActivityService {
     List<ActivityVo> getAllActivities(int id);
}
