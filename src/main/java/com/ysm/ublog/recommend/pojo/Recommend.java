package com.ysm.ublog.recommend.pojo;

/**
 * @author CREATED BY hua
 * @date 2018/11/14 15:07.
 * @since jdk1.8
 */
public class Recommend {
    private int rid;
//    分类的小标签
    private String smallimg;
    private String nickname;
//    朋友圈的图片
    private String picture;
//    朋友圈的内容
    private String content;
//    用户的头像
    private String user_img;
//    朋友圈的评论量
    private int commentnum;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSmallimg() {
        return smallimg;
    }

    public void setSmallimg(String smallimg) {
        this.smallimg = smallimg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public int getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "rid=" + rid +
                ", smallimg='" + smallimg + '\'' +
                ", nickname='" + nickname + '\'' +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", user_img='" + user_img + '\'' +
                ", commentnum=" + commentnum +
                '}';
    }

}
