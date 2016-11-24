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
   * @param type   工单类型(新增 或是 修理)
   */
    void addWorkOrder(String arae, int account, String address, int phone,String type);
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
