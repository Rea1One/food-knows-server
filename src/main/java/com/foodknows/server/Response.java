package com.foodknows.server;

public class Response<T> {
    private boolean isSuccess;
    private String message;
    private T resData;

    public Response() {
    }

    public Response(boolean isSuccess, String message, T resData) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.resData = resData;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }
}
