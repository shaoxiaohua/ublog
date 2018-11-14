package com.ysm.ublog.activity.pojo;

import java.util.Date;

/**
 * @author hua
 * @date 2018/11/6 13:56.
 * 这是活动的分类
 * 首页的八个标签
 */
public class Activity {
    private int id;
    private String theme;
    private String place;
    private String title;
    private String content;
    private Date begin_time;
    private double fee;
    /**
     * 图像的地址
     */
    private String cate_add;
//    这是分类的id
    private int cate_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }



    public String getCate_add() {
        return cate_add;
    }

    public void setCate_add(String cate_add) {
        this.cate_add = cate_add;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", place='" + place + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", begin_time=" + begin_time +
                ", fee=" + fee +
                ", cate_add='" + cate_add + '\'' +
                ", cate_id=" + cate_id +
                '}';
    }
}
