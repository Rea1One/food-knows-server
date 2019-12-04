package com.foodknows.server.user;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @Column(nullable = false)
    private String openId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sex;


    private String profile;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private double weight;

    // 导出属性，不存到数据库中
    @Transient
    private double bmi;

    public User(){}

    public User(String openId, String name, String sex, String profile, double height, double weight) {
        this.openId = openId;
        this.name = name;
        this.sex = sex;
        this.profile = profile;
        this.height = height;
        this.weight = weight;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return weight / (height * height) * 10000;
    }
}
