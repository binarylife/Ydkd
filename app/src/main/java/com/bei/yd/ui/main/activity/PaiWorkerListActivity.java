package com.bei.yd.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.activity.BackBaseActivity;
import com.bei.yd.ui.main.adapter.MainAdapter;
import com.bei.yd.ui.main.adapter.PaiWorkerListAdapter;
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
import com.bei.yd.utils.SharedPreferenceHelper;
import com.bei.yd.utils.ToastUtil;
import com.bei.yd.widget.DialogBuilder;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;

/**
 * 获取可派工人的列表
 * Created by fengbei on 2016/3/10.
 */
public class PaiWorkerListActivity extends BackBaseActivity
    implements IpaiView, View.OnClickListener {
  // 用户账号
  @Bind(R.id.rv_pai_worker_list) XRecyclerView rvList;
  private PaiWorkerListAdapter adapter;
  private int pn;
  private PaiPresenterImpl paiPresenter;
  private int orderId;
  private String orderCreater;
  private ArrayList<UserInfoBeans> userInfoBeanses;
  private String accountB;//被派单人
  //  网络交互的逻辑层

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pai_workerlist);
    Bundle bundle = getIntent().getExtras();
    orderId = bundle.getInt(Constant.ORDER_ID);
    orderCreater = bundle.getString(Constant.ORDER_CREATER);
    //  初始化上传头像的逻辑层
    paiPresenter = new PaiPresenterImpl(this, this);
    initView();
    onLoadData();
  }

  @Override public void onResume() {
    super.onResume();
    // 从新获取数据
  }

  /**
   * 初始化控件
   */
  private void initView() {
    //初始化达人文章地业务逻辑操作类
    if (null != rvList) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      rvList.setLayoutManager(linearLayoutManager);
      rvList.setHasFixedSize(true);
      rvList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
      rvList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
      rvList.setArrowImageView(R.drawable.iconfont_downgrey);
      rvList.setAdapter(adapter == null ? adapter = new PaiWorkerListAdapter(this) : adapter);
      rvList.setPullRefreshEnabled(true);
      rvList.setLoadingMoreEnabled(true);
      adapter.setOnItemClickListener(new PaiWorkerListAdapter.OnItemListener() {
        @Override public void onItemClick(View view, int position) {
          accountB = userInfoBeanses.get(position).getAccount();
          /**
           * 派单
           */
          showMutiDialog("是否指派给" + userInfoBeanses.get(position).getRole(),
              new DialogBuilder.ClickCallbak() {
                @Override public void onConfirm() {
                  paiPresenter.dispatchOrder(orderId, orderCreater, accountB);
                }

                @Override public void onCancle() {

                }
              });
        }
      });
      rvList.setLoadingListener(new XRecyclerView.LoadingListener() {
        @Override public void onRefresh() {
          //上拉刷新
          pn = 1;
          onLoadData();
        }

        @Override public void onLoadMore() {
          pn++;
          onLoadData();
        }
      });
    }
  }

  @Override protected void onLoadData() {
    paiPresenter.getArea(SharedPreferenceHelper.getUserRole(),SharedPreferenceHelper.getUserAreaid());
  }

  @OnClick({
      //R.id.bt_login
  }) public void onClick(View view) {
    switch (view.getId()) {
      //case R.id.bt_login:
      //  //  提交修改的数据
      //  //newPassWord = mPassWord.getText().toString();
      //  newNickname = mNickName.getText().toString();
      //  mainPresenter.login(newNickname, newPassWord);
      //  break;
    }
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }

  /**
   * 成功的回调
   */
  @Override public void onGetPaiWorkerSuccess(UserInfoBeans bean) {
    if (bean.isSuccessful()) {
      userInfoBeanses = bean.getData();
      adapter.updateItems(userInfoBeanses);
    }
    if (rvList != null) {
      rvList.refreshComplete();
      rvList.loadMoreComplete();
    }
  }

  @Override public void onGetPaiWorkerSuccessMore(UserInfoBeans bean) {
    if (bean.isSuccessful()) {
      //            hideEmptyView();
      //            rvList.setVisibility(View.VISIBLE);
      if (pn > 1 && bean.getData() == null || bean.getData().size() == 0) {
        pn--;
        rvList.noMoreLoading();
        ToastUtil.showNormalShortToast("没有更多数据了！");
      } else {
        userInfoBeanses.addAll(bean.getData());
      }
      adapter.addItems(bean.getData());
    } else {
      //            ToastUtil.showNormalShortToast(bean.getMsg());
      showLoadFailMsg(bean.getMessage());
    }

    rvList.refreshComplete();
    rvList.loadMoreComplete();
  }
  /**
   * 派单成功的回调
   */
  @Override public void onDispatchSuccess(MainBean bean) {
    finish();
  }

  @Override public void onaffirmOrderSuccess(MainBean bean) {

  }

  @Override public void onisCancelOrderSuccess(MainBean bean) {

  }
}