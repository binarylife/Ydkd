package com.bei.yd.ui.main.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.activity.BackBaseActivity;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.ToastUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * 新建工单
 * Created by fengbei on 2016/3/10.
 */
public class AddWorkOrderActivity extends BackBaseActivity
    implements IMainView, View.OnClickListener {
  @Bind(R.id.coordinator_layout) RelativeLayout mRelativeLayout;
  @Bind(R.id.rl_brithday) RelativeLayout rlBrithday;
  // 用户头像
  @Bind(R.id.et_nickname) EditText mNickName;
  @Bind(R.id.tv_area) MaterialSpinner tvarea;
  @Bind(R.id.tv_brith) EditText tvAddress;
  @Bind(R.id.et_phone) EditText tvPhone;
  @Bind(R.id.tv_cityText) EditText cityText;
  // 接收上传完成的头像的URl
  //  文件选择
  private final static int FILECHOOSER_RESULTCODE = 4;
  private ValueCallback<Uri> mUploadMessage;
  //  网络交互的逻辑层

  private MainPresenterImpl mainPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_info);

    //  初始化上传头像的逻辑层
    initView();
    mainPresenter = new MainPresenterImpl(this, this);

    //mineInfoPresenter = new MineInfoPresenterImpl(this, this);
  }

  @Override public void onResume() {
    super.onResume();
    // 从新获取数据
  }

  /**
   * 初始化控件
   */
  private void initView() {
    //        mMyAddressBean = getIntent().getParcelableExtra(Constant.EXTRA_INTENT_ADDRESS_BEAN);
  }

  @Override protected void onLoadData() {

  }

  @OnClick({
      R.id.title_back,  R.id.tv_area, R.id.rl_city, R.id.tv_save,
      R.id.et_nickname, R.id.et_phone
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.title_back:
        //  提交修改的数据
        onBackPressed();
        //  请求服务器更新
        break;
      case R.id.rl_brithday://  弹出日期筛选框
        //pvTime.show();
        break;
      case R.id.rl_changesex://  修改性别
        //select_sex_weelview();
        // selectSex();
        break;
      case R.id.tv_save://  保存修改
        mainPresenter.addWorkOrder(tvarea.getText().toString(), 110, tvAddress.getText().toString(),Integer.parseInt(tvPhone.getText().toString()));
        break;
      case R.id.et_nickname://  点击昵称编辑
        break;
      case R.id.et_phone://  点击昵称编辑
        break;
      case R.id.rl_city://  修改城市

        break;
    }
  }

  /**
   * 提交修改后的数据
   */
  //private void postUserInfoData() {
  //  newNickname = mNickName.getText().toString();
  //
  //  //mineInfoPresenter.loadInfosData(SharedPreferenceHelper.getUserToken(), newNickname,
  //  //    selectCityId + "", newSex, newEmail, newBrithday);
  //  //LogUtils.LOGE(BaiDaiApp.mContext.getToken());
  //}

  @Override public void onAddGD(MainBean bean) {
      if (bean.isSuccessful()){
        ToastUtil.showNormalShortToast("新建工单成功!");
        finish();
      }
  }

  @Override public void onGetNewGDList(MainItemNewOrderBean bean) {

  }

  @Override public void onLoginSuccess(UserInfoBean bean) {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }
}