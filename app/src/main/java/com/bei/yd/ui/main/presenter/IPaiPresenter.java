package com.bei.yd.ui.main.presenter;

/**
 * @author: fb on 16/4/25.
 */
public interface IPaiPresenter {
    /**
     * 获取可派工单人员
     */
    void getArea(String role,int areaid);
    /**
     * 获取可派工单人员(故障)
     */
    void getFixArea(String role,int areaid,int uid);
    /**
     * 指派工单给工人
     */
    void dispatchOrder(int id,String accountA,String accountB);
    /**
     * 指派故障工单给工人
     */
    void dispatchSingleFault(int id,String accountA,String accountB);
    /**
     * 指派工单给工人
     */
    void affirmOrder(int wid);
    /**
     * 指派工单给工人
     */
    void isCancelOrder(int wid,int isSuccess);
    /**
     * 指派工单给工人
     */
    void affirmSingleFault(int wid);
    /**
     * 指派工单给工人
     */
    void isCancelSingleFault(int wid,int isSuccess);
    /**
     * 保存工单区县
     */
    void updateSingleFault(String area,String sid);

}
