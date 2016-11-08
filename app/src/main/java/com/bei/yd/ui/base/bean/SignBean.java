package com.bei.yd.ui.base.bean;

import android.os.Parcel;

/**
 * 创建者: wwd
 * 创建日期:16/7/30
 * 类的功能描述:
 */
public class SignBean extends BaseBean<SignBean>{
  String time;

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {

  }
}
