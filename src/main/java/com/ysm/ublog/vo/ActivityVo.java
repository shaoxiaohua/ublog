package com.ysm.ublog.vo;

import com.ysm.ublog.activity.pojo.Activity;
import com.ysm.ublog.activity.pojo.Category;

/**
 * @author hua
 * @date 2018/11/6 17:19.
 * 封装活动和分类
 */
public class ActivityVo {
    private int vid;
    private Activity activity;
    private String category_name;
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }
}
