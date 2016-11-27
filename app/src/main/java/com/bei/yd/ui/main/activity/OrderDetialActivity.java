package com.bei.yd.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.activity.BackBaseActivity;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.bean.UserInfoBeans;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.ui.main.presenter.iml.PaiPresenterImpl;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.ui.main.view.IpaiView;
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.MyUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.ToastUtil;

/**
 * 普通工单（详情页面）
 * Created by fengbei on 2016/3/10.
 */
public class OrderDetialActivity extends BackBaseActivity
    implements IpaiView, View.OnClickListener {
  // 用户账号
  @Bind(R.id.area) TextView mArea;
  @Bind(R.id.account) TextView account;
  @Bind(R.id.phone) TextView phone;
  @Bind(R.id.address) TextView address;
  @Bind(R.id.dispatchPeople) TextView dispatchPeople;
  @Bind(R.id.interfacePeople) TextView interfacePeople;
  @Bind(R.id.dispatchTime) TextView dispatchTime;
  @Bind(R.id.installPeople) TextView installPeople;
  @Bind(R.id.taketime) TextView taketime;
  @Bind(R.id.installTime) TextView installTime;
  @Bind(R.id.overTime) TextView overTime;
  @Bind(R.id.dispatchduration) TextView dispatchduration;
  @Bind(R.id.installduration) TextView installduration;
  @Bind(R.id.visitduration) TextView visitduration;
  @Bind(R.id.dispatchwaring) TextView dispatchwaring;
  @Bind(R.id.installwarning) TextView installwarning;
  @Bind(R.id.visitwarning) TextView visitwarning;
  @Bind(R.id.repeatnum) TextView repeatnum;
  @Bind(R.id.iscancle) TextView iscancle;
  @Bind(R.id.isend) TextView isend;
  @Bind(R.id.status) TextView status;
  @Bind(R.id.tv_dispatch) TextView tv_dispatch;
  @Bind(R.id.tv_chedan) TextView tv_chedan;
  @Bind(R.id.tv_huidan) TextView tv_huidan;

  //@Bind(R.id.bt_login) TextView mlogin;
  //  网络交互的逻辑层
  private MainPresenterImpl mineInfoPresenter;
  /**
   * 地址p
   */
  private MainItemNewOrderBean orderDetialBean;
  private int statusValue;
  private PaiPresenterImpl paiPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_detial);
    Bundle bundle = getIntent().getExtras();
    orderDetialBean = bundle.getParcelable(Constant.ORDER_DETAIL);
    //orderCreater = bundle.getString(Constant.ORDER_CREATER);
    //  初始化上传头像的逻辑层
    initView();
    paiPresenter = new PaiPresenterImpl(this, this);
  }

  @Override public void onResume() {
    super.onResume();
    // 从新获取数据
  }

  /**
   * 初始化控件
   */
  private void initView() {
    mArea.setText(orderDetialBean.getArea());
    account.setText(orderDetialBean.getAccount());
    phone.setText(orderDetialBean.getPhone());
    address.setText(orderDetialBean.getAddress());
    dispatchPeople.setText(orderDetialBean.getDispatchPeople());
    interfacePeople.setText(orderDetialBean.getInterfacePeople());
    dispatchTime.setText(orderDetialBean.getDispatchTime());
    installPeople.setText(orderDetialBean.getInstallPeople());
    taketime.setText(orderDetialBean.getTakeTime());
    installTime.setText(orderDetialBean.getInstallTime());
    overTime.setText(orderDetialBean.getOverTime());
    dispatchduration.setText(orderDetialBean.getDispatchDuration() + "");
    installduration.setText(orderDetialBean.getInstallDuration() + "");
    visitduration.setText(orderDetialBean.getVisitDuration() + "");
    dispatchwaring.setText(orderDetialBean.getDispatchWarning() + "");
    installwarning.setText(orderDetialBean.getInstallWarning() + "");
    visitwarning.setText(orderDetialBean.getVisitWarning() + "");
    repeatnum.setText(orderDetialBean.getRepeatNum() + "");
    iscancle.setText(orderDetialBean.getIsCancel() + "");
    isend.setText(orderDetialBean.getIsEnd() + "");
    status.setText(orderDetialBean.getStatus() + "");
    statusValue = orderDetialBean.getStatus();
    showBottomButton();
  }

  /**
   * 展示buttom上的文字
   */
  private void showBottomButton() {
    switch (SharedPreferenceHelper.getUserRole()) {
      //  判断用户的角色
      //case "A":
      //  break;
      case "B":// 区县派单员
        if (statusValue == 1) {
          //  新建工单
          tv_dispatch.setText("点击此处指派工单");
        } else if (statusValue == 4) {
          // 回访中
          tv_dispatch.setText("装机成功");
          tv_chedan.setVisibility(View.VISIBLE);
          tv_chedan.setText("撤单");
          tv_huidan.setVisibility(View.VISIBLE);
          tv_huidan.setText("退单");
        }
        break;
      case "C":
        if (statusValue == 2) {
          //  派单
          tv_dispatch.setText("点击此处指派工单");
        }
        break;
      case "D":
        //  装机人
        if (statusValue == 3) {
          //  派单
          tv_dispatch.setText("装机完成 点击此处进行回单");
        }
        break;
    }
  }

  @Override protected void onLoadData() {

  }

  @OnClick({
      R.id.tv_dispatch,R.id.tv_chedan,R.id.tv_huidan,
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_dispatch:
        //  提交修改的数据
        switch (SharedPreferenceHelper.getUserRole()) {
          //  判断用户的角色
          //case "A":
          //  break;
          case "B":// 区县派单员
            if (statusValue == 1) {
              //  新建工单
              //点击此处指派工单;
              Bundle bundle = new Bundle();
              bundle.putInt(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }else if (statusValue == 4){
                //  回访状态下
              paiPresenter.isCancelOrder(orderDetialBean.getId(),1);
              //  成功
            }
            break;
          case "C":
            if (statusValue == 2) {
              //  接口人派单
              Bundle bundle = new Bundle();
              bundle.putInt(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }
            break;
          case "D":
            //  装机人
            if (statusValue == 3) {
              //  装机完成
              paiPresenter.affirmOrder(orderDetialBean.getId());
            }
            break;
        }
        break;
      case R.id.tv_chedan:
        if (statusValue == 4) {
          paiPresenter.isCancelOrder(orderDetialBean.getId(),2);
        }
        break;
      case R.id.tv_huidan:
        if (statusValue == 4) {
          // 回访中
          paiPresenter.isCancelOrder(orderDetialBean.getId(),3);
          //tv_dispatch.setText("装机成功");
          //tv_chedan.setVisibility(View.VISIBLE);
          //tv_chedan.setText("撤单");
          //tv_huidan.setVisibility(View.VISIBLE);
          //tv_huidan.setText("回单");
        }
    }
  }

  /**
   * 入口
   */
  public static void startAction(Activity activity) {
    Intent intent = new Intent(activity, OrderDetialActivity.class);
    activity.startActivity(intent);
    activity.overridePendingTransition(com.jaydenxiao.common.R.anim.fade_in,
        com.jaydenxiao.common.R.anim.fade_out);
  }

  @Override public void onGetPaiWorkerSuccess(UserInfoBeans bean) {

  }

  @Override public void onGetPaiWorkerSuccessMore(UserInfoBeans bean) {

  }

  @Override public void onDispatchSuccess(MainBean bean) {

  }

  /**
   * 装机人安装完成确认
   */
  @Override public void onaffirmOrderSuccess(MainBean bean) {
    finish();
  }

  @Override public void onisCancelOrderSuccess(MainBean bean) {
    finish();
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }
}