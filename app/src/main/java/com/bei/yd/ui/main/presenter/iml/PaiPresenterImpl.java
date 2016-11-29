package com.bei.yd.ui.main.presenter.iml;

import android.content.Context;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import com.bei.yd.ui.main.model.PaiModel;
import com.bei.yd.ui.main.model.iml.MainModelImpl;
import com.bei.yd.ui.main.model.iml.PaiModelImpl;
import com.bei.yd.ui.main.presenter.IMainPresenter;
import com.bei.yd.ui.main.presenter.IPaiPresenter;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.ui.main.view.IpaiView;
import com.bei.yd.utils.ToastUtil;
import rx.Subscriber;

/**
 * 精彩景点
 * MVP模式--->P模型
 *
 * @author: yujin on 16/4/25.
 */
public class PaiPresenterImpl implements IPaiPresenter {

  private Context mContext;
  /**
   * Model层引用
   */
  private PaiModel model;
  /**
   * View层引用
   * ceshi
   */
  private IpaiView view;

  public PaiPresenterImpl(Context context, IpaiView view) {
    this.mContext = context;
    this.view = view;
    model = new PaiModelImpl(context);
  }


  /**
   * 获取可派人员列表
   */
  @Override public void getArea(String role, int areaid) {
    view.showProgress();
    model.getAllAreaPaiWorker(role,areaid,new Subscriber<UserInfoBeans>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(UserInfoBeans areaBean) {
        view.hideProgress();
        //if (pn <= 1) {
          view.onGetPaiWorkerSuccess(areaBean);
        //} else {
        //  view.onGetNewGDListMore(mainItemNewOrderBean);
        //}
      }
    });
  }
  /**
   * 获取可派人员列表
   */
  @Override public void getFixArea(String role, int areaid,int uid) {
    view.showProgress();
    model.getAllAreaFixPaiWorker(role,areaid,uid,new Subscriber<UserInfoBeans>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(UserInfoBeans areaBean) {
        view.hideProgress();
        //if (pn <= 1) {
        view.onGetPaiWorkerSuccess(areaBean);
        //} else {
        //  view.onGetNewGDListMore(mainItemNewOrderBean);
        //}
      }
    });
  }
  /**
   *
   * @param id
   * @param accountA
   * @param accountB
   */
  @Override public void dispatchOrder(int id,String accountA,String accountB) {
    view.showProgress();
    model.dispatchOrder(id,accountA,accountB,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onDispatchSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }
  /**
   *故障单指派
   * @param id
   * @param accountA
   * @param accountB
   */
  @Override public void dispatchSingleFault(int id,String accountA,String accountB) {
    view.showProgress();
    model.dispatchSingleFault(id,accountA,accountB,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onDispatchSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }

  @Override public void affirmOrder(int wid) {
    view.showProgress();
    model.affirmOrder(wid,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onaffirmOrderSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }

  @Override public void isCancelOrder(int wid, int isSuccess) {
    model.isCancelOrder(wid,isSuccess,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onisCancelOrderSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }
  @Override public void affirmSingleFault(int wid) {
    view.showProgress();
    model.affirmSingleFault(wid,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onaffirmOrderSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }

  @Override public void isCancelSingleFault(int wid, int isSuccess) {
    model.isCancelSingleFault(wid,isSuccess,new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean areaBean) {
        view.hideProgress();
        if (areaBean.isSuccessful()) {
          view.onisCancelOrderSuccess(areaBean);
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }else{
          ToastUtil.showNormalShortToast(areaBean.getMessage());
        }
      }
    });
  }
}
