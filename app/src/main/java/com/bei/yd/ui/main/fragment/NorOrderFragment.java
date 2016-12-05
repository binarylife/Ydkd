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
import com.bei.yd.ui.main.activity.OrderDetialActivity;
import com.bei.yd.ui.main.activity.PaiWorkerListActivity;
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
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;

/**
 * Created by fb on 11/28/16.
 */
public class NorOrderFragment extends BaseLoadFragment implements View.OnClickListener, IMainView {
  //  设置按钮

  // 用户足迹
  @Bind(R.id.nor_order) XRecyclerView rvList;
  private MainPresenterImpl mainPresenter;
  private MainAdapter adapter;
  private int pn = 1;
  private ArrayList<MainItemNewOrderBean> mainBeen = new ArrayList<MainItemNewOrderBean>();
  private ArrayList<MainItemNewOrderBean> newOrderBeen;

  /**
   * 个人中心业务逻辑操作类
   */
  protected void onLoadData() {
    mainPresenter = new MainPresenterImpl(getActivity(), this);
    mainPresenter.getAllNewWorkOrderList(SharedPreferenceHelper.getUserRole(),
        SharedPreferenceHelper.getUserAccount(), pn);
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
    newOrderBeen = bean.getData();
    adapter.updateItems(newOrderBeen);
    if (rvList != null) {
      rvList.refreshComplete();
      rvList.loadMoreComplete();
    }
    //if (pn == 1) {
    //  rvList.reset();
    //}
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
          MainItemNewOrderBean mainItemNewOrderBean = newOrderBeen.get(position);
          //Bundle bundle = new Bundle();
          //bundle.putInt(Constant.ORDER_ID, mainItemNewOrderBean.getId());
          //bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
          //InvokeStartActivityUtils.startActivity(getActivity(), PaiWorkerListActivity.class,
          //    bundle, false);
          Bundle bundle = new Bundle();
          bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
          bundle.putBoolean(Constant.isNewOreder, true);
          //bundle.putString(Constant.ORDER_CREATER, SharedPreferenceHelper.getUserAccount());
          InvokeStartActivityUtils.startActivity(getActivity(), OrderDetialActivity.class, bundle,
              false);
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
