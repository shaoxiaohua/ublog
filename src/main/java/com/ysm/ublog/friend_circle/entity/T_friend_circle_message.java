package com.ysm.ublog.friend_circle.entity;

import java.util.Date;
import java.util.List;

public class T_friend_circle_message {
    private String id;
    private int uid;
    private String content;
    private String picture;
    private String location;
    private Date createtime;
    private int isown;
    private List<T_friend_circle_comment> commentslist;

    public T_friend_circle_message(String id, int uid, String content, String picture, String location, Date createtime, int isown, List<T_friend_circle_comment> commentslist) {
        this.id = id;
        this.uid = uid;
        this.content = content;
        this.picture = picture;
        this.location = location;
        this.createtime = createtime;
        this.isown = isown;
        this.commentslist = commentslist;
    }

    public List<T_friend_circle_comment> getCommentslist() {
        return commentslist;
    }

    public void setCommentslist(List<T_friend_circle_comment> commentslist) {
        this.commentslist = commentslist;
    }

    public T_friend_circle_message() {
    }

    public int getIsown() {
        return isown;
    }

    public void setIsown(int is_own) {
        this.isown = is_own;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "t_friend_circle_message{" +
                "id=" + id +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
