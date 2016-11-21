package com.bei.yd.ui.main.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bei.yd.bean.BaseBean;

/**
 * 登录后的个人信息bean
 */
public class UserInfoBean extends BaseBean<UserInfoBean> {

    /**
     * account : 1001
     * areaid : 1000
     * id : 1
     * pwd : 123456
     * remark : 一级派单员
     * role : A
     * username : 测试用户1
     */

    private String account;
    private int areaid;
    private int id;
    private String pwd;
    private String remark;
    private String role;
    private String username;

    protected UserInfoBean(Parcel in) {
        account = in.readString();
        areaid = in.readInt();
        id = in.readInt();
        pwd = in.readString();
        remark = in.readString();
        role = in.readString();
        username = in.readString();
    }

    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override public UserInfoBean createFromParcel(Parcel in) {
            return new UserInfoBean(in);
        }

        @Override public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(account);
        dest.writeInt(areaid);
        dest.writeInt(id);
        dest.writeString(pwd);
        dest.writeString(remark);
        dest.writeString(role);
        dest.writeString(username);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
