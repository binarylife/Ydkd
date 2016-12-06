package com.bei.yd.ui.main.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.SharedPreferenceUtil;
import com.bei.yd.utils.ToastUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.util.ArrayList;

/**
 * 新建工单
 * Created by fengbei on 2016/3/10.
 */
public class AddWorkOrderActivity extends BackBaseActivity
    implements IMainView, View.OnClickListener {
  @Bind(R.id.coordinator_layout) RelativeLayout mRelativeLayout;
  //@Bind(R.id.rl_brithday) RelativeLayout rlBrithday;
  // 用户头像
  @Bind(R.id.tv_orderid) MaterialEditText mAccount;//  单号
  @Bind(R.id.tv_area) MaterialSpinner tvarea;
  @Bind(R.id.tv_address) MaterialEditText tvAddress;
  @Bind(R.id.tv_phone) EditText tvPhone;
  @Bind(R.id.tv_topTitle) TextView tvTitle;

  // 接收上传完成的头像的URl
  //  文件选择
  private final static int FILECHOOSER_RESULTCODE = 4;
  private ValueCallback<Uri> mUploadMessage;
  //  网络交互的逻辑层

  private MainPresenterImpl mainPresenter;
  private ArrayList<String> selectArea= new ArrayList<>();//  选中的id
  private String[] selectType= {"普通工单","维修工单"};//  选中的id
  private ArrayList<AreaBean> beanData;
  private String tareaName;
  private String typeName;
  private int selectAreaId;
  private boolean misNewOreder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_info);
    Bundle bundle = getIntent().getExtras();
    misNewOreder = bundle.getBoolean(Constant.isNewOreder);
    mainPresenter = new MainPresenterImpl(this, this);
    onLoadData();
  }

  @Override public void onResume() {
    super.onResume();
  }

  /**
   * 初始化控y件
   */
  private void initView() {
    tvTitle.setText(misNewOreder?"新建普通工单":"新建故障工单");
    selectAreaId=beanData.get(0).getId();
    tvarea.setItems(selectArea);
    tvarea.setSelectedIndex(0);
    tvarea.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        tareaName = selectArea.get(position);
        selectAreaId=beanData.get(position).getId();
      }
    });
    //mTypey.setItems(selectType);
    //mTypey.setSelectedIndex(0);
    typeName = selectType[0];
    //mTypey.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
    //  @Override
    //  public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
    //    typeName = selectType[position];
    //  }
    //});
  }

  @Override protected void onLoadData() {
    mainPresenter.getArea();
  }

  @OnClick({
      R.id.tv_save,R.id.title_back
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.title_back:
        //  提交修改的数据
        onBackPressed();
        //  请求服务器更新
        break;
      case R.id.tv_save://  保存修改
        if (TextUtils.isEmpty(mAccount.getText().toString())){
          ToastUtil.showNormalShortToast("请输入客户单号");
          return;
        }
        if (TextUtils.isEmpty(tvAddress.getText().toString())){
          ToastUtil.showNormalShortToast("请输入详细地址");
          return;
        }
        if (TextUtils.isEmpty(tvPhone.getText().toString())){
          ToastUtil.showNormalShortToast("请输入电话");
          return;
        }
        if (misNewOreder) {
          mainPresenter.addWorkOrder(selectAreaId + "", mAccount.getText().toString(),
              tvAddress.getText().toString(), tvPhone.getText().toString());
        }else {
          mainPresenter.addFixWorkOrder(selectAreaId + "", mAccount.getText().toString(),
              tvAddress.getText().toString(), tvPhone.getText().toString());
        }
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
    if (bean.isSuccessful()) {
      ToastUtil.showNormalShortToast("新建工单成功!");
      finish();
    }
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
      for (int i = 0; i <beanData.size() ; i++) {
        selectArea.add(beanData.get(i).getAreaName());
        selectAreaId=beanData.get(i).getId();
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
}