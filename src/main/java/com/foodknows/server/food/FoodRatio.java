package com.foodknows.server.food;

public class FoodRatio {
    private String name;
    private double sumCalories;

    public FoodRatio() {
    }

    public FoodRatio(String name, double sumCalories) {
        this.name = name;
        this.sumCalories = sumCalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSumCalories() {
        return sumCalories;
    }

    public void setSumCalories(double sumCalories) {
        this.sumCalories = sumCalories;
    }
}
