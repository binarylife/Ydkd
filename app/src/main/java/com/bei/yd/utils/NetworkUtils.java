package com.bei.yd.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bei.yd.app.YDApp;
import com.jaydenxiao.common.commonutils.LogUtils;

/**
 * Created by yuanwai on 16/2/22.
 */
public class NetworkUtils {

  public static boolean isNetworkAvaliable() {
    Context context = YDApp.mContext.getApplicationContext();
    // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
    ConnectivityManager connectivityManager =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

    if (connectivityManager == null) {
      return false;
    } else {
      // 获取NetworkInfo对象
      NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

      if (networkInfo != null && networkInfo.length > 0) {
        for (int i = 0; i < networkInfo.length; i++) {
          //LogUtils.LOGI(i + "===状态===" + networkInfo[i].getState());
          //LogUtils.LOGI(i + "===类型===" + networkInfo[i].getTypeName());
          // 判断当前网络状态是否为连接状态
          if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
