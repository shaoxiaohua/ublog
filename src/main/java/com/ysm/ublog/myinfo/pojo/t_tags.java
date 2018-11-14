package com.ysm.ublog.myinfo.pojo;
//    {
//        "t_user": {
//            "id": "123",
//            "nickname": "测试",
//            "gender": "test",
//            "phone": "18513057050",
//            "school_name": "zzzz",
//            "major_name": "zzzz",
//            "signature": "zxczxc",
//            "user_img": "地址",
//            "password": "111",
//            "salt": "zxczxc"
//        },
//        "t_tags": {
//            "uid": "123",
//            "photo": "测试",
//            "kaoyan": "test",
//            "travel": "18513057050",
//            "game": "zzzz",
//            "sport": "zzzz",
//            "music": "zxczxc",
//            "cet": "地址",
//            "movie": "111"
//        }
//    }
public class t_tags {
    private int uid;
    private int photo;
    private int kaoyan;
    private int travel;
    private int game;
    private int sport;
    private int music;
    private int cet;
    private int movie;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
