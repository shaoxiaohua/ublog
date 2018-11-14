package com.ysm.ublog.activity.pojo;

import java.io.Serializable;

/**
 * @author hua
 * @date 2018/11/6 14:54.
 */
public class Category implements Serializable {

    private int id;
    private String name;
    private String img_cate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_cate() {
        return img_cate;
    }

    public void setImg_cate(String img_cate) {
        this.img_cate = img_cate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img_cate='" + img_cate + '\'' +
                '}';
    }
}
