package com.bei.yd.ui.base.bean;

import android.os.Parcel;

/**
 * 服务端返回的标准数据格式只有code 和MSG，就可以使用这个
 * Created by wangchunlei on 5/7/16.
 */
public class SimpleBean extends BaseBean {
    /**
     * 无参构造方法
     */
    public SimpleBean() {
    }

    protected SimpleBean(Parcel in) {
    }


    public static final Creator<SimpleBean> CREATOR = new Creator<SimpleBean>() {
        @Override
        public SimpleBean createFromParcel(Parcel in) {
            return new SimpleBean(in);
        }

        @Override
        public SimpleBean[] newArray(int size) {
            return new SimpleBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
