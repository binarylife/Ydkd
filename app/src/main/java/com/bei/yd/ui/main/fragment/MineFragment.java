package com.bei.yd.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.AddWorkOrderActivity;
import com.bei.yd.ui.main.adapter.MainPagerAdapter;
import com.bei.yd.utils.InvokeStartActivityUtils;

/**
 * Created by wangchunlei on 3/28/16.
 */
public class MineFragment extends BaseLoadFragment implements View.OnClickListener {
  private Context context;
  @Bind(R.id.tab_layout) TabLayout tabLayout;
  @Bind(R.id.view_pager) ViewPager viewPager;
  @Bind(R.id.bt_new_order) Button mbtNewOrder;
  private MainPagerAdapter adapter;

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
        //if (tab.getPosition() == 1) {
        //  fab.hide();
        //} else {
        //  fab.show();
        //}

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
    viewPager.setOffscreenPageLimit(3);
    adapter = new MainPagerAdapter(getChildFragmentManager(), context);
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
    //tabLayout.setti
  }

  @OnClick({
      R.id.bt_new_order
  }) public void onClick(View v) {
    switch (v.getId()) {
      case R.id.bt_new_order:
        //   跳转到新建工单
        InvokeStartActivityUtils.startActivity(context, AddWorkOrderActivity.class, null, false);
        break;
    }
  }

  @Override protected void onLoadData() {

  }

  public interface OnViewPagerCreated {
    void viewPagerCreated();
  }
}
