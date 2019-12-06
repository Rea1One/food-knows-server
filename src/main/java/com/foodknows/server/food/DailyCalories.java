package com.foodknows.server.food;

import java.sql.Timestamp;

public class DailyCalories {
    private Timestamp time;
    private double calories;

    public DailyCalories() {
    }

    public DailyCalories(Timestamp time, double calories) {
        this.time = time;
        this.calories = calories;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
