package com.bei.yd.ui.main.model.iml;

import android.content.Context;
import com.bei.yd.api.IApiConfig;
import com.bei.yd.ui.main.api.MainFragmentApi;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import com.bei.yd.ui.main.model.FixModel;
import com.bei.yd.ui.main.model.MainModel;
import com.bei.yd.ui.main.presenter.iml.FixPresenterImpl;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.utils.RestAdapterUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 精彩景点
 * MVP模式--->M模型
 *
 * @author: yujin on 16/4/25.
 */
public class FixModelImpl implements FixModel, IApiConfig {

    private Context mContext;
    /**
     * MVP---> P层引用
     */
    private FixPresenterImpl mPresenter;

    public FixModelImpl(Context context, FixPresenterImpl presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
    }



    /**
     * 获取所有维修工单
     * @param role
     * @param account
     * @param pageIndex
     * @param callback
   */
    @Override public void querySingleFault(String role, String account, int pageIndex,
        Subscriber<MainItemNewOrderBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.querySingleFault(role, account,pageIndex,PAGESIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }

    @Override
    public void getAllAreaPaiWorker(String role, int areaid, Subscriber<UserInfoBeans> callback) {

    }

    @Override public void dispatchOrder(int id, String accountA, String accountB,
        Subscriber<MainBean> callback) {

    }

    @Override public void affirmOrder(String wid, Subscriber<MainBean> callback) {

    }

    @Override public void isCancelOrder(String wid, int isSuccess, Subscriber<MainBean> callback) {

    }

    //@Override public void login(String ){
    //    Subscriber<MainItemNewOrderBean> callback) {
    //    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    //    api.getAllNewWorkOrderList(role, account,pageIndex,PAGESIZE)
    //        .subscribeOn(Schedulers.io())
    //        .observeOn(AndroidSchedulers.mainThread())
    //        .subscribe(callback);
    //}

}
