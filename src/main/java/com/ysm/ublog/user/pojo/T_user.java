package com.ysm.ublog.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
public class T_user {
    private int id;
    private String nickname;
    private int gender;
    @Pattern(regexp = "1[3578][0-9]{9}",message = "手机格式不正确")
    private String phone;
    private String school_name;
    private String major_name;
    private String signature;
    private String user_img;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String salt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public T_user(int id, String nickname, int gender, String phone, String school_name, String major_name, String signature, String user_img, String password, String salt) {
        this.id = id;
        this.nickname = nickname;
        this.gender = gender;
        this.phone = phone;
        this.school_name = school_name;
        this.major_name = major_name;
        this.signature = signature;
        this.user_img = user_img;
        this.password = password;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public T_user() {
    }

    @Override
    public String toString() {
        return "T_user{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", school_name='" + school_name + '\'' +
                ", major_name='" + major_name + '\'' +
                ", signature='" + signature + '\'' +
                ", user_img='" + user_img + '\'' +
                '}';
    }
}
