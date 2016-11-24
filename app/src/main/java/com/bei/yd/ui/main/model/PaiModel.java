package com.bei.yd.ui.main.model;

import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import rx.Subscriber;

/**
 * 派单相关的model
 *
 * @author: fb on 16/4/25.
 */
public interface PaiModel {

  /**
   * 获取所有可派的worker
   * @param callback
   */
  void getAllAreaPaiWorker(Subscriber<AreaBean> callback);

}
