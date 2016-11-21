package com.bei.yd.ui.main.presenter;

/**
 * @author: yujin on 16/4/25.
 */
public interface IMainPresenter {

    /**
     * 新加工单
     */
    void addWorkOrder(String arae, int account, String address, int phone);
    /**
     * 获取工单列表
     */
    void getAllNewWorkOrderList(int role, int account,int pn);
    /**
     * 登录
     */
    void login(String userName, String PassWord);
}
