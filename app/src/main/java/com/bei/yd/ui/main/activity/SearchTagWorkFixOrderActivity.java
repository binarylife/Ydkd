package com.bei.yd.ui.main.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.activity.BackBaseActivity;
import com.bei.yd.ui.main.adapter.FixAdapter;
import com.bei.yd.ui.main.adapter.MainAdapter;
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
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 添加检索条件
 * Created by fengbei on 2016/3/10.
 */
public class SearchTagWorkFixOrderActivity extends BackBaseActivity
    implements IMainView, View.OnClickListener {
  @Bind(R.id.coordinator_layout) RelativeLayout mRelativeLayout;
  @Bind(R.id.sv_scroll) ScrollView mScrollView;
  @Bind(R.id.nor_order) XRecyclerView rvList;
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
  @Bind(R.id.tv_save) TextView tvSave;//  确定

  // 接收上传完成的头像的URl
  //  文件选择
  private final static int FILECHOOSER_RESULTCODE = 4;
  private ValueCallback<Uri> mUploadMessage;
  //  网络交互的逻辑层
  private FixAdapter adapter;
  private ArrayList<MainItemNewOrderBean> newOrderBeen;
  private int mYear = Calendar.getInstance().get(Calendar.YEAR);
  private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
  private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
  private MainPresenterImpl mainPresenter;
  private ArrayList<String> selectArea = new ArrayList<>();//  选中的id
  private String[] selectRole = { "默认", "一级预警", "二级预警", "三级预警" };//  选中的id
  private String[] selectTimeTypes =
      { "默认", "派单时间", "二级派单时间", "二级二次派单时间", "接口人接单时间", "接单时间", "安装时间", "结束时间" };//  选中的id
  private String[] selectYuJingValue = { "默认", "1", "2", "3" };//  选中的id
  private String[] selectIsVoer = { "默认", "是", "否" };//  选中的id
  private String[] selectYujing = { "默认", "二级派单预警", "二级二次派单预警", "接口人派单时长预警", "处理预警", "回访预警" };
  //  选中的id二级派单预警、二级二次派单预警、接口人派单时长预警、处理预警、回访预警、
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
  private int pn = 1;
  private int mYuJingPosition;//   记录筛选预警类型的位置
  private int mTimeTypePosition;//   记录筛选时间类型的位置
  private String dispatchwarning1;
  private String dispatchtime21;
  private String dispatchtime22;
  private String interfacetaketime;
  private String dispatchwarning2;

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
    initRecyclerView();
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
        } else {
          warningValue = null;
        }
        if (mYuJingPosition == 1) {
          //派单预警
          dispatchwarning1 = warningValue;
        }
        if (mYuJingPosition == 2) {
          dispatchwarning2 = warningValue;
        }
        if (mYuJingPosition == 3) {
          dispatchwarning = warningValue;
        }
        if (mYuJingPosition == 4) {
          installwarning = warningValue;
        }
        if (mYuJingPosition == 5) {
          visitwarning = warningValue;
        }
        //  选中的id二级派单预警、二级二次派单预警、接口人派单时长预警、处理预警、回访预警、
      }
    });
    // 预警类型
    tvYujing.setItems(selectYujing);
    tvYujing.setSelectedIndex(0);
    tvYujing.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

        mYuJingPosition = position;
        //switch (position) {
        //  default:
        dispatchwarning = null;
        installwarning = null;
        visitwarning = null;
        dispatchwarning1 = null;
        dispatchwarning2 = null;
        //case 0:
        //  break;
        //case 1:
        //  dispatchwarning = warningValue;
        //  break;
        //case 2:
        //  installwarning = warningValue;
        //  break;
        //case 3:
        //  visitwarning = warningValue;
        //  break;
        //}
      }
    });
    //  时间类型
    tvtimeType.setItems(selectTimeTypes);
    tvtimeType.setSelectedIndex(0);
    tvtimeType.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        mTimeTypePosition = position;
        //switch (position) {
        //  default:
        //    //   默认清空所有操作
        taketime = null;
        dispatchtime = null;
        installtime = null;
        dispatchtime21 = null;
        dispatchtime22 = null;
        //  case 0:
        //    break;
        //  case 1:
        //    taketime = timeValue;
        //    break;
        //  case 2:
        //    dispatchtime = timeValue;
        //    break;
        //  case 3:
        //    installtime = timeValue;
        //    break;
        //  case 4:
        //    overtime = timeValue;
        //    break;
        //}
      }
    });
    //  是否取消
    tvIscancle.setItems(selectIsVoer);
    tvIscancle.setSelectedIndex(0);
    tvIscancle.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
      @Override
      public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
        switch (position) {
          default:
            iscancel = null;
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
          default:
            isOver = null;
          case 0:
            break;
          case 1:
            isOver = "1";
            break;
          case 2:
            isOver = "0";
            break;
        }
      }
    });

    tvSelectTime.setText("请选择日期");
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
        //   整理数据 "默认", "一级派单时间","二级派单时间","二级二次派单时间","接口人接单时间","接单时间", "派单时间", "安装时间", "结束时间"
        if (mTimeTypePosition == 1) {
          //  一级派单时间
          dispatchtime = timeValue;
        }
        if (mTimeTypePosition == 2) {
          //  二级派单时间
          dispatchtime21 = timeValue;
        }
        if (mTimeTypePosition == 3) {
          //  二级二次派单时间
          dispatchtime22 = timeValue;
        }
        if (mTimeTypePosition == 4) {
          //  接口人接单时间
          interfacetaketime = timeValue;
        }
        if (mTimeTypePosition == 5) {
          //  接单时间
          taketime = timeValue;
        }
        if (mTimeTypePosition == 6) {
          //  安装时间
          installtime = timeValue;
        }
        if (mTimeTypePosition == 7) {
          //  结束时间
          overtime = timeValue;
        }
        searchForList();

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
            tvSelectTime.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            timeValue = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
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

  @Override public void onGetNewGDListMore(MainItemNewOrderBean bean) {
    if (bean.isSuccessful()) {
      //            hideEmptyView();
      //            rvList.setVisibility(View.VISIBLE);
      if (pn > 1 && bean.getData() == null || bean.getData().size() == 0) {
        pn--;
        rvList.noMoreLoading();
        ToastUtil.showNormalShortToast("没有更多数据了！");
      } else {
        newOrderBeen.addAll(bean.getData());
      }
      adapter.addItems(bean.getData());
    } else {
      //            ToastUtil.showNormalShortToast(bean.getMsg());
      showLoadFailMsg(bean.getMessage());
    }

    rvList.refreshComplete();
    rvList.loadMoreComplete();
  }

  @Override public void onGetNewGDList(MainItemNewOrderBean bean) {
    if (bean.getSize() > 0) {
      mScrollView.setVisibility(View.GONE);
      tvSave.setVisibility(View.GONE);
      rvList.setVisibility(View.VISIBLE);
      tvTitle.setText("数量："+bean.getSize()+"条");
      newOrderBeen = bean.getData();
      adapter.updateItems(newOrderBeen);
      if (rvList != null) {
        rvList.refreshComplete();
        rvList.loadMoreComplete();
      }
    } else {
      ToastUtil.showNormalShortToast("查询不到相关工单，请重新查询！");
      return;
    }
    //if (pn == 1) {
    //  rvList.reset();
    //}
  }

  private void initRecyclerView() {
    //初始化达人文章地业务逻辑操作类
    if (null != rvList) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      rvList.setLayoutManager(linearLayoutManager);
      rvList.setHasFixedSize(true);
      rvList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
      rvList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
      rvList.setArrowImageView(R.drawable.iconfont_downgrey);
      rvList.setAdapter(adapter == null ? adapter = new FixAdapter(this) : adapter);
      rvList.setPullRefreshEnabled(true);
      rvList.setLoadingMoreEnabled(true);
      adapter.setOnItemClickListener(new FixAdapter.OnItemListener() {
        @Override public void onItemClick(View view, int position) {
          MainItemNewOrderBean mainItemNewOrderBean = newOrderBeen.get(position);
          //Bundle bundle = new Bundle();
          //bundle.putInt(Constant.ORDER_ID, mainItemNewOrderBean.getId());
          //bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
          //InvokeStartActivityUtils.startActivity(getActivity(), PaiWorkerListActivity.class,
          //    bundle, false);
          Bundle bundle = new Bundle();
          bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
          bundle.putBoolean(Constant.isNewOreder, false);
          bundle.putBoolean(Constant.ISSEARCH, true);
          //bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
          InvokeStartActivityUtils.startActivity(SearchTagWorkFixOrderActivity.this,
              OrderDetialActivity.class, bundle, false);
        }
      });
      rvList.setLoadingListener(new XRecyclerView.LoadingListener() {
        @Override public void onRefresh() {
          //上拉刷新
          pn = 1;
          searchForList();
        }

        @Override public void onLoadMore() {
          pn++;
          searchForList();
        }
      });
    }
  }

  /**
   * 查询相关数据
   */
  public void searchForList() {
    mainPresenter.statisticsSingleFault(SharedPreferenceHelper.getUserRole(),
        SharedPreferenceHelper.getUserAccount(), pn, selectAreaId + "",
        mAccount.getText().toString(), tvPhone.getText().toString(), dispatchtime, taketime,
        installtime, overtime, dispatchwarning, installwarning, visitwarning,
        tvIsrepeat.getText().toString(), iscancel, isOver, dispatchwarning1, dispatchwarning1,
        dispatchtime21, dispatchtime22);
  }
}