package com.bei.yd.ui.main.view;

import com.bei.yd.ui.base.view.IBaseView;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;

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
    void onGetPaiWorkerSuccess(AreaBean bean);
}
