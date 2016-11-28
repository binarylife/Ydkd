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
public interface IFixView extends IBaseView {
    /**
     * 获取更多工单筛选结果
     * @param bean
     */
    void onQuerySingleFaultMore(MainItemNewOrderBean bean);
    /**
     * 增加筛选结果
     * @param bean
     */
    void onQuerySingleFault(MainItemNewOrderBean bean);
    /**
     * 登录成功的bean
     * @param bean
     */
    void onGetAreaSuccess(AreaBean bean);
}
