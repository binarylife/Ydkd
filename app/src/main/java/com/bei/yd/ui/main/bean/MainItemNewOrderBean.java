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
    private String id;
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
    private int status;
    private String dispatchPeople21;
    private String dispatchPeople22;
    private String dispatchTime21;
    private String dispatchTime22;
    private int dispatchWarning1;
    private int dispatchWarning2;
    private int dispatchDuration21;
    private int dispatchDuration22;

    protected MainItemNewOrderBean(Parcel in) {
        account = in.readString();
        address = in.readString();
        area = in.readString();
        dispatchDuration = in.readInt();
        dispatchPeople = in.readString();
        dispatchTime = in.readString();
        dispatchWarning = in.readInt();
        id = in.readString();
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
        status = in.readInt();
        dispatchPeople21 = in.readString();
        dispatchPeople22 = in.readString();
        dispatchTime21 = in.readString();
        dispatchTime22 = in.readString();
        dispatchWarning1 = in.readInt();
        dispatchWarning2 = in.readInt();
        dispatchDuration21 = in.readInt();
        dispatchDuration22 = in.readInt();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        dest.writeString(id);
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
        dest.writeInt(status);
        dest.writeString(dispatchPeople21);
        dest.writeString(dispatchPeople22);
        dest.writeString(dispatchTime21);
        dest.writeString(dispatchTime22);
        dest.writeInt(dispatchWarning1);
        dest.writeInt(dispatchWarning2);
        dest.writeInt(dispatchDuration21);
        dest.writeInt(dispatchDuration22);
    }

    public MainItemNewOrderBean(String address, String id) {
        this.address = address;
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDispatchPeople21(String dispatchPeople21) {
        this.dispatchPeople21 = dispatchPeople21;
    }

    public void setDispatchPeople22(String dispatchPeople22) {
        this.dispatchPeople22 = dispatchPeople22;
    }

    public void setDispatchTime21(String dispatchTime21) {
        this.dispatchTime21 = dispatchTime21;
    }

    public void setDispatchTime22(String dispatchTime22) {
        this.dispatchTime22 = dispatchTime22;
    }

    public void setDispatchWarning1(int dispatchWarning1) {
        this.dispatchWarning1 = dispatchWarning1;
    }

    public void setDispatchWarning2(int dispatchWarning2) {
        this.dispatchWarning2 = dispatchWarning2;
    }

    public void setDispatchDuration21(int dispatchDuration21) {
        this.dispatchDuration21 = dispatchDuration21;
    }

    public void setDispatchDuration22(int dispatchDuration22) {
        this.dispatchDuration22 = dispatchDuration22;
    }

    public String getDispatchPeople21() {
        return dispatchPeople21;
    }

    public String getDispatchPeople22() {
        return dispatchPeople22;
    }

    public String getDispatchTime21() {
        return dispatchTime21;
    }

    public String getDispatchTime22() {
        return dispatchTime22;
    }

    public int getDispatchWarning1() {
        return dispatchWarning1;
    }

    public int getDispatchWarning2() {
        return dispatchWarning2;
    }

    public int getDispatchDuration21() {
        return dispatchDuration21;
    }

    public int getDispatchDuration22() {
        return dispatchDuration22;
    }
}
