package com.bei.yd.ui.main.model.iml;

import android.content.Context;
import com.bei.yd.api.IApiConfig;
import com.bei.yd.ui.main.api.MainFragmentApi;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.model.MainModel;
import com.bei.yd.ui.main.model.PaiModel;
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
public class PaiModelImpl implements PaiModel, IApiConfig {

    private Context mContext;

    public PaiModelImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override public void getAllAreaPaiWorker(Subscriber<AreaBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.getAllPaiWorker()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
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
