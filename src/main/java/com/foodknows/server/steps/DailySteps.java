package com.foodknows.server.steps;

import java.sql.Timestamp;

public class DailySteps {
    private Timestamp time;
    private int steps;

    public DailySteps() {
    }

    public DailySteps(Timestamp time, int steps) {
        this.time = time;
        this.steps = steps;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
