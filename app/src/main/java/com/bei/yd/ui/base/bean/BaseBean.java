package com.bei.yd.ui.base.bean;

import android.os.Parcelable;

/**
 * Created by HETI on 2016/2/19.
 */
public abstract class BaseBean<T> implements Parcelable {
    private String success;
    private int code;
    private String msg;
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

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        return "[" + "code:" + code + " msg: " + msg + " data: " + data + "]";
    }
}
