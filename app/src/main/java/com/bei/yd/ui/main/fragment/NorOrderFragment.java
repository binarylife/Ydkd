package com.bei.yd.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.AddWorkOrderActivity;
import com.bei.yd.ui.main.adapter.MainAdapter;
import com.bei.yd.ui.main.bean.AreaBean;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;

/**
 * Created by wangchunlei on 3/28/16.
 */
public class NorOrderFragment extends BaseLoadFragment implements View.OnClickListener, IMainView {
  //  设置按钮

  // 用户足迹
  @Bind(R.id.nor_order) XRecyclerView rvList;
  private MainPresenterImpl mainPresenter;
  private MainAdapter adapter;
  private int pn;
  private ArrayList<MainItemNewOrderBean> mainBeen = new ArrayList<MainItemNewOrderBean>();

  /**
   * 个人中心业务逻辑操作类
   */
  protected void onLoadData() {
    //mainPresenter.getAllNewWorkOrderList(1001,1001,1);
    //for (int i = 0; i < 1; i++) {
    //  mainBeen.add(new MainItemNewOrderBean("我是测试数据******************",i));
    //}
    //adapter.updateItems(mainBeen);
    mainPresenter= new MainPresenterImpl(getActivity(),this);
    mainPresenter.getAllNewWorkOrderList("B",1002,1);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public static NorOrderFragment newInstance() {
    return new NorOrderFragment();
  }

  //@Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
  //    @Nullable Bundle savedInstanceState) {
  //
  //  View view = inflater.inflate(R.layout.fragment_nor_order, container, false);
  //
  //  //initRecyclerView();
  //  //onLoadData();
  //  return view;
  //}

  @Override public int getContentResouceId() {
    return R.layout.fragment_nor_order;
  }

  @Override public void dealLogicBeforeInitView() {

  }

  @Override public void dealLogicAfterInitView(View view) {
    initRecyclerView();
    onLoadData();
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    if (!hidden) {
    }
  }

  @OnClick({
      //R.id.bt_test
  }) @Override public void onClick(View v) {
    switch (v.getId()) {
      //case R.id.bt_test:
      //  //mainPresenter.addWorkOrder("北京", 10000, "山西", 1245666);
      //  //ToastUtil.showNormalShortToast("测试");
      //  InvokeStartActivityUtils.startActivity(getActivity(), AddWorkOrderActivity.class,null,false);
      //  break;
    }
  }

  @Override public void onAddGD(MainBean bean) {

  }

  @Override public void onGetNewGDList(MainItemNewOrderBean bean) {
    adapter.updateItems(bean.getData());
  }

  @Override public void onLoginSuccess(UserInfoBean bean) {

  }

  @Override public void onGetAreaSuccess(AreaBean bean) {

  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void showLoadFailMsg(String msg) {

  }

  private void initRecyclerView() {
    //初始化达人文章地业务逻辑操作类
    if (null != rvList) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
      rvList.setLayoutManager(linearLayoutManager);
      rvList.setHasFixedSize(true);
      rvList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
      rvList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
      rvList.setArrowImageView(R.drawable.iconfont_downgrey);
      rvList.setAdapter(adapter == null ? adapter = new MainAdapter(getActivity()) : adapter);
      rvList.setPullRefreshEnabled(true);
      rvList.setLoadingMoreEnabled(true);
      adapter.setOnItemClickListener(new MainAdapter.OnItemListener() {
        @Override public void onItemClick(View view, int position) {
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
}
