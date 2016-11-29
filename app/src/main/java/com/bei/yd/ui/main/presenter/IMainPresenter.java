package com.bei.yd.ui.main.presenter;

/**
 * @author: yujin on 16/4/25.
 */
public interface IMainPresenter {

  /**
   * 新建工单
   * @param arae  区域id
   * @param account  录入人员信息id
   * @param address  地址
   * @param phone  电话
   */
    void addWorkOrder(String arae, String account, String address, int phone);
  /**
   * 新建故障工单
   * @param arae  区域id
   * @param account  录入人员信息id
   * @param address  地址
   * @param phone  电话
   */
  void addFixWorkOrder(String arae, String account, String address, int phone);
    /**
     * 获取工单列表
     */
    void getAllNewWorkOrderList(String role, int account,int pn);
    /**
     * 登录
     */
    void login(String userName, String PassWord);
    /**
     * 登录
     */
    void getArea();
}
