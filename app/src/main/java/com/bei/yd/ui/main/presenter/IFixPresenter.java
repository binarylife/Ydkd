package com.bei.yd.ui.main.presenter;

/**
 * @author: fb on 16/4/25.
 */
public interface IFixPresenter {
    /**
     * 获取可派工单人员
     */
    void getArea(String role, int areaid);
    /**
     * 指派工单给工人
     */
    void querySingleFault(String role, int account,int pn);
    /**
     * 指派工单给工人
     */
    void affirmOrder(int wid);
    /**
     * 指派工单给工人
     */
    void isCancelOrder(int wid, int isSuccess);
}
