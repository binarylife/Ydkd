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
  void getAllAreaPaiWorker(Subscriber<UserInfoBeans> callback);

  /**
   * 向指定的worker派单
   */
  void dispatchOrder(int id, String accountA, String accountB, Subscriber<MainBean> callback);
}
