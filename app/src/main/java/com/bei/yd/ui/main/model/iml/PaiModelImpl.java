package com.bei.yd.ui.main.model.iml;

import android.content.Context;
import com.bei.yd.api.IApiConfig;
import com.bei.yd.ui.main.api.MainFragmentApi;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
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


    @Override public void getAllAreaPaiWorker(String role, int areaid,
        Subscriber<UserInfoBeans> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.getAllPaiWorker(role,areaid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
    @Override public void getAllAreaFixPaiWorker(String role, int areaid,int uid,
        Subscriber<UserInfoBeans> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.getAllFixPaiWorker(role,areaid,uid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
    /**
     * 派单给故障单
     * @param id
     * @param accountA
     * @param accountB
     * @param callback
   */
    @Override public void dispatchSingleFault(int id, String accountA, String accountB,
        Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.dispatchSingleFault(id,accountA,accountB)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
    @Override public void dispatchOrder(int id, String accountA, String accountB,
        Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.dispatchOrder(id,accountA,accountB)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
    @Override public void affirmOrder(int wid, Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.affirmOrder(wid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }

    /**
     * 装机完成 （故障单）
     * @param wid
     * @param callback
   */
    @Override public void affirmSingleFault(int wid, Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.affirmSingleFault(wid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }
    @Override public void isCancelOrder(int wid,int isSuccess, Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.isCancelOrder(wid,isSuccess)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(callback);
    }

  /**
   * 区县派单员确认
   * @param wid
   * @param isSuccess
   * @param callback
   */
    @Override public void isCancelSingleFault(int wid,int isSuccess, Subscriber<MainBean> callback) {
        MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
        api.isCancelSingleFault(wid,isSuccess)
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
