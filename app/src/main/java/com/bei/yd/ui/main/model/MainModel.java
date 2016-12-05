package com.bei.yd.ui.main.model;

import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import rx.Subscriber;

/**
 * 精彩景点列表和标签列表用接口相同,故而用同一个Model, 但文件名起的是精彩景点.
 *
 * @author: yujin on 16/4/25.
 */
public interface MainModel {

  /**
   * 新建neworder
   */
  void addNewWO(String arae, String account, String address, String phone,
      Subscriber<MainBean> callback);

  /**
   * 新建Fixorder
   */
  void addFixWO(String arae, String account, String address, String phone,
      Subscriber<MainBean> callback);

  /**
   * 所有工单获取
   */
  void getAllNewWOList(String role, String account, int pageIndex,
      Subscriber<MainItemNewOrderBean> callback);

  /**
   * 登录
   */
  void login(String userName, String passWord, Subscriber<UserInfoBean> callback);

  /**
   * 获取区县
   */
  void getArea(Subscriber<AreaBean> callback);

  /**
   * 所有工单获取(查询)
   */
  void statisticsWorkOrderList(String role, String account, int pageIndex, String area,
      String account_u, String phone, String dispatchtime, String taketime, String installtime,
      String overtime, String dispatchwarning, String installwarning, String visitwarning,
      String repeatnum, String iscancel, String isend, Subscriber<MainItemNewOrderBean> callback);

  /**
   * 所有工单获取(故障)
   */
  void statisticsSingleFault(String role, String account, int pageIndex, String area, String account_u,
      String phone, String dispatchtime, String taketime, String installtime, String overtime,
      String dispatchwarning, String installwarning, String visitwarning, String repeatnum,
      String iscancel, String isend,String dispatchwarning1,
      String dispatchwarning2,
      String dispatchtime21, String dispatchtime22,
      Subscriber<MainItemNewOrderBean>callback);
}
