package com.bei.yd.ui.main.activity;

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
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.ToastUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.util.ArrayList;
import java.util.Calendar;

import static com.bei.yd.R.id.dispatchTime;
import static com.bei.yd.R.id.installwarning;
import static com.bei.yd.R.id.time;
import static com.bei.yd.R.id.tv_isover;

/**
 * 添加检索条件
 * Created by fengbei on 2016/3/10.
 */
public class SearchTagWorkOrderActivity extends BackBaseActivity
    implements IMainView, View.OnClickListener {
  @Bind(R.id.coordinator_layout) RelativeLayout mRelativeLayout;
  //@Bind(R.id.rl_brithday) RelativeLayout rlBrithday;
  // 用户头像
  @Bind(R.id.tv_orderid) MaterialEditText mAccount;//  单号
  @Bind(R.id.tv_area) MaterialSpinner tvarea;
  @Bind(R.id.tv_timetype) MaterialSpinner tvtimeType;//时间类型
  @Bind(R.id.tv_role) MaterialSpinner tvRole;//  预警级别
  @Bind(R.id.tv_yujing) MaterialSpinner tvYujing;//  预警类型
  @Bind(R.id.tv_repeatNum) MaterialEditText tvIsrepeat;//  重复派单
  @Bind(R.id.tv_isover) MaterialSpinner tvIsover;//  是否结束
  @Bind(R.id.tv_iscancle) MaterialSpinner tvIscancle;//  是否撤单
  @Bind(R.id.tv_phone) EditText tvPhone;
  @Bind(R.id.tv_topTitle) TextView tvTitle;
  @Bind(R.id.tv_selecttime) TextView tvSelectTime;//  选择时间

  // 接收上传完成的头像的URl
  //  文件选择
  private final static int FILECHOOSER_RESULTCODE = 4;
  private ValueCallback<Uri> mUploadMessage;
  //  网络交互的逻辑层
  private int mYear = Calendar.getInstance().get(Calendar.YEAR);
  private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
  private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
  private MainPresenterImpl mainPresenter;
  private ArrayList<String> selectArea = new ArrayList<>();//  选中的id
  private String[] selectRole = { "默认", "一级预警", "二级预警", "三级预警" };//  选中的id
  private String[] selectTimeTypes = { "默认", "接单时间", "派单时间", "安装时间", "结束时间" };//  选中的id
  private String[] selectYuJingValue = { "0", "1", "2", "3" };//  选中的id
  private String[] selectIsVoer = { "默认", "是", "否" };//  选中的id
  private String[] selectYujing = { "默认", "派单预警", "处理预警", "回访预警" };
  //  选中的id
  private ArrayList<AreaBean> beanData;
  private String tareaName;
  private String typeName;
  private int selectAreaId;
  private boolean misNewOreder;
  private String typeYujingValue;
  private String dispatchwarning;
  private String installwarning;
  private String visitwarning;
  private String warningValue;
  private String taketime;
  private String installtime;
  private String overtime;
  private String dispatchtime;
  private String timeValue;
  private String iscancel;
  private String isOver;
  private int pn=1;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.search_tag_info);
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
    tvTitle.setText("请填写检索条件");
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
    //  预警筛选级别
    tvRole.setItems(selectYuJingValue);
    tvRole.setSelectedIndex(0);
    tvRole.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        if (position != 0) {
          warningValue = selectYuJingValue[position];
        }
      }
    });
    // 预警类型
    tvYujing.setItems(selectYujing);
    tvYujing.setSelectedIndex(0);
    tvYujing.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        switch (position) {
          case 0:
            break;
          case 1:
            dispatchwarning = warningValue;
            break;
          case 2:
            installwarning = warningValue;
            break;
          case 3:
            visitwarning = warningValue;
            break;
        }
      }
    });
    //  时间类型
    tvtimeType.setItems(selectTimeTypes);
    tvtimeType.setSelectedIndex(0);
    tvtimeType.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        switch (position) {
          case 0:
            break;
          case 1:
            taketime = timeValue;
            break;
          case 2:
            dispatchtime = timeValue;
            break;
          case 3:
            installtime = timeValue;
            break;
          case 4:
            overtime = timeValue;
            break;
        }
      }
    });
    //  是否取消
    tvIscancle.setItems(selectIsVoer);
    tvIscancle.setSelectedIndex(0);
    tvIscancle.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        switch (position) {
          case 0:
            break;
          case 1:
            iscancel = "1";
            break;
          case 2:
            iscancel = "0";
            break;
        }
      }
    });
    //  是否完成
    tvIsover.setItems(selectIsVoer);
    tvIsover.setSelectedIndex(0);
    tvIsover.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        switch (position) {
          case 0:
            break;
          case 1:
            isOver = "1";
            break;
          case 2:
            iscancel = "0";
            break;
        }
      }
    });

    tvSelectTime.setText("默认");
  }

  @Override protected void onLoadData() {
    mainPresenter.getArea();
  }

  @OnClick({
      R.id.tv_save, R.id.title_back, R.id.tv_selecttime
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.title_back:
        //  提交修改的数据
        onBackPressed();
        //  请求服务器更新
        break;
      case R.id.tv_selecttime:
        //  弹出日期筛选
        showPickDialog();
        //  请求服务器更新
        break;
      case R.id.tv_save://  保存修改
        //if (misNewOreder) {
        //  mainPresenter.addWorkOrder(selectAreaId + "", mAccount.getText().toString(),
        //      tvAddress.getText().toString(), Integer.parseInt(tvPhone.getText().toString()));
        //}else {
        //  mainPresenter.addFixWorkOrder(selectAreaId + "", mAccount.getText().toString(),
        //      tvAddress.getText().toString(), Integer.parseInt(tvPhone.getText().toString()));
        //}

        mainPresenter.statisticsWorkOrderList(SharedPreferenceHelper.getUserRole(),
            Integer.parseInt(SharedPreferenceHelper.getUserAccount()), pn,selectAreaId+"", mAccount.getText().toString(),
            tvPhone.getText().toString(),dispatchtime,taketime,installtime,overtime,dispatchwarning,installtime,visitwarning );
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

  public void showPickDialog() {
    Calendar now = Calendar.getInstance();
    now.set(mYear, mMonth, mDay);
    DatePickerDialog dialog =
        DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            Calendar temp = Calendar.getInstance();
            temp.clear();
            temp.set(year, monthOfYear, dayOfMonth);
            tvSelectTime.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
            timeValue = year + "-" + monthOfYear + "-" + dayOfMonth;
            //presenter.loadPosts(temp.getTimeInMillis(), true);
          }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

    dialog.setMaxDate(Calendar.getInstance());
    Calendar minDate = Calendar.getInstance();
    //
    minDate.set(2014, 12, 31);
    dialog.setMinDate(minDate);
    dialog.vibrate(false);

    dialog.show(this.getFragmentManager(), "DatePickerDialog");
  }
}