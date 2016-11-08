package com.bei.yd.ui.main.bean;

import android.os.Parcel;
import com.bei.yd.bean.BaseBean;

/**
 * 模块列表页面的筛选标签点开的Window的数据bean
 * Created by wangchunlei on 4/25/16.
 */
public class MainBean extends BaseBean<MainBean> {
    /**
     * 标签ID
     */
    private int tagId;
    /**
     * 标签描述
     */
    private String tagName;

    /**
     * 创建对象
     */
    public MainBean() {
    }

    /**
     * 创建对象
     *
     * @param id
     * @param tag
     */
    public MainBean(int id, String tag) {
        this.tagId = id;
        this.tagName = tag;
    }

    /**
     * 创建对象
     *
     * @param in
     */
    protected MainBean(Parcel in) {
        tagId = in.readInt();
        tagName = in.readString();
    }

    /**
     * 创建者
     */
    public static final Creator<MainBean> CREATOR = new Creator<MainBean>() {
        @Override
        public MainBean createFromParcel(Parcel in) {
            return new MainBean(in);
        }

        @Override
        public MainBean[] newArray(int size) {
            return new MainBean[size];
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
        dest.writeInt(tagId);
        dest.writeString(tagName);
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
