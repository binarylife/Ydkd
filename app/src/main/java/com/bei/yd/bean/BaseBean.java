package com.bei.yd.bean;

import android.os.Parcelable;

/**
 * Created by HETI on 2016/2/19.
 */
public abstract class BaseBean<T> implements Parcelable {
    private String success;
    private int code;
    private String message;
    private String obj;
    private T data;

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public boolean isSuccessful() {
        return code == 200 ? true : false;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "[" + "code:" + code + " msg: " +  " data: " + data + "]";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
