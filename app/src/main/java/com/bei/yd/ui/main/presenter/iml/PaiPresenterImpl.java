package com.bei.yd.ui.main.presenter.iml;

import android.content.Context;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
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
  @Override public void getArea() {
    view.showProgress();
    model.getAllAreaPaiWorker(new Subscriber<AreaBean>() {
      @Override public void onCompleted() {

      }

      @Override public void onError(Throwable e) {

      }

      @Override public void onNext(AreaBean areaBean) {
        view.hideProgress();
        view.onGetPaiWorkerSuccess(areaBean);
      }
    });
  }
}
