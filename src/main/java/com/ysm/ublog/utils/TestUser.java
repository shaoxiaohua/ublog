package com.ysm.ublog.utils;

import java.io.Serializable;

/**
 * @author hua
 * @date 2018/11/10 9:43.
 * @since jdk1.8
 */
public class TestUser implements Serializable {
    private String name;
    private int age;

    public TestUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
