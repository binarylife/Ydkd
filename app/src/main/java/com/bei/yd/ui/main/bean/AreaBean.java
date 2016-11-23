package com.bei.yd.ui.main.bean;

import android.os.Parcel;
import com.bei.yd.bean.BaseBean;
import java.util.ArrayList;

/**
 * 模块列表页面的筛选标签点开的Window的数据bean
 * Created by wangchunlei on 4/25/16.
 */
public class AreaBean extends BaseBean<ArrayList<AreaBean>> {
    /**
     * 标签ID
     */
    private int id;
    /**
     * 标签描述
     */
    private String areaName;

    /**
     * 创建对象
     */
    public AreaBean() {
    }


    /**
     * 创建对象
     *
     * @param in
     */
    protected AreaBean(Parcel in) {
        id = in.readInt();
        areaName = in.readString();
    }

    /**
     * 创建者
     */
    public static final Creator<AreaBean> CREATOR = new Creator<AreaBean>() {
        @Override
        public AreaBean createFromParcel(Parcel in) {
            return new AreaBean(in);
        }

        @Override
        public AreaBean[] newArray(int size) {
            return new AreaBean[size];
        }
    };


    /**
     * 获取标示位
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 写入标签对象
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(areaName);
    }

    public int getId() {
        return id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
