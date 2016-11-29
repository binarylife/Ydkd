package com.bei.yd.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.ToastUtil;

/**
 * 新建工单
 * Created by fengbei on 2016/3/10.
 */
public class LoginActivity extends BackBaseActivity implements IMainView, View.OnClickListener {
  // 用户账号
  @Bind(R.id.et_phoneNum) EditText mNickName;
  @Bind(R.id.et_password) EditText mPassWord;
  @Bind(R.id.bt_login) TextView mlogin;
  //  网络交互的逻辑层
  private MainPresenterImpl mineInfoPresenter;
  /**
   * 地址p
   */
  private MainPresenterImpl mainPresenter;
  private String newNickname;
  private String newPassWord;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_login);

    //  初始化上传头像的逻辑层
    initView();
    mainPresenter = new MainPresenterImpl(this, this);
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
      R.id.bt_login
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.bt_login:
        //  提交修改的数据
        newPassWord = mPassWord.getText().toString();
        newNickname = mNickName.getText().toString();
        mainPresenter.login(newNickname, newPassWord);
        break;
    }
  }

  @Override public void onAddGD(MainBean bean) {
  }

  @Override public void onGetNewGDListMore(MainItemNewOrderBean bean) {

  }

  @Override public void onGetNewGDList(MainItemNewOrderBean bean) {

  }

  @Override public void onLoginSuccess(UserInfoBean bean) {
    ToastUtil.showNormalShortToast("登录成功!");
    if (bean.isSuccessful()) {
      SharedPreferenceHelper.saveUserInfo(bean.getData());
      //InvokeStartActivityUtils.startActivity(this, MainActivity.class, null, true);
      MainActivity.startAction(LoginActivity.this);
      finish();
    }
  }

  @Override public void onGetAreaSuccess(AreaBean bean) {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }

  /**
   * 入口
   */
  public static void startAction(Activity activity) {
    Intent intent = new Intent(activity, LoginActivity.class);
    activity.startActivity(intent);
    activity.overridePendingTransition(com.jaydenxiao.common.R.anim.fade_in,
        com.jaydenxiao.common.R.anim.fade_out);
  }

}