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
      @Query("account") String account, @Query("address") String address, @Query("phone") int phone);
  /**
   * 新增故障工单
   */
  @POST("addSingleFault") Observable<MainBean> addFixWorkOrder(@Query("area") String area,
      @Query("account") String account, @Query("address") String address, @Query("phone") int phone);
  /**
   * 获取最新工单列表
   */
  @POST("queryWorkOrderList") Observable<MainItemNewOrderBean> getAllNewWorkOrderList(
      @Query("role") String role, @Query("account") int account, @Query("pageIndex") int address,
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
  @POST("queryOtherUser") Observable<UserInfoBeans> getAllPaiWorker(@Query("role") String role  ,
      @Query("areaid") int areaid);
  /**
   * 获取可派人员列表(故障)
   */
  @POST("queryOtherUserTwo") Observable<UserInfoBeans> getAllFixPaiWorker(@Query("role") String role  ,
      @Query("areaid") int areaid,
      @Query("uid") int uid);
  /**
   * @param id
   * @param accountA 派单人
   * @param accountB 指定人
   * @return
   */
  @POST("dispatchOrder") Observable<MainBean> dispatchOrder(@Query("id") int id,
      @Query("accountA") String accountA,@Query("accountB") String accountB);

  /**
   *
   * 故障单指派
   * @param accountA 派单人
   * @param accountB 指定人
   * @return
   */
  @POST("dispatchSingleFault") Observable<MainBean> dispatchSingleFault(@Query("id") int id,
      @Query("accountA") String accountA,@Query("accountB") String accountB);
  /**
   *
   *  装机人安装完成--进行回单
   *
   * @return
   */
  @POST("affirmOrder") Observable<MainBean> affirmOrder(@Query("wid") int wid);
  /**
   *
   *  装机人安装完成--进行回单
   * @return
   */
  @POST("isCancelOrder") Observable<MainBean> isCancelOrder(@Query("wid") int wid,@Query("isSuccess") int isSuccess);
  /**
   * 新增维修工单
   */
  @POST("addSingleFault") Observable<MainBean> addSingleFault(@Query("area") String area,
      @Query("account") String account, @Query("address") String address, @Query("phone") int phone);


  /**
   * 获取最新工单列表
   */
  @POST("querySingleFault") Observable<MainItemNewOrderBean> querySingleFault(
      @Query("role") String role, @Query("account") int account, @Query("pageIndex") int address,
      @Query("pageSize") int pageSize);
  /**
   *
   *  装机人安装完成--进行回单(故障)
   *
   * @return
   */
  @POST("affirmSingleFault") Observable<MainBean> affirmSingleFault(@Query("wid") int wid);
  /**
   *
   *  装机人安装完成--进行回单（故障）
   * @return
   */
  @POST("isCancelSingleFault") Observable<MainBean> isCancelSingleFault(@Query("wid") int wid,@Query("isSuccess") int isSuccess);
}
