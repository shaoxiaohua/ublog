package com.ysm.ublog.friend_circle.entity;

import java.util.Date;

public class T_friend_circle_comment {
    private String id;
    private int fcmid;
    private int uid;
    private String content;
    private Date create_time;
    private int like_count;  //点赞数量

    public T_friend_circle_comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T_friend_circle_comment(String id, int fcmid, int uid, String content, Date create_time, int like_count) {
        this.id = id;
        this.fcmid = fcmid;
        this.uid = uid;
        this.content = content;
        this.create_time = create_time;
        this.like_count = like_count;
    }

    public int getFcmid() {
        return fcmid;
    }

    public void setFcmid(int fcmid) {
        this.fcmid = fcmid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    @Override
    public String toString() {
        return "T_friend_circle_comment{" +
                "fcmid=" + fcmid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", like_count=" + like_count +
                '}';
    }
}
