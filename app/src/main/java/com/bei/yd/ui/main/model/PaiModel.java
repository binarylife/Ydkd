package com.bei.yd.ui.main.model;

import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import rx.Subscriber;

/**
 * 派单相关的model
 *
 * @author: fb on 16/4/25.
 */
public interface PaiModel {

  /**
   * 获取所有可派的worker
   */
  void getAllAreaPaiWorker(String role, int areaid, Subscriber<UserInfoBeans> callback);
  /**
   * 获取所有可派的worker(故障)
   */
  void getAllAreaFixPaiWorker(String role, int areaid,int uid, Subscriber<UserInfoBeans> callback);
  /**
   * 向指定的worker派单uid
   */
  void dispatchOrder(int id, String accountA, String accountB, Subscriber<MainBean> callback);
  /**
   * 向指定的worker派故障单
   */
  void dispatchSingleFault(int id, String accountA, String accountB, Subscriber<MainBean> callback);
  /**
   * 装机人安装完成--进行回单
   */
  void affirmOrder(int wid, Subscriber<MainBean> callback);
  /**
   * 装机人安装完成--进行回单（故障）
   */
  void affirmSingleFault(int wid, Subscriber<MainBean> callback);

  /**
   * 确认装机成功/撤单/退单
   */
  void isCancelOrder(int wid, int isSuccess, Subscriber<MainBean> callback);
  /**
   * 确认装机成功/撤单/退单
   */
  void isCancelSingleFault(int wid, int isSuccess, Subscriber<MainBean> callback);
  /**
   * 确认装机成功/撤单/退单
   */
  void updateSingleFault(String area, String sid, Subscriber<MainBean> callback);
}
