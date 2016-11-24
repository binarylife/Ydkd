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
  void addNewWO(String arae, int account, String address, int phone,String type,
      Subscriber<MainBean> callback);

  /**
   * 所有工单获取
   */
  void getAllNewWOList( String role,int account,int pageIndex ,
      Subscriber<MainItemNewOrderBean> callback);

  /**
   * 登录
   */
  void login(String userName,String passWord,
      Subscriber<UserInfoBean> callback);
  /**
   * 获取区县
   */
  void getArea(Subscriber<AreaBean> callback);

}
