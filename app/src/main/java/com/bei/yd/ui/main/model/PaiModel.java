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
  void getAllAreaFixPaiWorker(String role, int areaid,String uid, Subscriber<UserInfoBeans> callback);
  /**
   * 向指定的worker派单uid
   */
  void dispatchOrder(String id, String accountA, String accountB, Subscriber<MainBean> callback);
  /**
   * 向指定的worker派故障单
   */
  void dispatchSingleFault(String id, String accountA, String accountB, Subscriber<MainBean> callback);
  /**
   * 装机人安装完成--进行回单
   */
  void affirmOrder(String wid, Subscriber<MainBean> callback);
  /**
   * 装机人安装完成--进行回单（故障）
   */
  void affirmSingleFault(String wid, Subscriber<MainBean> callback);

  /**
   * 确认装机成功/撤单/退单
   */
  void isCancelOrder(String wid,String reason, int isSuccess, Subscriber<MainBean> callback);
  /**
   * 确认装机成功/撤单/退单
   */
  void isCancelSingleFault(String wid, int isSuccess, Subscriber<MainBean> callback);
  /**
   * 确认装机成功/撤单/退单
   */
  void updateSingleFault(String area, String sid, Subscriber<MainBean> callback);
}
