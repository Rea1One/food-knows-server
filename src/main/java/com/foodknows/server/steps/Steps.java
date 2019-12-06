package com.foodknows.server.steps;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Steps {

    @Id
    @Column(nullable = false)
    private String openId;

    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private int steps;

    public Steps(){}

    public Steps(String openId,Timestamp time,Timestamp startTime,Timestamp endTime,int steps){
        this.openId=openId;
        this.time=time;
        this.steps=steps;
    }

    public String getOpenId(){ return openId; }

    public void setOpenId(String openId){ this.openId=openId;}

    public Timestamp getTime(){ return time;}

    public void setTime(Timestamp time){ this.time=time;}


    public int getSteps(){ return steps;}

    public void setSteps(int steps){ this.steps=steps;}
}
