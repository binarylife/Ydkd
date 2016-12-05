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
    void getFixArea(String role,int areaid,String uid);
    /**
     * 指派工单给工人
     */
    void dispatchOrder(String id,String accountA,String accountB);
    /**
     * 指派故障工单给工人
     */
    void dispatchSingleFault(String id,String accountA,String accountB);
    /**
     * 指派工单给工人
     */
    void affirmOrder(String wid);
    /**
     * 指派工单给工人
     */
    void isCancelOrder(String wid,int isSuccess);
    /**
     * 指派工单给工人
     */
    void affirmSingleFault(String wid);
    /**
     * 指派工单给工人
     */
    void isCancelSingleFault(String wid,int isSuccess);
    /**
     * 保存工单区县
     */
    void updateSingleFault(String area,String sid);

}
