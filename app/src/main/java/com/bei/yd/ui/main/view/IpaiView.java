package com.bei.yd.ui.main.view;

import com.bei.yd.ui.base.view.IBaseView;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;

/**
 * 精彩景点
 * MVP模式--->V模型
 *
 * @author: yujin on 16/4/25.
 *
 */
public interface IpaiView extends IBaseView {
    /**
     * 获取可人员名单
     * @param bean
     */
    void onGetPaiWorkerSuccess(UserInfoBeans bean);
    /**
     * 获取可人员名单(加载更多)
     * @param bean
     */
    void onGetPaiWorkerSuccessMore(UserInfoBeans bean);
    /**
     * 派单成功
     * @param bean
     */
    void onDispatchSuccess(MainBean bean);
    /**
     * 装机人安装完成--进行回单
     * @param bean
     */
    void onaffirmOrderSuccess(MainBean bean);
    /**
     * 确认装机成功/撤单/退单
     * @param bean
     */
    void onisCancelOrderSuccess(MainBean bean);
}
