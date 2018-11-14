package com.ysm.ublog.tag.entity;

public class T_tags {
    private int uid;
    private int photo;
    private int kaoyan;
    private int travel;
    private int game;
    private int sport;
    private int music;
    private int cet;
    private int movie;

    public T_tags() {
    }

    public T_tags(int uid, int photo, int kaoyan, int travel, int game, int sport, int music, int cet, int movie) {
        this.uid = uid;
        this.photo = photo;
        this.kaoyan = kaoyan;
        this.travel = travel;
        this.game = game;
        this.sport = sport;
        this.music = music;
        this.cet = cet;
        this.movie = movie;
    }

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

    @Override
    public String toString() {
        return "T_tags{" +
                "uid=" + uid +
                ", photo=" + photo +
                ", kaoyan=" + kaoyan +
                ", travel=" + travel +
                ", game=" + game +
                ", sport=" + sport +
                ", music=" + music +
                ", cet=" + cet +
                ", movie=" + movie +
                '}';
    }
}
