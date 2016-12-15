package com.bei.yd.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
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
import com.jaredrummler.materialspinner.MaterialSpinner;
import java.util.ArrayList;

/**
 * 维修工单（详情页面）
 * Created by fengbei on 2016/3/10.
 */
public class FixOrderDetialActivity extends BackBaseActivity
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
  @Bind(R.id.tv_area) MaterialSpinner tvarea;
  @Bind(R.id.ll_area) LinearLayout llArea;
  @Bind(R.id.ll_area_bottom) LinearLayout llAreaBottom;
  @Bind(R.id.tv_save_area) TextView tvSaveArea;
  @Bind(R.id.ll_bottom) LinearLayout ll_bottom;
  @Bind(R.id.dispatchPeople21) TextView dispatchPeople21;
  @Bind(R.id.dispatchPeople22) TextView dispatchPeople22;
  @Bind(R.id.dispatchTime21) TextView dispatchTime21;
  @Bind(R.id.dispatchTime22) TextView dispatchTime22;
  @Bind(R.id.dispatchWarning1) TextView dispatchWarning1;
  @Bind(R.id.dispatchWarning2) TextView dispatchWarning2;
  @Bind(R.id.dispatchDuration21) TextView dispatchDuration21;
  @Bind(R.id.dispatchDuration22) TextView dispatchDuration22;
  //@Bind(R.id.bt_login) TextView mlogin;
  //  网络交互的逻辑层
  private MainPresenterImpl mineInfoPresenter;
  /**
   * 地址p
   */
  private MainItemNewOrderBean orderDetialBean;
  private int statusValue;
  private PaiPresenterImpl paiPresenter;
  private boolean misNewOreder;
  private ArrayList<String> selectArea = new ArrayList<>();//  选中的id
  private int selectAreaId;
  private ArrayList<AreaBean> beanData;
  private String tareaName;
  private boolean misSearch;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fix_order_detial);
    Bundle bundle = getIntent().getExtras();
    orderDetialBean = bundle.getParcelable(Constant.ORDER_DETAIL);
    misNewOreder = bundle.getBoolean(Constant.isNewOreder);
    //orderCreater = bundle.getString(Constant.ORDER_CREATER);
    paiPresenter = new PaiPresenterImpl(this, this);
    onLoadData();
    //  初始化上传头像的逻辑层
    //initView();
  }

  @Override public void onResume() {
    super.onResume();
    // 从新获取数据
  }

  /**
   * 初始化控件
   */
  private void initView() {
    selectAreaId = beanData.get(0).getId();
    tvarea.setItems(selectArea);
    tvarea.setSelectedIndex(0);
    tvarea.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        tareaName = selectArea.get(position);
        selectAreaId = beanData.get(position).getId();
      }
    });
    //mTypey.setItems(selectType);
    //mTypey.setSelectedIndex(0);
    if (SharedPreferenceHelper.getUserRole().equals("B")) {
      llArea.setVisibility(View.VISIBLE);
      tvSaveArea.setVisibility(View.VISIBLE);
    } else {
      llArea.setVisibility(View.GONE);
    }
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
    status.setText(MyUtils.getTextByType(orderDetialBean.getStatus()));
    statusValue = orderDetialBean.getStatus();
    if (!misSearch) {
      showBottomButton();
    } else {
      ll_bottom.setVisibility(View.GONE);
    }
    dispatchPeople21.setText(orderDetialBean.getDispatchPeople21());;
    dispatchPeople22.setText(orderDetialBean.getDispatchPeople22());;
    dispatchTime21.setText(orderDetialBean.getDispatchTime21());;
    dispatchTime22.setText(orderDetialBean.getDispatchTime22());;
    dispatchWarning1.setText(orderDetialBean.getDispatchWarning1()+"");;
    dispatchWarning2.setText(orderDetialBean.getDispatchWarning2()+"");;
    dispatchDuration21.setText(orderDetialBean.getDispatchDuration21()+"");;
    dispatchDuration22.setText(orderDetialBean.getDispatchDuration22()+"");;
  }

  /**
   * 展示buttom上的文字
   */
  private void showBottomButton() {
    switch (SharedPreferenceHelper.getUserRole()) {
      //  判断用户的角色
      case "A":
        if (statusValue == 7) {
          //  新建工单
          tv_dispatch.setText("点击此处指派工单");
        }
        //tv_dispatch.setText("点击此处指派工单");
        break;
      case "B":// 区县派单员/二级派单
        if (statusValue == 7) {
          //  新建工单
          tv_dispatch.setText("点击此处指派工单");
        } else if (statusValue == 5) {
          // 回访中
          tv_dispatch.setText("装机成功");
          //tv_chedan.setVisibility(View.VISIBLE);
          //tv_chedan.setText("撤单");
          tv_huidan.setVisibility(View.VISIBLE);
          tv_huidan.setText("退单");
        } else if (statusValue == 1) {
          //  新建工单
          tv_dispatch.setText("点击此处指派工单");
        } else if (statusValue == 3) {
          //  二级二次派单
          tv_dispatch.setText("点击此处指派工单");
        }
        break;
      case "C"://接口人
        if (statusValue == 2) {
          //  派单
          tv_dispatch.setText("点击此处指派工单");
        }
        break;
      case "D":
        //  装机人
        if (statusValue == 4) {
          //  派单
          tv_dispatch.setText("装机完成 点击此处进行回单");
        }
        break;
      case "CD":
        //  装机人  接口人
        if (statusValue == 2) {
          //  派单
          tv_dispatch.setText("点击此处指派工单");
        }
        if (statusValue == 4) {
          //  派单
          tv_dispatch.setText("装机完成 点击此处进行回单");
        }
        break;
    }
  }

  protected void onLoadData() {
    //  获取区县接口
    new MainPresenterImpl(this, new IMainView() {
      @Override public void onAddGD(MainBean bean) {

      }

      @Override public void onGetNewGDListMore(MainItemNewOrderBean bean) {

      }

      @Override public void onGetNewGDList(MainItemNewOrderBean bean) {

      }

      @Override public void onLoginSuccess(UserInfoBean bean) {

      }

      @Override public void onGetAreaSuccess(AreaBean bean) {
        if (bean.isSuccessful()) {
          beanData = bean.getData();//  区域集合
          for (int i = 0; i < beanData.size(); i++) {
            selectArea.add(beanData.get(i).getAreaName());
            selectAreaId = beanData.get(i).getId();
          }
          initView();
        }
      }

      @Override public void showProgress() {

      }

      @Override public void hideProgress() {

      }

      @Override public void showLoadFailMsg(String msg) {

      }
    }).getArea();
  }

  @OnClick({
      R.id.tv_dispatch, R.id.tv_chedan, R.id.tv_huidan, R.id.tv_save_area
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_dispatch:
        //  提交修改的数据
        switch (SharedPreferenceHelper.getUserRole()) {
          //  判断用户的角色
          case "A":
            if (statusValue == 7) {
              //  新建工单
              //点击此处指派工单;
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }
            break;
          case "B":// 区县派单员
            if (statusValue == 7) {
              //  新建工单
              //点击此处指派工单;
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            } else if (statusValue == 5) {
              //  回访状态下
              paiPresenter.isCancelSingleFault(orderDetialBean.getId(), 1);
              //  成功
            } else if (statusValue == 3) {
              //  二级二次派单
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            } else if (statusValue == 1) {
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }
            break;
          case "C":
            if (statusValue == 2) {
              //  接口人二级派单
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }
            break;
          case "D":
            //  装机人
            if (statusValue == 4) {
              //  装机完成
              paiPresenter.affirmSingleFault(orderDetialBean.getId());
            }
            break;
          case "CD":
            //  装机人  接口人
            if (statusValue == 2) {
              //  接口人二级派单
              Bundle bundle = new Bundle();
              bundle.putString(Constant.ORDER_ID, orderDetialBean.getId());
              bundle.putBoolean(Constant.isNewOreder, false);
              bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
              InvokeStartActivityUtils.startActivity(this, PaiWorkerListActivity.class, bundle,
                  false);
            }
            //  装机人
            if (statusValue == 4) {
              //  装机完成
              paiPresenter.affirmSingleFault(orderDetialBean.getId());
            }
            break;
        }
        break;
      case R.id.tv_chedan:
        if (statusValue == 4) {
          paiPresenter.isCancelSingleFault(orderDetialBean.getId(), 2);
        }
        break;
      case R.id.tv_huidan:
        if (statusValue == 4) {
          // 回访中
          paiPresenter.isCancelSingleFault(orderDetialBean.getId(), 3);
          //tv_dispatch.setText("装机成功");
          //tv_chedan.setVisibility(View.VISIBLE);
          //tv_chedan.setText("撤单");
          //tv_huidan.setVisibility(View.VISIBLE);
          //tv_huidan.setText("回单");
        }
        break;
      case R.id.tv_save_area:
        paiPresenter.updateSingleFault(selectAreaId + "", orderDetialBean.getId() + "");
        break;
    }
  }

  /**
   * 入口
   */
  public static void startAction(Activity activity) {
    Intent intent = new Intent(activity, FixOrderDetialActivity.class);
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

  @Override public void updateSingleFault(MainBean bean) {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }
}