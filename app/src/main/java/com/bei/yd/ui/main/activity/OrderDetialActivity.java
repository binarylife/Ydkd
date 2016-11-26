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
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.ToastUtil;

/**
 * 普通工单（详情页面）
 * Created by fengbei on 2016/3/10.
 */
public class OrderDetialActivity extends BackBaseActivity implements View.OnClickListener {
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

  //@Bind(R.id.bt_login) TextView mlogin;
  //  网络交互的逻辑层
  private MainPresenterImpl mineInfoPresenter;
  /**
   * 地址p
   */
  private MainPresenterImpl mainPresenter;
  private String newNickname;
  private String newPassWord;
  private MainItemNewOrderBean orderDetialBean;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_detial);
    Bundle bundle = getIntent().getExtras();
    orderDetialBean = bundle.getParcelable(Constant.ORDER_DETAIL);
    //orderCreater = bundle.getString(Constant.ORDER_CREATER);
    //  初始化上传头像的逻辑层
    initView();
    //mainPresenter = new MainPresenterImpl(this, this);
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
    dispatchduration.setText(orderDetialBean.getDispatchDuration()+"");
    installduration.setText(orderDetialBean.getInstallDuration()+"");
    visitduration.setText(orderDetialBean.getVisitDuration()+"");
    dispatchwaring.setText(orderDetialBean.getDispatchWarning()+"");
    installwarning.setText(orderDetialBean.getInstallWarning()+"");
    visitwarning.setText(orderDetialBean.getVisitWarning()+"");
    repeatnum.setText(orderDetialBean.getRepeatNum()+"");
    iscancle.setText(orderDetialBean.getIsCancel()+"");
    isend.setText(orderDetialBean.getIsEnd()+"");
    status.setText(orderDetialBean.getStatus()+"");
  }

  @Override protected void onLoadData() {

  }

  @OnClick({
      R.id.tv_dispatch
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_dispatch:
      //  提交修改的数据
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.ORDER_ID, orderDetialBean.getId());
        bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
        InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class,
            bundle, false);
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
}