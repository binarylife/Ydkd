package com.bei.yd.ui.main.presenter.iml;

import android.content.Context;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.model.iml.MainModelImpl;
import com.bei.yd.ui.main.presenter.IMainPresenter;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.ToastUtil;
import rx.Subscriber;

/**
 * 精彩景点
 * MVP模式--->P模型
 *
 * @author: yujin on 16/4/25.
 */
public class MainPresenterImpl implements IMainPresenter {

  private Context mContext;
  /**
   * Model层引用
   */
  private MainModelImpl model;
  /**
   * View层引用
   * ceshi
   */
  private IMainView view;

  public MainPresenterImpl(Context context, IMainView view) {
    this.mContext = context;
    this.view = view;
    model = new MainModelImpl(context, this);
  }

  @Override public void addWorkOrder(String arae, int account, String address, int phone) {
    view.showProgress();
    model.addNewWO(arae, account, address, phone, new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean mainBean) {
        view.onAddGD(mainBean);
        ToastUtil.showNormalShortToast("请求成功" + mainBean.getCode());
      }
    });
  }

  @Override public void getAllNewWorkOrderList(String role, int account, int pn) {
    view.showProgress();
    model.getAllNewWOList(role, account, pn, new Subscriber<MainItemNewOrderBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainItemNewOrderBean mainItemNewOrderBean) {
        view.hideProgress();
        view.onGetNewGDList(mainItemNewOrderBean);
      }
    });
  }

  @Override public void login(String userName, String PassWord) {
    view.showProgress();
    model.login(userName, PassWord, new Subscriber<UserInfoBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(UserInfoBean userInfoBean) {
        view.hideProgress();
        view.onLoginSuccess(userInfoBean);
      }
    });
  }

  /**
   * 获取区县
   * @param userName
   * @param PassWord
   */
  @Override public void getArea() {
    view.showProgress();
    model.getArea(new Subscriber<AreaBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(AreaBean areaBean) {
        view.hideProgress();
        view.onGetAreaSuccess(areaBean);
      }
    });
  }
}
