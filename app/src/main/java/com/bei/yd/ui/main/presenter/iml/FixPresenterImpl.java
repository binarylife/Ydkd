package com.bei.yd.ui.main.presenter.iml;

import android.content.Context;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.model.iml.FixModelImpl;
import com.bei.yd.ui.main.model.iml.MainModelImpl;
import com.bei.yd.ui.main.presenter.IFixPresenter;
import com.bei.yd.ui.main.presenter.IMainPresenter;
import com.bei.yd.ui.main.view.IFixView;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.ToastUtil;
import rx.Subscriber;

/**
 * 精彩景点
 * MVP模式--->P模型
 *
 * @author: yujin on 16/4/25.
 */
public class FixPresenterImpl implements IFixPresenter {

  private Context mContext;
  /**
   * Model层引用
   */
  private FixModelImpl model;
  /**
   * View层引用
   * ceshi
   */
  private IFixView view;

  public FixPresenterImpl(Context context, IFixView view) {
    this.mContext = context;
    this.view = view;
    model = new FixModelImpl(context, this);
  }



  @Override public void getArea(String role, int areaid) {

  }

  @Override public void querySingleFault(String role, String account, final int pn) {
    view.showProgress();
    model.querySingleFault(role, account, pn, new Subscriber<MainItemNewOrderBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(MainItemNewOrderBean mainItemNewOrderBean) {
        view.hideProgress();
        if (pn <= 1) {
          view.onQuerySingleFault(mainItemNewOrderBean);
        } else {
          view.onQuerySingleFaultMore(mainItemNewOrderBean);
        }

      }
    });
  }

  @Override public void affirmOrder(String wid) {

  }

  @Override public void isCancelOrder(String
      wid, int isSuccess) {

  }
}
