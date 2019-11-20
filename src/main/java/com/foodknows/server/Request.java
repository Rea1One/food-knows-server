package com.foodknows.server;

public class Request<T> {
    private String openId;
    private T reqParam;

    public Request() {
    }

    public Request(String openId, T reqParam) {
        this.openId = openId;
        this.reqParam = reqParam;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public T getReqParam() {
        return reqParam;
    }

    public void setReqParam(T reqParam) {
        this.reqParam = reqParam;
    }
}
