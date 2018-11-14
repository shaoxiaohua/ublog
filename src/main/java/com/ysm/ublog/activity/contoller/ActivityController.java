package com.ysm.ublog.activity.contoller;

import com.ysm.ublog.activity.service.ActivityService;
import com.ysm.ublog.bean.ResultBean;
import com.ysm.ublog.utils.ErrorCodeInterface;
import com.ysm.ublog.vo.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 14:23.
 * 这是获取活动分类的控制器
 */

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @RequestMapping("/getactivitybycateid")
    @CrossOrigin
    public ResultBean getActivityByiCateid(@RequestParam("id") Integer id) {
        System.out.println("---"+id+"---");
        List<ActivityVo> allActivities = activityService.getAllActivities(id);
        System.out.println(allActivities.size());
        return ResultBean.setOk(ErrorCodeInterface.SUCCESS, "返回成功", allActivities);
    }

}
