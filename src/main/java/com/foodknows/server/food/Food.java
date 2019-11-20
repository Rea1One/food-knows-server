package com.foodknows.server.food;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String openId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double calories;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private Timestamp time;

    public Food() {
    }

    public Food(String openId, String name, double calories, double weight, Timestamp time) {
        this.openId = openId;
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.time = time;
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

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
