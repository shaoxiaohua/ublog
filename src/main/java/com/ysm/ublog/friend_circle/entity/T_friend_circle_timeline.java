package com.ysm.ublog.friend_circle.entity;

import java.util.Date;

public class T_friend_circle_timeline {
    private int id;
    private int uid;
    private int fcmid;
    private int is_own;
    private Date create_time;

    public T_friend_circle_timeline(int id, int uid, int fcmid, int is_own, Date create_time) {
        this.id = id;
        this.uid = uid;
        this.fcmid = fcmid;
        this.is_own = is_own;
        this.create_time = create_time;
    }

    public T_friend_circle_timeline() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFcmid() {
        return fcmid;
    }

    public void setFcmid(int fcmid) {
        this.fcmid = fcmid;
    }

    public int getIs_own() {
        return is_own;
    }

    public void setIs_own(int is_own) {
        this.is_own = is_own;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "T_friend_circle_timeline{" +
                "id=" + id +
                ", uid=" + uid +
                ", fcmid=" + fcmid +
                ", is_own=" + is_own +
                ", create_time=" + create_time +
                '}';
    }
}
