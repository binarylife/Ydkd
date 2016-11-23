package com.bei.yd.ui.main.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bei.yd.bean.BaseBean;
import java.util.ArrayList;

/**
 * 新加工单bean
 * Created by fb on 4/25/16.
 */
public class MainItemNewOrderBean  extends BaseBean<ArrayList<MainItemNewOrderBean>>{

    /**
     * account : 1001
     * address : 北土城
     * area : 介休
     * dispatchDuration : 0
     * dispatchPeople :
     * dispatchTime :
     * dispatchWarning : 0
     * id : 3
     * installDuration : 0
     * installPeople :
     * installTime :
     * installWarning : 0
     * interfacePeople :
     * isCancel : 0
     * isEnd : 0
     * overTime :
     * phone : 18550442345
     * repeatNum : 0
     * takeTime :
     * visitDuration : 0
     * visitWarning : 0
     */

    private String account;
    private String address;
    private String area;
    private int dispatchDuration;
    private String dispatchPeople;
    private String dispatchTime;
    private int dispatchWarning;
    private int id;
    private int installDuration;
    private String installPeople;
    private String installTime;
    private int installWarning;
    private String interfacePeople;
    private int isCancel;
    private int isEnd;
    private String overTime;
    private String phone;
    private int repeatNum;
    private String takeTime;
    private int visitDuration;
    private int visitWarning;

    protected MainItemNewOrderBean(Parcel in) {
        account = in.readString();
        address = in.readString();
        area = in.readString();
        dispatchDuration = in.readInt();
        dispatchPeople = in.readString();
        dispatchTime = in.readString();
        dispatchWarning = in.readInt();
        id = in.readInt();
        installDuration = in.readInt();
        installPeople = in.readString();
        installTime = in.readString();
        installWarning = in.readInt();
        interfacePeople = in.readString();
        isCancel = in.readInt();
        isEnd = in.readInt();
        overTime = in.readString();
        phone = in.readString();
        repeatNum = in.readInt();
        takeTime = in.readString();
        visitDuration = in.readInt();
        visitWarning = in.readInt();
    }

    public static final Creator<MainItemNewOrderBean> CREATOR =
        new Creator<MainItemNewOrderBean>() {
            @Override public MainItemNewOrderBean createFromParcel(Parcel in) {
                return new MainItemNewOrderBean(in);
            }

            @Override public MainItemNewOrderBean[] newArray(int size) {
                return new MainItemNewOrderBean[size];
            }
        };

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDispatchDuration() {
        return dispatchDuration;
    }

    public void setDispatchDuration(int dispatchDuration) {
        this.dispatchDuration = dispatchDuration;
    }

    public String getDispatchPeople() {
        return dispatchPeople;
    }

    public void setDispatchPeople(String dispatchPeople) {
        this.dispatchPeople = dispatchPeople;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public int getDispatchWarning() {
        return dispatchWarning;
    }

    public void setDispatchWarning(int dispatchWarning) {
        this.dispatchWarning = dispatchWarning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstallDuration() {
        return installDuration;
    }

    public void setInstallDuration(int installDuration) {
        this.installDuration = installDuration;
    }

    public String getInstallPeople() {
        return installPeople;
    }

    public void setInstallPeople(String installPeople) {
        this.installPeople = installPeople;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }

    public int getInstallWarning() {
        return installWarning;
    }

    public void setInstallWarning(int installWarning) {
        this.installWarning = installWarning;
    }

    public String getInterfacePeople() {
        return interfacePeople;
    }

    public void setInterfacePeople(String interfacePeople) {
        this.interfacePeople = interfacePeople;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    public int getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(int isEnd) {
        this.isEnd = isEnd;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRepeatNum() {
        return repeatNum;
    }

    public void setRepeatNum(int repeatNum) {
        this.repeatNum = repeatNum;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    public int getVisitDuration() {
        return visitDuration;
    }

    public void setVisitDuration(int visitDuration) {
        this.visitDuration = visitDuration;
    }

    public int getVisitWarning() {
        return visitWarning;
    }

    public void setVisitWarning(int visitWarning) {
        this.visitWarning = visitWarning;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(account);
        dest.writeString(address);
        dest.writeString(area);
        dest.writeInt(dispatchDuration);
        dest.writeString(dispatchPeople);
        dest.writeString(dispatchTime);
        dest.writeInt(dispatchWarning);
        dest.writeInt(id);
        dest.writeInt(installDuration);
        dest.writeString(installPeople);
        dest.writeString(installTime);
        dest.writeInt(installWarning);
        dest.writeString(interfacePeople);
        dest.writeInt(isCancel);
        dest.writeInt(isEnd);
        dest.writeString(overTime);
        dest.writeString(phone);
        dest.writeInt(repeatNum);
        dest.writeString(takeTime);
        dest.writeInt(visitDuration);
        dest.writeInt(visitWarning);
    }

    public MainItemNewOrderBean(String address, int id) {
        this.address = address;
        this.id = id;
    }
}
