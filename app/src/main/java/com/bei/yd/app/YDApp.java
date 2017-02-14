package com.bei.yd.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.bei.yd.BuildConfig;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.tinkerpatch.sdk.tinker.callback.ResultCallBack;
import java.util.List;

/**
 * 百代旅行Application类
 * Created by HETI on 2016/2/17.
 */
public class YDApp extends Application {

  public static YDApp mContext;
  /**
   * 未做城市选择默认值
   */
  public static final int UN_SELECTED_CITY_ID = -1;
  private static boolean isLogin;
  /**
   * 城市编号
   */
  private int cityID = UN_SELECTED_CITY_ID;
  private ApplicationLike tinkerApplicationLike;

  @Override public void onCreate() {
    super.onCreate();
    MultiDex.install(this);
    //        if (BuildConfig.DEBUG) {//启用严苛模式
    //            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
    //                    .detectDiskReads()
    //                    .detectDiskWrites()
    //                    .detectNetwork()
    //                    .detectAll()
    //                    .penaltyLog()
    //                    .build());
    //setThreadPolicy()：将对当前线程应用该策略
    //detectDiskReads():监控磁盘读
    //detectDiskWrites():监控磁盘写
    //detectNetwork():监控网络访问
    //detectAll()：检测当前线程所有函数
    //penaltyLog():表示将警告输出到LogCat，你也可以使用其他或增加新的惩罚（penalty）函数，例如使用penaltyDeath()的话，一旦StrictMode消息被写到LogCat后应用就会崩溃。
    //        }
    mContext = this;
    String processName = getProcessName(this, android.os.Process.myPid());
    LogUtils.logInit(BuildConfig.LOG_DEBUG);
    tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
    //开始检查是否有补丁，这里配置的是每隔访问3小时服务器是否有更新。
    TinkerPatch.init(tinkerApplicationLike)
        //.reflectPatchLibrary()
        //若参数为true,即每次调用都会真正的访问后台配置
        .fetchPatchUpdate(true)
        .setPatchRollbackOnScreenOff(true)
        .setPatchRestartOnSrceenOff(true)
        //设置访问后台补丁包更新配置的时间间隔,默认为3个小时
        .setFetchPatchIntervalByHours(1)
        //向后台获得动态配置,默认的访问间隔为3个小时
        //若参数为true,即每次调用都会真正的访问后台配置
        //例如弹框什么
        .setPatchResultCallback(new ResultCallBack() {
            @Override public void onPatchResult(PatchResult patchResult) {
                //DialogBuilder db = new DialogBuilder(BaiDaiApp.this).setTitle("提示");

            }
        });
    }
    /**
     * 进来先获取用户信息,取出Token
     */
    //        getUserInfo();

  /**
   * 获取android:process的进程名称
   */
  public String getProcessName(Context cxt, int pid) {
    ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
    List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
    if (runningApps == null) {
      return null;
    }
    for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
      if (procInfo.pid == pid) {
        return procInfo.processName;
      }
    }
    return null;
  }

  /**
   * 返回CityID
   */
  //public int getCityID() {
  //  if (cityID == UN_SELECTED_CITY_ID) {
  //    cityID = SharedPreferenceHelper.getCityId();
  //  }
  //  return cityID;
  //}

  /**
   * @param cityID
   */
  public void setCityID(int cityID) {
    this.cityID = cityID;
  }

  /**
   * 信鸽推送初始化
   */
  //private void initXGPush() {
  //  //开启logcat输出，方便debug，发布时请关闭
  //  XGPushConfig.enableDebug(this, BuildConfig.DEBUG);
  //  // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
  //  // 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
  //  // 具体可参考详细的开发指南
  //  // 传递的参数为ApplicationContext
  //  Context context = getApplicationContext();
  //  XGPushManager.registerPush(context);
  //}

  /**
   * 友盟集成测试设备时使用(测试设备识别信息)
   * 用于绑定设备信息，具体细节请访问：http://dev.umeng.com/analytics/android-doc/integration#8
   */

  //    /**
  //     * 获取登录的用户信息
  //     *
  //     * @return notNull
  //     */
  //    public UserInfoBean getUserInfo() {
  //        UserInfoBean userInfoBean = new UserInfoBean();
  //        userInfoBean.setToken(SharedPreferenceHelper.getUserToken());
  //        userInfoBean.setMemberId(SharedPreferenceHelper.getUserMemberId());
  //        userInfoBean.setNickName(SharedPreferenceHelper.getUserNickName());
  //        userInfoBean.setMobile(SharedPreferenceHelper.getUserMobile());
  //        userInfoBean.setPhotoUrl(SharedPreferenceHelper.getUserPhotoUrl());
  //        LogUtils.LOGE(userInfoBean.toString());
  //        return userInfoBean;
  //    }

  /**
   * 获取Token
   */
  //public String getToken() {
  //  return SharedPreferenceHelper.getUserToken();
  //}

  /**
   * 发起定位服务
   */
  //public void startLocation() {
  //  if (mLocationUtil == null || mLocationUtil.get() == null) {
  //    mLocationUtil = new WeakReference<>(new MapLocationUtil());
  //  }
  //  mLocationUtil.get().location(this);
  //}

  /**
   * 获取定位工具类
   */
  //public MapLocationUtil getLocationUtils() {
  //  if (mLocationUtil == null || mLocationUtil.get() == null) {
  //    mLocationUtil = new WeakReference<>(new MapLocationUtil());
  //  }
  //  return mLocationUtil.get();
  //}

  /**
   * 获取定位信息
   */
  //public BaidaiLocationInfo getLocationInfo() {
  //  return SharedPreferenceHelper.getLocation();
  //}

  /**
   * 注销帐号,修改相关登录状态及信息
   */
  //public void logout() {
  //  SharedPreferenceHelper.loginOut();
  //}
  //public DaoSession getDaoSession() {
  //  return mDaoSession;
  //}
  //
  //public SQLiteDatabase getDb() {
  //  return db;
  //}
}
