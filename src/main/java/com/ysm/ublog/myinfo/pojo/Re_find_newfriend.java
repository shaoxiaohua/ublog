package com.ysm.ublog.myinfo.pojo;

import java.io.Serializable;
//[{"id":3,"nickname":"qq","school_name":"qewaea","major_name":"adeaw","user_img":null,"photo":1,"kaoyan":1,"travel":1,"game":1,"sport":1,"music":1,"cet":1,"movie":1}]

public class Re_find_newfriend implements Serializable {
    private int id;
    private String nickname;
    private String school_name;
    private String major_name;
    private String user_img;
    private int photo;
    private int kaoyan;
    private int travel;
    private int game;
    private int sport;
    private int music;
    private int cet;
    private int movie;

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

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getKaoyan() {
        return kaoyan;
    }

    public void setKaoyan(int kaoyan) {
        this.kaoyan = kaoyan;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public int getCet() {
        return cet;
    }

    public void setCet(int cet) {
        this.cet = cet;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }
}
