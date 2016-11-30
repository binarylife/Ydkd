package com.bei.yd.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.AddWorkOrderActivity;
import com.bei.yd.ui.main.adapter.MainPagerAdapter;
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.MyUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.melnykov.fab.FloatingActionButton;

/**
 * Created by fb on 3/28/16.
 */
public class MineFragment extends BaseLoadFragment implements View.OnClickListener {
  private Context context;

  @Bind(R.id.tab_layout) TabLayout tabLayout;
  //@Bind(R.id.title_name_tv) TextView tvTitle;
  @Bind(R.id.view_pager) ViewPager viewPager;
  @Bind(R.id.main_fab) FloatingActionButton mbtNewOrder;
  private MainPagerAdapter adapter;
  private boolean isNorOrder;
  private OnViewPagerCreated mOnViewPagerCreated;

  @Override public void onAttach(Context context) {
    this.context = context;
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public int getContentResouceId() {
    return R.layout.fragment_main;
  }

  @Override public void dealLogicBeforeInitView() {

  }

  @Override public void dealLogicAfterInitView(View view) {
    initViews(view);
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override public void onTabSelected(TabLayout.Tab tab) {
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        if (tab.getPosition() == 0) {
          isNorOrder = true;
          if (SharedPreferenceHelper.getUserRole().equals("A")) {
            //   一级派单 不能新建普通工单
            mbtNewOrder.setVisibility(View.GONE);
          }
        } else {
          isNorOrder = false;
        }
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }

  private void initViews(View view) {
    //tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    //ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    //tvTitle.setText(MyUtils.getRoleByType(SharedPreferenceHelper.getUserRole()));
    viewPager.setOffscreenPageLimit(2);
    adapter = new MainPagerAdapter(getChildFragmentManager(), context);
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
    LogUtils.loge("角色" + SharedPreferenceHelper.getUserRole());
    if (SharedPreferenceHelper.getUserRole().equals("A") || SharedPreferenceHelper.getUserRole()
        .equals("B")) {
      mbtNewOrder.setVisibility(View.VISIBLE);
    } else {
      mbtNewOrder.setVisibility(View.GONE);
    }
    //tabLayout.setTabsFromPagerAdapter(adapter);
    //tabLayout.setti
  }

  @OnClick({
      R.id.main_fab
  }) public void onClick(View v) {
    switch (v.getId()) {
      case R.id.main_fab:
        //   跳转到新建工单
        Bundle bundle = new Bundle();
        //bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
        bundle.putBoolean(Constant.isNewOreder, isNorOrder);
        InvokeStartActivityUtils.startActivity(context, AddWorkOrderActivity.class, bundle, false);
        break;
    }
  }

  @Override protected void onLoadData() {

  }

  public interface OnViewPagerCreated {
    void viewPagerCreated();
  }
}
