package com.bei.yd.ui.main.api;

import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2016/7/21.
 */
public interface MainFragmentApi {
  /**
   * 新增工单
   *
   * @return
   */
  @POST("addWorkOrder") Observable<MainBean> addNewWorkOrder(
      @Query("area") String area, @Query("account") int account, @Query("address") String address, @Query("phone") int phone);
  /**
   * 获取最新工单列表
   * @return
   */
  @POST("queryWorkOrderList") Observable<MainItemNewOrderBean> getAllNewWorkOrderList(
      @Query("role") int role, @Query("account") int account, @Query("pageIndex") int address, @Query("pageSize") int pageSize);
  /**
   * 登录
   * @return
   */
  @POST("login") Observable<UserInfoBean> login(
      @Query("account") String userName, @Query("pwd") String passWord);
}
