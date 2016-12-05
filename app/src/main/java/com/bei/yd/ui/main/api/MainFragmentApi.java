package com.bei.yd.ui.main.api;

import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2016/7/21.
 */
public interface MainFragmentApi {
  /**
   * 新增工单
   */
  @POST("addWorkOrder") Observable<MainBean> addNewWorkOrder(@Query("area") String area,
      @Query("account") String account, @Query("address") String address,
      @Query("phone") String phone);

  /**
   * 新增故障工单
   */
  @POST("addSingleFault") Observable<MainBean> addFixWorkOrder(@Query("area") String area,
      @Query("account") String account, @Query("address") String address,
      @Query("phone") String phone);

  /**
   * 获取最新工单列表
   */
  @POST("queryWorkOrderList") Observable<MainItemNewOrderBean> getAllNewWorkOrderList(
      @Query("role") String role, @Query("account") String account, @Query("pageIndex") int address,
      @Query("pageSize") int pageSize);

  /**
   * 登录
   */
  @POST("login") Observable<UserInfoBean> login(@Query("account") String userName,
      @Query("pwd") String passWord);

  /**
   * 获取所有区县
   */
  @POST("queryArea") Observable<AreaBean> getArae();

  /**
   * 获取可派人员列表
   */
  @POST("queryOtherUser") Observable<UserInfoBeans> getAllPaiWorker(@Query("role") String role,
      @Query("areaid") int areaid);

  /**
   * 获取可派人员列表(故障)
   */
  @POST("queryOtherUserTwo") Observable<UserInfoBeans> getAllFixPaiWorker(
      @Query("role") String role, @Query("areaid") int areaid, @Query("uid") String uid);

  /**
   * @param accountA 派单人
   * @param accountB 指定人
   */
  @POST("dispatchOrder") Observable<MainBean> dispatchOrder(@Query("id") String id,
      @Query("accountA") String accountA, @Query("accountB") String accountB);

  /**
   * 故障单指派
   *
   * @param accountA 派单人
   * @param accountB 指定人
   */
  @POST("dispatchSingleFault") Observable<MainBean> dispatchSingleFault(@Query("id") String id,
      @Query("accountA") String accountA, @Query("accountB") String accountB);

  /**
   * 装机人安装完成--进行回单
   */
  @POST("affirmOrder") Observable<MainBean> affirmOrder(@Query("wid") String wid);

  /**
   * 装机人安装完成--进行回单
   */
  @POST("isCancelOrder") Observable<MainBean> isCancelOrder(@Query("wid") String wid,
      @Query("isSuccess") int isSuccess);

  /**
   * 新增维修工单
   */
  @POST("addSingleFault") Observable<MainBean> addSingleFault(@Query("area") String area,
      @Query("account") String account, @Query("address") String address,
      @Query("phone") String phone);

  /**
   * 获取最新工单列表
   */
  @POST("querySingleFault") Observable<MainItemNewOrderBean> querySingleFault(
      @Query("role") String role, @Query("account") String account, @Query("pageIndex") int address,
      @Query("pageSize") int pageSize);

  /**
   * 装机人安装完成--进行回单(故障)
   */
  @POST("affirmSingleFault") Observable<MainBean> affirmSingleFault(@Query("sid") String wid);

  /**
   * 装机人安装完成--进行回单（故障）
   */
  @POST("isCancelSingleFault") Observable<MainBean> isCancelSingleFault(@Query("sid") String wid,
      @Query("isSuccess") int isSuccess);

  /**
   * 统计筛选工单（普通）
   */
  @POST("statisticsWorkOrderList") Observable<MainItemNewOrderBean> statisticsWorkOrderList(
      @Query("role") String role, @Query("account") String account, @Query("pageIndex") int address,
      @Query("pageSize") int pageSize, @Query("area") String area,
      @Query("account_u") String account_u, @Query("phone") String phone,
      @Query("dispatchtime") String dispatchtime, @Query("taketime") String taketime,
      @Query("installtime") String installtime, @Query("overtime") String overtime,
      @Query("dispatchwarning") String dispatchwarning,
      @Query("installwarning") String installwarning, @Query("visitwarning") String visitwarning,
      @Query("repeatnum") String repeatnum, @Query("iscancel") String iscancel ,
      @Query("isend") String isend);
  /**
   * 统计筛选工单（故障）
   */
  @POST("statisticsSingleFault") Observable<MainItemNewOrderBean> statisticsSingleFault(
      @Query("role") String role, @Query("account") String account, @Query("pageIndex") int address,
      @Query("pageSize") int pageSize, @Query("area") String area,
      @Query("account_u") String account_u, @Query("phone") String phone,
      @Query("dispatchtime") String dispatchtime, @Query("taketime") String taketime,
      @Query("installtime") String installtime, @Query("overtime") String overtime,
      @Query("dispatchwarning") String dispatchwarning,
      @Query("installwarning") String installwarning, @Query("visitwarning") String visitwarning,
      @Query("repeatnum") String repeatnum, @Query("iscancel") String iscancel ,@Query("isend") String isend,
      @Query("dispatchwarning1") String dispatchwarning1 ,
      @Query("dispatchwarning2") String dispatchwarning2,
      @Query("dispatchtime21") String dispatchtime21,
      @Query("dispatchtime22") String dispatchtime22);

  /**
   * 二级派单员修改工单(故障)
   */
  @POST("updateSingleFault") Observable<MainBean> updateSingleFault(@Query("area") String area,@Query("sid") String id);
}
