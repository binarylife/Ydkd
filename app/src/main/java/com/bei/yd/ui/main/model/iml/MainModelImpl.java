package com.bei.yd.ui.main.model.iml;

import android.content.Context;
import com.bei.yd.api.IApiConfig;
import com.bei.yd.ui.main.api.MainFragmentApi;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
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

  /**
   * 新建工单
   */
  @Override public void addNewWO(String arae, String account, String address, String phone,
      Subscriber<MainBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.addNewWorkOrder(arae, account, address, phone)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  /**
   * 新建故障工单
   */
  @Override public void addFixWO(String arae, String account, String address, String phone,
      Subscriber<MainBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.addFixWorkOrder(arae, account, address, phone)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  /**
   * 获取全部工单
   */
  @Override public void getAllNewWOList(String role, String account, int pageIndex,
      Subscriber<MainItemNewOrderBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.getAllNewWorkOrderList(role, account, pageIndex, PAGESIZE)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  @Override public void login(String userName, String passWord, Subscriber<UserInfoBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.login(userName, passWord)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  @Override public void getArea(Subscriber<AreaBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.getArae()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  @Override
  public void statisticsWorkOrderList(String role, String account, int pageIndex, String area,
      String account_u, String phone, String dispatchtime, String taketime, String installtime,
      String overtime, String dispatchwarning, String installwarning, String visitwarning,
      String repeatnum, String iscancel, String isend,
      Subscriber<MainItemNewOrderBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.statisticsWorkOrderList(role, account, pageIndex, PAGESIZE, area, account_u, phone,
        dispatchtime, taketime, installtime, overtime, dispatchwarning, installwarning,
        visitwarning,repeatnum,iscancel,isend)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(callback);
  }

  @Override public void statisticsSingleFault(String role, String account, int pageIndex, String area,
      String account_u, String phone, String dispatchtime, String taketime, String installtime,
      String overtime, String dispatchwarning, String installwarning, String visitwarning,
      String repeatnum, String iscancel, String isend, String dispatchwarning1,
      String dispatchwarning2, String dispatchtime21, String dispatchtime22,
      Subscriber<MainItemNewOrderBean> callback) {
    MainFragmentApi api = RestAdapterUtils.getRestAPI(BASE_URL, MainFragmentApi.class);
    api.statisticsSingleFault(role, account, pageIndex, PAGESIZE, area, account_u, phone,
        dispatchtime, taketime, installtime, overtime, dispatchwarning, installwarning,
        visitwarning,repeatnum,iscancel,isend,dispatchwarning1,dispatchwarning2,dispatchtime21,dispatchtime22)
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
