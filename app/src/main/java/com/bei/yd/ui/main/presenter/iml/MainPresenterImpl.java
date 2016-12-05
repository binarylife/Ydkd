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

  @Override public void addWorkOrder(String arae, String account, String address, String phone) {
    view.showProgress();
    model.addNewWO(arae, account, address, phone, new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean mainBean) {
        if (mainBean.isSuccessful()) {
          view.onAddGD(mainBean);
          ToastUtil.showNormalShortToast("新建工单成功");
        } else {
          ToastUtil.showNormalShortToast(mainBean.getMessage());
        }
      }
    });
  }

  @Override public void addFixWorkOrder(String arae, String account, String address, String phone) {
    view.showProgress();
    model.addFixWO(arae, account, address, phone, new Subscriber<MainBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainBean mainBean) {
        if (mainBean.isSuccessful()) {
          view.onAddGD(mainBean);
          ToastUtil.showNormalShortToast("新建故障工单成功");
        } else {
          ToastUtil.showNormalShortToast(mainBean.getMessage());
        }
      }
    });
  }

  @Override public void getAllNewWorkOrderList(String role, String account, final int pn) {
    view.showProgress();
    model.getAllNewWOList(role, account, pn, new Subscriber<MainItemNewOrderBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainItemNewOrderBean mainItemNewOrderBean) {
        view.hideProgress();
        if (pn <= 1) {
          view.onGetNewGDList(mainItemNewOrderBean);
        } else {
          view.onGetNewGDListMore(mainItemNewOrderBean);
        }
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

  @Override public void statisticsWorkOrderList(String role, String account, final int pn, String area,
      String account_u, String phone, String dispatchtime, String taketime, String installtime,
      String overtime, String dispatchwarning, String installwarning, String visitwarning,
      String repeatnum, String iscancel, String isend) {
    view.showProgress();
    model.statisticsWorkOrderList(role, account, pn, area, account_u, phone, dispatchtime, taketime,
        installtime, overtime, dispatchwarning, installwarning, visitwarning, repeatnum, iscancel,
        isend, new Subscriber<MainItemNewOrderBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(MainItemNewOrderBean mainItemNewOrderBean) {
            view.hideProgress();
            if (pn <= 1) {
              view.onGetNewGDList(mainItemNewOrderBean);
            } else {
              view.onGetNewGDListMore(mainItemNewOrderBean);
            }
          }
        });
  }

  @Override
  public void statisticsSingleFault(String role, String account, final int pn, String area, String account_u,
      String phone, String dispatchtime, String taketime, String installtime, String overtime,
      String dispatchwarning, String installwarning, String visitwarning, String repeatnum,
      String iscancel, String isend, String dispatchwarning1, String dispatchwarning2,
      String dispatchtime21, String dispatchtime22) {
    view.showProgress();
    model.statisticsSingleFault(role, account, pn, area, account_u, phone, dispatchtime, taketime,
        installtime, overtime, dispatchwarning, installwarning, visitwarning, repeatnum, iscancel,
        isend, dispatchwarning1, dispatchwarning2, dispatchtime21, dispatchtime22,
        new Subscriber<MainItemNewOrderBean>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {

          }

          @Override public void onNext(MainItemNewOrderBean mainItemNewOrderBean) {
            view.hideProgress();
            if (pn <= 1) {
              view.onGetNewGDList(mainItemNewOrderBean);
            } else {
              view.onGetNewGDListMore(mainItemNewOrderBean);
            }
          }
        });
  }
}
