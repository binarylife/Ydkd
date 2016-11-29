package com.bei.yd.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Bind;
import butterknife.OnClick;
import com.bei.yd.R;
import com.bei.yd.ui.base.fragment.BaseLoadFragment;
import com.bei.yd.ui.main.activity.AddWorkOrderActivity;
import com.bei.yd.ui.main.adapter.MainPagerAdapter;
import com.bei.yd.utils.Constant;
import com.bei.yd.utils.InvokeStartActivityUtils;
import com.bei.yd.utils.SharedPreferenceHelper;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.melnykov.fab.FloatingActionButton;

/**
 * Created by fb on 3/28/16.
 */
public class AboutFragment extends BaseLoadFragment implements View.OnClickListener {
  private Context context;

  @Override public void onAttach(Context context) {
    this.context = context;
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public int getContentResouceId() {
    return R.layout.fragment_about;
  }

  @Override public void dealLogicBeforeInitView() {

  }

  @Override public void dealLogicAfterInitView(View view) {
    initViews(view);
  }

  private void initViews(View view) {
    //tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
    //ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    //tvTitle.setText(MyUtils.getRoleByType(SharedPreferenceHelper.getUserRole()));
    LogUtils.loge("角色"+SharedPreferenceHelper.getUserRole());
    //if (SharedPreferenceHelper.getUserRole() == "A"
    //    || SharedPreferenceHelper.getUserRole() == "B") {
    //  mbtNewOrder.setVisibility(View.VISIBLE);
    //}else{
    //  mbtNewOrder.setVisibility(View.GONE);
    //}
    //tabLayout.setTabsFromPagerAdapter(adapter);
    //tabLayout.setti
  }

  @OnClick({
      //R.id.main_fab
  }) public void onClick(View v) {
    switch (v.getId()) {
      //case R.id.main_fab:
        //   跳转到新建工单
        //Bundle bundle = new Bundle();
        //bundle.putParcelable(Constant.ORDER_DETAIL, mainItemNewOrderBean);
        //bundle.putBoolean(Constant.isNewOreder, isNorOrder);
        //InvokeStartActivityUtils.startActivity(context, AddWorkOrderActivity.class, bundle, false);
        //break;
    }
  }

  @Override protected void onLoadData() {

  }

  public interface OnViewPagerCreated {
    void viewPagerCreated();
  }
}
