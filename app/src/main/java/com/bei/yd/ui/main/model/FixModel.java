package com.bei.yd.ui.main.model;

import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import rx.Subscriber;

/**
 * 派单相关的model
 *
 * @author: fb on 16/4/25.
 */
public interface FixModel {

  /**
   * 所有工单维修获取
   */
  void querySingleFault( String role,int account,int pageIndex ,
      Subscriber<MainItemNewOrderBean> callback);

  /**
   * 获取所有可派的worker
   */
  void getAllAreaPaiWorker(String role, int areaid, Subscriber<UserInfoBeans> callback);

  /**
   * 向指定的worker派单
   */
  void dispatchOrder(int id, String accountA, String accountB, Subscriber<MainBean> callback);

  /**
   * 装机人安装完成--进行回单
   */
  void affirmOrder(int wid, Subscriber<MainBean> callback);

  /**
   * 确认装机成功/撤单/退单
   */
  void isCancelOrder(int wid, int isSuccess, Subscriber<MainBean> callback);
}
