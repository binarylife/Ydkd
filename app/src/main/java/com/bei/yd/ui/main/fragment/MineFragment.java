package com.bei.yd.ui.main.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.AddWorkOrderActivity;
import com.bei.yd.ui.main.adapter.MainAdapter;
import com.bei.yd.ui.main.bean.MainBean;
import com.bei.yd.ui.main.bean.MainItemNewOrderBean;
import com.bei.yd.ui.main.bean.UserInfoBean;
import com.bei.yd.ui.main.presenter.iml.MainPresenterImpl;
import com.bei.yd.ui.main.view.IMainView;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.ToastUtil;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by wangchunlei on 3/28/16.
 */
public class MineFragment extends BaseLoadFragment implements View.OnClickListener, IMainView {
  //  设置按钮

  // 用户足迹
  @Bind(R.id.rv_wait_order) XRecyclerView rvList;
  private MainPresenterImpl mainPresenter;
  private MainAdapter adapter;
  private int pn;
  private ArrayList<MainBean> mainBeen;
  // 用户关注的达人
  //    @Bind(R.id.tv_mine_master)
  //    TextView mMater;
  // 用户活动
  //    @Bind(R.id.wantto)
  //    TextView mWantTo;
  // 用户的活动
  //    @Bind(R.id.tv_mine_activity)
  //    TextView mActivity;

  /**
   * 个人中心业务逻辑操作类
   */
  @Override protected void onLoadData() {
    mainPresenter.getAllNewWorkOrderList(1001,1001,1);
  }

  @Override public int getContentResouceId() {
    //        showStatusBar(false);
    return R.layout.fragment_main;
  }

  @Override public void dealLogicBeforeInitView() {
    mainPresenter = new MainPresenterImpl(getActivity(), this);
  }

  @Override public void dealLogicAfterInitView(View view) {
    //mFoot.setOnClickListener(this);
    //initRecyclerView();
    //mainBeen = new ArrayList<>();
    //for (int i = 0; i < 20; i++) {
    //  mainBeen.add(new MainBean(0,"测试       "+i));
    //}
    //adapter.updateItems(mainBeen);
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    if (!hidden) {
    }
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.bt_test:
        //mainPresenter.addWorkOrder("北京", 10000, "山西", 1245666);
        //ToastUtil.showNormalShortToast("测试");

        InvokeStartActivityUtils.startActivity(getActivity(), AddWorkOrderActivity.class,null,false);
        break;
    }
  }

  @Override public void onAddGD(MainBean bean) {

  }

  @Override public void onGetNewGDList(MainItemNewOrderBean bean) {
    adapter.updateItems(bean.getData());
  }

  @Override public void onLoginSuccess(UserInfoBean bean) {

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
      rvList.setAdapter(
          adapter == null ?  adapter= new MainAdapter(getActivity())
              : adapter);
      rvList.setPullRefreshEnabled(true);
      rvList.setLoadingMoreEnabled(true);
      //adapter.setOnItemClickListener(new adapter.OnItemListener() {
      //  @Override public void onItemClick(View view, int position) {
      //  }
      //});
      //rvList.setLoadingListener(new XRecyclerView.LoadingListener() {
      //  @Override public void onRefresh() {
      //    //上拉刷新
      //    pn = 1;
      //    onLoadData();
      //  }
      //
      //  @Override public void onLoadMore() {
      //    pn++;
      //    onLoadData();
      //  }
      //});
    }
  }
}
