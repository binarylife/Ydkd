package com.bei.yd.ui.main.model.iml;

import android.content.Context;
import com.bei.yd.api.IApiConfig;
import com.bei.yd.ui.main.api.MainFragmentApi;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.model.MainModel;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.utils.RestAdapterUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.bei.yd.api.IApiConfig.BASE_URL;

/**
 * 精彩景点
 * MVP模式--->M模型
 *
 * @author: yujin on 16/4/25.
 */
public class MainModelImpl implements MainModel, IApiConfig {

    private Context mContext;
    /**
     * MVP---> P层引用
     */
    private MainPresenterImpl mPresenter;

    public MainModelImpl(Context context, MainPresenterImpl presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
    }

    @Override public void addNewWO(String arae, int account, String address, int phone,
        Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.addNewWorkOrder(arae, account,address,phone)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }

    @Override public void getAllNewWOList(int role, int account, int pageIndex,
        Subscriber<MainItemNewOrderBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.getAllNewWorkOrderList(role, account,pageIndex,PAGESIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
}
